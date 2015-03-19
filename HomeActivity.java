package com.hub60.hub60;


import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends Activity implements Post.Communicator {

    LinearLayout inputsHolder, inputsAnimHolder;
    ImageView logo, whiteline, whiteline2;
    EditText usernameInput, emailInput, passwordInput;
    Button resetPasswordBtn, signinBtn, signupBtn, fbSigninBtn, twSigninBtn;

    int screenWidth, screenHeight, dpi;

    boolean isSignUp = false;
    boolean isSignIn = true;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        dpi = (int) metrics.density;
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        createLayout();
        setListeners();




	}

    public void createLayout() {

        inputsHolder = (LinearLayout)findViewById(R.id.hp_inputs_holder);
        inputsAnimHolder = (LinearLayout)findViewById(R.id.hp_inputs_animlayout);

        logo = (ImageView)findViewById(R.id.hp_logo);
        whiteline = (ImageView)findViewById(R.id.hp_whiteline);
        whiteline2 = (ImageView)findViewById(R.id.hp_whiteline_2);

        usernameInput = (EditText)findViewById(R.id.hp_username_input);
        emailInput = (EditText)findViewById(R.id.hp_email_input);
        passwordInput = (EditText)findViewById(R.id.hp_password_input);

        resetPasswordBtn = (Button)findViewById(R.id.hp_button_resetpw);
        signinBtn = (Button)findViewById(R.id.hp_button_signin);
        signupBtn = (Button)findViewById(R.id.hp_button_signup);
        fbSigninBtn = (Button)findViewById(R.id.hp_button_fbsignin);
        twSigninBtn = (Button)findViewById(R.id.hp_button_twittersignin);

    }

    public void setListeners() {

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClicked();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupClicked();
            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinClicked();
            }
        });

        fbSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbSigninClicked();
            }
        });

        twSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twSigninClicked();
            }
        });
    }

    public void resetClicked() {

        goToResetPage();

    }

    public void signupClicked() {

        if (!isSignUp) {
            isSignUp = true;
            isSignIn = false;

            ViewGroup.LayoutParams params = inputsAnimHolder.getLayoutParams();
            params.height = 150 * dpi;
            inputsAnimHolder.setLayoutParams(params);

            ValueAnimator anim = ValueAnimator.ofInt(0, 50 * dpi);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int val = (Integer)animation.getAnimatedValue();
                    ViewGroup.LayoutParams params = emailInput.getLayoutParams();
                    params.height = val;
                    emailInput.setLayoutParams(params);

                }
            });

            anim.setDuration(500);
            anim.start();


            signupBtn.setText("Already Have An Account? Sign In!");

            signinBtn.setText("Sign Up");

            signinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signUp();
                }
            });
        }
        else {

            isSignUp = false;
            isSignIn = true;



            ValueAnimator anim = ValueAnimator.ofInt(50 * dpi, 0);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int val = (Integer)animation.getAnimatedValue();
                    ViewGroup.LayoutParams params = emailInput.getLayoutParams();
                    params.height = val;
                    emailInput.setLayoutParams(params);

                }
            });

            anim.setDuration(500);
            anim.start();


            ViewGroup.LayoutParams params = inputsAnimHolder.getLayoutParams();
            params.height = 100 * dpi;
            inputsAnimHolder.setLayoutParams(params);


            signupBtn.setText("Don't Have A Hub60 Account? Sign Up!");
            signinBtn.setText("Sign In");
            signinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signinClicked();
                }
            });
        }
    }



    public void signinClicked() {

        if(isSignUp) {
            //from the signup screen
            signUp();


        }
        else {
            //from the login screen
            signIn();
        }

    }

    public void fbSigninClicked() {

    }

    public void twSigninClicked() {

    }

    public void signUp() {
        String username = usernameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add(username);
        stringList.add(email);
        stringList.add(password);

        if(stringCheck(stringList)) {
            Post serverComm = new Post();
            serverComm.setCommunicator(this);

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("username", username));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            nameValuePairs.add(new BasicNameValuePair("email", email));

            serverComm.executePosts(nameValuePairs, "http://combustionlaboratory.com/hub/php/emailSignup.php");
        }


    }

    public void signIn() {

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(username);
        stringList.add(password);

        if(stringCheck(stringList)) {
            Post serverComm = new Post();
            serverComm.setCommunicator(this);

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("username", username));
            nameValuePairs.add(new BasicNameValuePair("password", password));

            serverComm.executePosts(nameValuePairs, "http://combustionlaboratory.com/hub/php/emailLogin.php");
        }

    }

    public boolean stringCheck(ArrayList<String> list) {

        for(int i=0; i<list.size(); i++) {
            String current = list.get(i);
            if(current.length() < 1) {

                return false;
            }
        }
        return true;

    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent data) {

        //Main page return
        if(requestCode == 1) {

        }
        //Reset Password return
        else if(requestCode == 2) {

        }
    }

    public void gotResponse(JSONObject s) {

        //Coming from signup or login form?
        if(isSignUp) {

            String status = "";
            String user_id = "";
            String username = "";
            String fb_id = "";
            String twitter_username = "";
            String twitter_id = "";
            String last_posted = "";
            String full_name = "";
            String f_name = "";
            String l_name = "";
            String email = "";
            String phone_number = "";
            String first_login = "";
            String last_login = "";
            String is_logged_in = "";
            String login_type = "";
            String facebook_sync = "";
            String sync_fb_id = "";
            String twitter_sync = "";
            String sync_twitter_id = "";
            String picture = "";
            String phonebook_sync = "";
            String push_notification = "";
            String save_to_roll = "";
            String fb_token = "";

            try {
                status = s.get("status").toString();
                user_id = s.get("user_id").toString();
                username = s.get("username").toString();
                fb_id = s.get("fb_id").toString();
                twitter_username = s.get("twitter_username").toString();
                twitter_id = s.get("twitter_id").toString();
                last_posted = s.get("last_posted").toString();
                full_name = s.get("full_name").toString();
                f_name = s.get("f_name").toString();
                l_name = s.get("l_name").toString();
                email = s.get("email").toString();
                phone_number = s.get("phone_number").toString();
                picture = s.get("picture").toString();
                phonebook_sync = s.get("phonebook_sync").toString();
                push_notification = s.get("push_notification").toString();
                save_to_roll = s.get("save_to_roll").toString();
                fb_token = s.get("fb_token").toString();
                first_login = s.get("first_login").toString();
                last_login = s.get("last_login").toString();
                is_logged_in = s.get("is_logged_in").toString();
                login_type = s.get("login_type").toString();
                facebook_sync = s.get("facebook_sync").toString();
                sync_fb_id = s.get("sync_fb_id").toString();
                twitter_sync = s.get("twitter_sync").toString();
                sync_twitter_id = s.get("sync_twitter_id").toString();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(status.equals("one")) {
                UserData userData = new UserData(this);
                userData.setUser_id(user_id);
                userData.setUsername(username);
                userData.setFb_id(fb_id);
                userData.setTwitter_username(twitter_username);
                userData.setTwitter_id(twitter_id);
                userData.setLast_posted(last_posted);
                userData.setFull_name(full_name);
                userData.setF_name(f_name);
                userData.setL_name(l_name);
                userData.setEmail(email);
                userData.setPhone_number(phone_number);
                userData.setPicture(picture);
                userData.setPhonebook_sync(phonebook_sync);
                userData.setPush_notifications(push_notification);
                userData.setSave_to_roll(save_to_roll);
                userData.setFb_token(fb_token);
                userData.setFirst_login(first_login);
                userData.setLast_login(last_login);
                userData.setIs_logged_in(is_logged_in);
                userData.setLogin_type(login_type);
                userData.setFacebook_sync(facebook_sync);
                userData.setSync_fb_id(sync_fb_id);
                userData.setTwitter_sync(twitter_sync);
                userData.setSync_twitter_id(sync_twitter_id);

                enterHub();
            }


        }
        //Coming from login form
        else {
            String status = "";
            String user_id = "";
            String username = "";
            String email = "";
            String bio = "";
            String picture = "";
            String comment_notification = "";
            String front_page_notification = "";
            String mention_notification = "";
            String trending_notification = "";
            String camera_roll_save = "";
            String fb_token = "";

            try {
                status = s.get("status").toString();
                user_id = s.get("user_id").toString();
                username = s.get("username").toString();
                email = s.get("email").toString();
                bio = s.get("bio").toString();
                picture = s.get("picture").toString();
                comment_notification = s.get("comment_notification").toString();
                front_page_notification = s.get("front_page_notification").toString();
                mention_notification = s.get("mention_notification").toString();
                trending_notification = s.get("trending_notification").toString();
                camera_roll_save = s.get("camera_roll_save").toString();
                fb_token = s.get("fb_token").toString();

            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            if(status.equals("one")) {
                UserData userData = new UserData(this);
                userData.setUser_id(user_id);
                userData.setUsername(username);
                userData.setEmail(email);
                userData.setBio(bio);
                userData.setPicture(picture);
                userData.setComment_notification(comment_notification);
                userData.setFront_page_notification(front_page_notification);
                userData.setMention_notification(mention_notification);
                userData.setTrending_notification(trending_notification);
                userData.setCamera_roll_save(camera_roll_save);
                userData.setFb_token(fb_token);
            }

            enterHub();



        }


    }

    public void enterHub() {

        Intent i = new Intent(this, MainPageActivity.class);

        startActivityForResult(i, 1);

    }

    public void goToResetPage() {

        Intent i = new Intent(this, ResetPasswordActivity.class);

        startActivityForResult(i, 2);
    }
	
}
