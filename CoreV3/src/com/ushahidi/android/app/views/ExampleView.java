package com.ushahidi.android.app.views;

import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * ExampleView
 *
 *  All the widgets for /res/layout/example.xml
 */
public class ExampleView extends View {
    
    public ExampleView(FragmentActivity activity) {
        super(activity);
    }

    //@Widget(R.id.example_label)
    public TextView label;

    //@Widget(R.id.example_value)
    public EditText value;
}
