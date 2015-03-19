package com.hub60.hub60;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Mike Ritacco Work PC on 3/13/2015.
 */
public class SettingsNotificationsActivity extends Activity implements Post.Communicator {

    Context context;
    UserData userData;

    LinearLayout mainLayout, buttonHolder, allHolder, commentsHolder, frontpageHolder, mentionHolder, trendingHolder;
    RelativeLayout topLayout;
    TextView topText, backText, allText, commentsText, frontpageText, mentionText, trendingText;
    Switch allSwitch, commentsSwitch, frontpageSwitch, mentionSwitch, trendingSwitch;
    ImageView backArrow;

    final String UPLOAD_URL = "";

    int dpi, screenWidth, screenHeight;
    boolean allOn;
    boolean settingsChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main_layout);
        context = this;

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        dpi = (int) metrics.density;
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        userData = new UserData(this);

        createLayout();
        setListeners();

        setSwitches();

    }

    public void createLayout() {

        mainLayout = (LinearLayout)findViewById(R.id.settings_notifications_layout);
        buttonHolder = (LinearLayout)findViewById(R.id.settings_notifications_button_holder);
        allHolder = (LinearLayout)findViewById(R.id.settings_notifications_all_holder);
        commentsHolder = (LinearLayout)findViewById(R.id.settings_notifications_comments_holder);
        frontpageHolder = (LinearLayout)findViewById(R.id.settings_notifications_frontpage_holder);
        mentionHolder = (LinearLayout)findViewById(R.id.settings_notifications_mention_holder);
        trendingHolder = (LinearLayout)findViewById(R.id.settings_notifications_trending_holder);

        topLayout = (RelativeLayout)findViewById(R.id.settings_notifications_toplayout);

        topText = (TextView)findViewById(R.id.settings_notification_top_text);
        backText = (TextView)findViewById(R.id.settings_notifications_backtext);
        allText = (TextView)findViewById(R.id.settings_notifications_all_textview);
        commentsText = (TextView)findViewById(R.id.settings_notifications_comments_textview);
        frontpageText = (TextView)findViewById(R.id.settings_notifications_frontpage_text);
        mentionText = (TextView)findViewById(R.id.settings_notifications_mention_textview);
        trendingText = (TextView)findViewById(R.id.settings_notifications_trending_textview);

        allSwitch = (Switch)findViewById(R.id.settings_notifications_all_switch);
        commentsSwitch = (Switch)findViewById(R.id.settings_notifications_comments_switch);
        frontpageSwitch = (Switch)findViewById(R.id.settings_notifications_frontpage_switch);
        mentionSwitch = (Switch)findViewById(R.id.settings_notifications_mention_switch);
        trendingSwitch = (Switch)findViewById(R.id.settings_notifications_trending_switch);

        backArrow = (ImageView)findViewById(R.id.settings_notifications_backarrow);
    }

    public void setListeners() {

        buttonHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        allHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleAll();

            }
        });

        commentsHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleComments();
            }
        });

        frontpageHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFrontpage();
            }
        });

        mentionHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMention();
            }
        });

        trendingHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTrending();
            }
        });

    }

    public void gotResponse(JSONObject s) {
        String string = null;
        try {
            string = s.getString("results");
        }
        catch(JSONException e) {

        }
        if(string != null) {
            Toast.makeText(this, "Settings Updated", Toast.LENGTH_LONG).show();
            leaveActivity();

        }


    }

    public void setSwitches() {

        allOn = false;
        boolean commentsOn = false;
        boolean frontpageOn = false;
        boolean mentionOn = false;
        boolean trendingOn = false;


        commentsOn = Boolean.parseBoolean(userData.getComment_notification());
        frontpageOn = Boolean.parseBoolean(userData.getFront_page_notification());
        mentionOn = Boolean.parseBoolean(userData.getMention_notification());
        trendingOn = Boolean.parseBoolean(userData.getTrending_notification());

        if(commentsOn) {
            commentsSwitch.setChecked(true);
        }
        else {
            commentsSwitch.setChecked(false);
        }
        if(frontpageOn) {
            frontpageSwitch.setChecked(true);
        }
        else {
            frontpageSwitch.setChecked(false);
        }
        if(mentionOn) {
            mentionSwitch.setChecked(true);
        }
        else {
            mentionSwitch.setChecked(false);
        }
        if(trendingOn) {
            trendingSwitch.setChecked(true);
        }
        else {
            trendingSwitch.setChecked(false);
        }

        if(commentsOn && frontpageOn && mentionOn && trendingOn) {
            allOn = true;
            allSwitch.setChecked(true);
        }
        else {
            allOn = false;
            allSwitch.setChecked(false);
        }


    }

    public void leaveActivity() {

        Intent i = new Intent();
        if(settingsChanged) {
            setResult(RESULT_OK, i);

        }
        else {
            setResult(RESULT_CANCELED, i);
        }
        finish();
    }


    public void goBack() {

        if(settingsChanged) {
            uploadChanges();
        }
        else {
            leaveActivity();
        }

    }

    public void uploadChanges() {

        String comments = Boolean.toString(commentsSwitch.isChecked());
        String frontpage = Boolean.toString(frontpageSwitch.isChecked());
        String mention = Boolean.toString(mentionSwitch.isChecked());
        String trending = Boolean.toString(trendingSwitch.isChecked());

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("comments_notification", comments));
        nameValuePairs.add(new BasicNameValuePair("front_page_notification", frontpage));
        nameValuePairs.add(new BasicNameValuePair("mention_notification", mention));
        nameValuePairs.add(new BasicNameValuePair("trending_notification", trending));

        Post query = new Post();
        query.setCommunicator(this);
        query.executePosts(nameValuePairs, UPLOAD_URL);


    }

    public void toggleAll() {

        if(allOn) {
            commentsSwitch.setChecked(false);
            frontpageSwitch.setChecked(false);
            mentionSwitch.setChecked(false);
            trendingSwitch.setChecked(false);
            allSwitch.setChecked(false);
            allOn = false;
        }
        else {
            commentsSwitch.setChecked(true);
            frontpageSwitch.setChecked(true);
            mentionSwitch.setChecked(true);
            trendingSwitch.setChecked(true);
            allSwitch.setChecked(true);
            allOn = true;
        }

    }

    public void toggleComments() {

        commentsSwitch.toggle();
        settingsChanged = true;

    }

    public void toggleFrontpage() {

        frontpageSwitch.toggle();
        settingsChanged = true;

    }

    public void toggleMention() {

        mentionSwitch.toggle();
        settingsChanged = true;
    }

    public void toggleTrending() {

        trendingSwitch.toggle();
        settingsChanged = true;

    }

    @Override
    public void onBackPressed() {
        goBack();
    }



}
