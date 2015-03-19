package com.hub60.hub60;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mike Ritacco Work PC on 3/12/2015.
 */
public class SettingsActivity extends Activity {

    Context context;

    LinearLayout mainLayout, notificationHolder, infoHolder, passwordHolder, backButtonLayout, cameraSaveHolder, midSpacer, aboutHolder, termsHolder, ourAppsHolder, contactHolder, bottomSpacer, logoutHolder;
    RelativeLayout topLayout;
    ImageView backArrow, notificationArrow, infoArrow, passwordArrow, cameraArrow, aboutArrow, termsArrow;
    TextView titleText, backText, notificationText, infoText, passwordText, cameraText, aboutText, termsText, ourAppsText, contactText;
    Button logoutBtn;

    int dpi, screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main_layout);
        context = this;

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        dpi = (int) metrics.density;
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        createLayout();
        setListeners();


    }

    public void createLayout() {

        mainLayout = (LinearLayout)findViewById(R.id.settings_main_base_layout);
        notificationHolder = (LinearLayout)findViewById(R.id.settings_notification_holder);
        infoHolder = (LinearLayout)findViewById(R.id.settings_info_holder);
        passwordHolder = (LinearLayout)findViewById(R.id.settings_password_holder);
        backButtonLayout = (LinearLayout)findViewById(R.id.settings_back_button);
        cameraSaveHolder = (LinearLayout)findViewById(R.id.settings_camerasave_holder);
        midSpacer = (LinearLayout)findViewById(R.id.settings_midspacer);
        aboutHolder = (LinearLayout)findViewById(R.id.settings_about_holder);
        termsHolder = (LinearLayout)findViewById(R.id.settings_terms_holder);
        ourAppsHolder = (LinearLayout)findViewById(R.id.settings_ourapps_holder);
        bottomSpacer = (LinearLayout)findViewById(R.id.settings_btmspacer);
        logoutHolder = (LinearLayout)findViewById(R.id.settings_logout_holder);
        contactHolder = (LinearLayout)findViewById(R.id.settings_contact_holder);

        topLayout = (RelativeLayout)findViewById(R.id.settings_top_layout);

        backArrow = (ImageView)findViewById(R.id.settings_back_arrow);
        notificationArrow = (ImageView)findViewById(R.id.settings_notification_arrow);
        infoArrow = (ImageView)findViewById(R.id.settings_info_arrow);
        passwordArrow = (ImageView)findViewById(R.id.settings_password_arrow);
        cameraArrow = (ImageView)findViewById(R.id.settings_camera_arrow);
        aboutArrow = (ImageView)findViewById(R.id.settings_about_arrow);
        termsArrow = (ImageView)findViewById(R.id.settings_terms_arrow);

        titleText = (TextView)findViewById(R.id.settings_title_text);
        backText = (TextView)findViewById(R.id.settings_back_text);
        notificationText = (TextView)findViewById(R.id.tabbar_notification_text);
        infoText = (TextView)findViewById(R.id.settings_info_textview);
        passwordText = (TextView)findViewById(R.id.settings_password_textview);
        cameraText = (TextView)findViewById(R.id.settings_camera_textview);
        aboutText = (TextView)findViewById(R.id.settings_about_textview);
        termsText = (TextView)findViewById(R.id.settings_terms_textview);
        ourAppsText = (TextView)findViewById(R.id.settings_ourapps_textview);
        contactText = (TextView)findViewById(R.id.settings_contact_textview);

        logoutBtn = (Button)findViewById(R.id.settings_logout_button);


    }

    public void setListeners() {

        notificationHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNotifications();
            }
        });

        infoHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEditInfo();
            }
        });

        passwordHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChangePassword();
            }
        });

        cameraSaveHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCameraRoll();
            }
        });

        aboutHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });

        termsHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTerms();
            }
        });

        ourAppsHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToApps();
            }
        });

        contactHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContact();
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogout();
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent data) {

        if(requestCode == 1) {
            //Settings->Notifications return

        }
        else if (requestCode == 2) {
            //Settings->Edit Info return

        }
        else if(requestCode == 3) {
            //Settings->Change Password return

        }
        else if(requestCode == 4) {
            //Settings->Camera Roll return

        }
        else if(requestCode == 5) {
            //Settings->About return

        }
        else if(requestCode == 6) {
            //Settings->Terms return

        }
        else if(requestCode == 7) {
            //Settings->Contact return

        }




    }

    public void goToNotifications() {
        Intent i = new Intent(this, SettingsNotificationsActivity.class);
        startActivityForResult(i, 1);

    }

    public void goToEditInfo() {
        Intent i = new Intent(this, SettingsEditInfoActivity.class);
        startActivityForResult(i, 2);

    }

    public void goToChangePassword() {
        Intent i = new Intent(this, ResetPasswordActivity.class);
        startActivityForResult(i, 3);

    }

    public void goToCameraRoll() {
        Intent i = new Intent(this, CameraRollActivity.class);
        startActivityForResult(i, 4);

    }

    public void goToAbout() {
        Intent i = new Intent(this, AboutActivity.class);
        startActivityForResult(i, 5);

    }

    public void goToTerms() {
        Intent i = new Intent(this, TermsActivity.class);
        startActivityForResult(i, 6);
    }

    public void goToApps() {
        Uri uri = Uri.parse("applocation");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);

    }

    public void goToContact() {
        Intent i = new Intent(this, ContactActivity.class);
        startActivityForResult(i, 7);

    }

    public void goToLogout() {



    }

}
