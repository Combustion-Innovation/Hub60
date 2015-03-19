package com.hub60.hub60;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mike Ritacco Work PC on 3/13/2015.
 */
public class SettingsEditInfoActivity extends Activity {

    Context context;

    LinearLayout mainLayout, backbuttonHolder, nameHolder, usernameHolder, genderHolder, ageHolder, locationHolder, emailHolder;
    RelativeLayout topLayout;
    TextView titleText, backText, nameText, usernameText, genderText, ageText, emailText;
    EditText nameEdit, usernameEdit, genderEdit, ageEdit, emailEdit;
    Button saveButton;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_editinfo_layout);
        context = this;

        createLayout();
        setListeners();

    }


    public void createLayout() {

        mainLayout = (LinearLayout)findViewById(R.id.settings_editinfo_mainlayout);
        backbuttonHolder = (LinearLayout)findViewById(R.id.settings_editinfo_backbutton_holder);
        nameHolder = (LinearLayout)findViewById(R.id.settings_editinfo_name_holder);
        usernameHolder = (LinearLayout)findViewById(R.id.settings_editinfo_username_holder);
        genderHolder = (LinearLayout)findViewById(R.id.settings_editinfo_gender_holder);
        ageHolder = (LinearLayout)findViewById(R.id.settings_editinfo_age_holder);
        locationHolder = (LinearLayout)findViewById(R.id.settings_editinfo_location_holder);
        emailHolder = (LinearLayout)findViewById(R.id.settings_editinfo_email_holder);

        topLayout = (RelativeLayout)findViewById(R.id.settings_editinfo_toplayout);

        titleText = (TextView)findViewById(R.id.settings_editinfo_title_textview);
        backText = (TextView)findViewById(R.id.settings_editinfo_backtext);
        nameText = (TextView)findViewById(R.id.settings_editinfo_name_text);
        usernameText = (TextView)findViewById(R.id.settings_editinfo_username_text);
        genderText = (TextView)findViewById(R.id.settings_editinfo_gender_text);
        ageText = (TextView)findViewById(R.id.settings_editinfo_age_text);
        emailText = (TextView)findViewById(R.id.settings_editinfo_email_text);

        nameEdit = (EditText)findViewById(R.id.settings_editinfo_name_edittext);
        usernameEdit = (EditText)findViewById(R.id.settings_editinfo_username_edittext);
        genderEdit = (EditText)findViewById(R.id.settings_editinfo_gender_edittext);
        ageEdit = (EditText)findViewById(R.id.settings_editinfo_age_edittext);
        emailEdit = (EditText)findViewById(R.id.settings_editinfo_email_edittext);

        saveButton = (Button)findViewById(R.id.settings_editinfo_savebutton);

        backArrow = (ImageView)findViewById(R.id.settings_editinfo_backarrow);
    }

    public void setListeners() {

        nameHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEdit.callOnClick();
            }
        });

        usernameHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEdit.callOnClick();
            }
        });

        genderHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderEdit.callOnClick();
            }
        });

        ageHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ageEdit.callOnClick();
            }
        });

        emailHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailEdit.callOnClick();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

        backbuttonHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

    }


    public void updateProfile() {

    }

    public void goBack() {

    }
}
