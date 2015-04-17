package app.z0nen.slidemenu.NavigationDrawerItems;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import app.z0nen.slidemenu.R;


public class menu2_Fragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);

       /* Spinner spinner = (Spinner) rootview.findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootview.getContext(), R.array.authors,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = parentView.getItemAtPosition(position).toString();
                Context context = parentView.getContext();
                CharSequence text = selected;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                TextView bk = (TextView) rootview.findViewById(R.id.bookText);

                switch (position) {
                    case 0:
                        bk.setText(getResources().getString(R.string.Allen));
                        break;
                    case 1:
                        bk.setText(getResources().getString(R.string.Thomas));
                        break;
                    case 2:
                        bk.setText(getResources().getString(R.string.Dan));
                        break;
                    case 3:
                        bk.setText(getResources().getString(R.string.Michael));
                        break;
                    case 4:
                        bk.setText(getResources().getString(R.string.Ravi));
                        break;
                    default:
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });*/
        ListView listview =(ListView)rootview.findViewById(R.id.listView);

        //EDITED Code
        String[] items = new String[] {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

        listview.setAdapter(adapter);
        return rootview;
    }


}