package app.z0nen.slidemenu.NavigationDrawerItems;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.z0nen.slidemenu.R;

/**
 * Created by kumardivyarajat on 12/04/15.
 */
public class menu4_Fragment extends Fragment {
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu4_layout, container, false);
        return rootview;
    }

}
