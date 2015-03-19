package com.hub60.hub60;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ResetPasswordActivity extends Activity implements Post.Communicator {

    LinearLayout main_layout, inputs_holder;
    ImageView logo;
    EditText emailInput;
    Button resetBtn, cancelBtn;

    boolean wasReset = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reset_password);

        setLayout();
        setListeners();


	}

    public void setLayout() {

        main_layout = (LinearLayout)findViewById(R.id.reset_password_layout);
        inputs_holder = (LinearLayout)findViewById(R.id.rp_inputs_holder);

        logo = (ImageView)findViewById(R.id.rp_logo);
        emailInput = (EditText)findViewById(R.id.rp_email_input);
        resetBtn = (Button)findViewById(R.id.rp_button_resetpw);
        cancelBtn = (Button)findViewById(R.id.rp_button_cancel);

    }

    public void setListeners() {

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

    }

    public boolean stringCheck() {

        String email = emailInput.getText().toString();
        if(email.length() < 1) {
            return false;
        }

        return true;
    }

    public void resetPassword() {

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        if(stringCheck()) {
            String user = emailInput.getText().toString();
            if(user.contains("@")) {
                nameValuePairs.add(new BasicNameValuePair("email", user));
            }
            else {
                nameValuePairs.add(new BasicNameValuePair("username", user));
            }

            Post serverComm = new Post();
            serverComm.setCommunicator(this);

            serverComm.executePosts(nameValuePairs, "http://combustionlaboratory.com/hub/php/forgotPW.php");

        }


    }

    public void goBack() {

        Intent i = new Intent();

        if(wasReset) {
            setResult(RESULT_OK, i);

        }
        else {
            setResult(RESULT_CANCELED, i);

        }

        finish();



    }

    public void gotResponse(JSONObject s) {

        String status = "";
        try {
            status = s.get("status").toString();
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        if(status.equals("one")) {
            Toast.makeText(this, "New Password Emailed", Toast.LENGTH_LONG).show();
            wasReset = true;
            goBack();
        }

    }
	
}
