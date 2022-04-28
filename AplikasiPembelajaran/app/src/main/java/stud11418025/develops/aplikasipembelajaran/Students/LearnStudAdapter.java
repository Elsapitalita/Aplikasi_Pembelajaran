package stud11418025.develops.aplikasipembelajaran.Students;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import stud11418025.develops.aplikasipembelajaran.Learning;
import stud11418025.develops.aplikasipembelajaran.R;

public class LearnStudAdapter extends ArrayAdapter<LearningStud> {
    private static final String LOG_TAG = LearnStudAdapter.class.getSimpleName();

    public LearnStudAdapter(Activity context, ArrayList<LearningStud> learn){
        super(context,0,learn);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Dessert} object located at this position in the list
        LearningStud currentDesert = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.matkul_name);
        // Get the version name from the current Dessert object and
        // set this text on the name TextView
        nameTextView.setText(currentDesert.getMatkul());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
