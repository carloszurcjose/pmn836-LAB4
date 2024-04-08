package com.cruzurc.pmn836_lab4;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.cruzurc.pmn836_lab4.model.CrewMember;
import com.cruzurc.pmn836_lab4.model.Starship;

import java.util.ArrayList;

/**
 * @author pmn836 Carlos Cruz
 * Adapter class for handling the display of starships in a RecyclerView.
 * It binds the CrewMember data to the View items for each starship in the list.
 */

public class StarshipActivityAdapter extends RecyclerView.Adapter<StarshipActivityAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CrewMember> localDataSet;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout outerLayout;
        private final ImageView imageViewPerson;
        private final LinearLayout innerLayout;
        private final TextView textViewTop;
        private final TextView textViewBottom;

        /**
         * Constructor for the ViewHolder, finds and stores references to the necessary views.
         *
         * @param view The itemView within the RecyclerView.
         */

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            outerLayout = (LinearLayout) view.findViewById(R.id.linear_layout_outer);
            imageViewPerson = (ImageView) view.findViewById(R.id.image_view_person);
            innerLayout = (LinearLayout) view.findViewById(R.id.linear_layout_inner);
            textViewTop = (TextView) view.findViewById(R.id.text_view_top);
            textViewBottom = (TextView) view.findViewById(R.id.text_view_bottom);
        }

        public LinearLayout getOuterLayout() {
            return outerLayout;
        }

        public ImageView getImageViewPerson() {
            return imageViewPerson;
        }

        public LinearLayout getInnerLayout() {
            return innerLayout;
        }

        public TextView getTextViewTop() {
            return textViewTop;
        }

        public TextView getTextViewBottom() {
            return textViewBottom;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public StarshipActivityAdapter(Context context, ArrayList<CrewMember> dataSet) {
        this.context = context;
        localDataSet = dataSet;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.starship_activity_recycler_view, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        CrewMember member = localDataSet.get(position);
        Drawable drawable = ContextCompat.getDrawable(context, member.getId());
        viewHolder.getImageViewPerson().setImageDrawable(drawable);
        viewHolder.getTextViewTop().setText(member.getPosition());
        viewHolder.getTextViewBottom().setText(member.getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

