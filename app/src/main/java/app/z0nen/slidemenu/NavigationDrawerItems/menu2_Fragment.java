package app.z0nen.slidemenu.NavigationDrawerItems;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.z0nen.slidemenu.R;


public class menu2_Fragment extends Fragment {
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        rootview.setBackgroundColor(getResources().getColor(R.color.ripple_material_light));

        return rootview;
    }
}
