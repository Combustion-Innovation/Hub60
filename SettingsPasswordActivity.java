package com.hub60.hub60;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Mike Ritacco Work PC on 3/20/2015.
 */
public class SettingsPasswordActivity extends Activity implements Post.Communicator {

    LinearLayout mainLayout, newpassHolder, confirmpassHolder, submitBtnHolder, backBtnHolder;
    RelativeLayout spacer;
    TextView backText, titleText;
    EditText newpassInput, confirmpassInput;
    Button submitButton, saveButton;
    ImageView backArrow;


    final String UPDATE_URL = "";


    boolean wasChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        setLayout();
        setListeners();
    }



    public void setLayout() {

        mainLayout = (LinearLayout)findViewById(R.id.settings_changepassword_layout);
        newpassHolder = (LinearLayout)findViewById(R.id.settings_changepassword_newpass_holder);
        confirmpassHolder = (LinearLayout)findViewById(R.id.settings_changepassword_confirmpass_holder);
        submitBtnHolder = (LinearLayout)findViewById(R.id.settings_changepassword_submitbtn_holder);
        backBtnHolder = (LinearLayout)findViewById(R.id.settings_changepassword_button_holder);

        spacer = (RelativeLayout)findViewById(R.id.settings_changepassword_spacer);

        backText = (TextView)findViewById(R.id.settings_changepassword_back_text);
        titleText = (TextView)findViewById(R.id.settings_changepassword_title_text);

        newpassInput = (EditText)findViewById(R.id.settings_changepassword_newpass_edittext);
        confirmpassInput = (EditText)findViewById(R.id.settings_changepassword_confirmpass_edittext);

        submitButton = (Button)findViewById(R.id.settings_changepassword_submit_button);
        backArrow = (ImageView)findViewById(R.id.settings_changepassword_back_button);

    }

    public void setListeners() {

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitClicked();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClicked();
            }
        });

        backBtnHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

    }

    public void submitClicked() {

        String newPass = newpassInput.getText().toString();
        String confirmPass = confirmpassInput.getText().toString();

        if(newPass.equals(confirmPass)) {

            ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
            nameValuePair.add(new BasicNameValuePair("password", newPass));

            Post updateDB = new Post();
            updateDB.setCommunicator(this);
            updateDB.executePosts(nameValuePair, UPDATE_URL);
        }
        else {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();

        }

    }

    public void saveClicked() {



    }

    public void goBack() {

        Intent i = new Intent();
        if(wasChanged) {
            setResult(RESULT_OK, i);

        }
        else {
            setResult(RESULT_CANCELED, i);
        }

        finish();


    }

    public void gotResponse(JSONObject s) {

        try {
            if (s.getString("result").equals("one")) {

                wasChanged = true;
                Toast.makeText(this, "Password Changed", Toast.LENGTH_LONG).show();
                goBack();
            }
        }
        catch(JSONException e) {

        }

    }


}
