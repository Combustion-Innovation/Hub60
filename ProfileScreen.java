package com.hub60.hub60;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Mike on 2/23/2015.
 */
public class ProfileScreen extends LinearLayout {

    Context context;
    LayoutInflater mInflater;

    public ProfileScreen(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.isInEditMode();
    }

    public ProfileScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.isInEditMode();

    }

    public ProfileScreen(Context context) {
        super(context);
        this.context = context;
        this.isInEditMode();
        if(!isInEditMode()) {

        }



    }



}
