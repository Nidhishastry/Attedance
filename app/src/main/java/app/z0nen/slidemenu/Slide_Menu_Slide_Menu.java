package app.z0nen.slidemenu;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by kumardivyarajat on 13/04/15.
 */
public class Slide_Menu_Slide_Menu extends Application {

    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "wR2JRt8IIJOYzPmYU8mOOIUVd3uu4L3EHxNzvzZA", "9jFohR85fuDaLgwcdDuDCdZBvW10QsThEop7MfvU");
    }
}
