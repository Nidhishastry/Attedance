package app.z0nen.slidemenu.NavigationDrawerItems.Menu_item_1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.z0nen.slidemenu.R;

/**
 * Created by kumardivyarajat on 13/04/15.
 */
public class menu1_Fragment_fragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static menu1_Fragment_fragment newInstance(int page, String title) {
        menu1_Fragment_fragment fragmentFirst = new menu1_Fragment_fragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu1_fragment_layout, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvlabel);
        tvLabel.setText(page + " -- " + title);
        return view;
    }

}
