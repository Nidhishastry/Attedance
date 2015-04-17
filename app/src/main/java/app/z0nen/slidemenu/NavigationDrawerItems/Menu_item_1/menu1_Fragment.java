package app.z0nen.slidemenu.NavigationDrawerItems.Menu_item_1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.z0nen.slidemenu.R;


public class menu1_Fragment extends Fragment {
    FragmentPagerAdapter adapterViewPager;
    View rootview;
    private FragmentActivity myContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
      //  ViewPager vpPager = (ViewPager) getActivity().findViewById(R.id.vpPager);
     //   FragmentManager fragManager = myContext.getSupportFragmentManager();
      //  adapterViewPager = new MyPagerAdapter(fragManager);
      //  vpPager.setAdapter(adapterViewPager);
      //  fragment.getView().setBackgroundColor(Color.WHITE);
        rootview.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_200));


        return rootview;
    }
}
   /* public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
          Fragment fragment;
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                   fragment = new menu1_Fragment_fragment();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    fragment = new menu1_Fragment_fragment();
                case 2: // Fragment # 1 - This will show SecondFragment
                    fragment = new menu1_Fragment_fragment();
                default:
                    return null;
            }
            return fragment;
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }


    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}*/
