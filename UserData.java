package com.hub60.hub60;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mike on 2/20/2015.
 */
public class UserData {

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    Context context;

    //SharedPrefs keys/strings
    String user_id;
    String username;
    String fb_id;
    String twitter_username;
    String twitter_id;
    String last_posted;
    String full_name;
    String f_name;
    String l_name;
    String email;
    String phone_number;
    String picture;
    String phonebook_sync;
    String push_notifications;
    String save_to_roll;
    String fb_token;
    String bio;
    String comment_notification;
    String front_page_notification;
    String mention_notification;
    String trending_notification;
    String camera_roll_save;
    String first_login;
    String last_login;
    String is_logged_in;
    String login_type;
    String facebook_sync;
    String sync_fb_id;
    String twitter_sync;
    String sync_twitter_id;

    public UserData(Context context) {

        this.context = context;
        this.sharedPrefs = context.getSharedPreferences("hub60", Context.MODE_PRIVATE);

    }

    public String getTwitter_sync() {
        this.twitter_sync = sharedPrefs.getString("twitter_sync", null);
        return twitter_sync;
    }

    public void setTwitter_sync(String twitter_sync) {
        editor = sharedPrefs.edit();
        editor.putString("twitter_sync", twitter_sync);
        editor.commit();
        editor = null;
        this.twitter_sync = twitter_sync;
    }

    public String getSync_twitter_id() {
        this.sync_twitter_id = sharedPrefs.getString("sync_twitter_id", null);
        return sync_twitter_id;
    }

    public void setSync_twitter_id(String sync_twitter_id) {
        editor = sharedPrefs.edit();
        editor.putString("sync_twitter_id", sync_twitter_id);
        editor.commit();
        editor = null;
        this.sync_twitter_id = sync_twitter_id;
    }



    public String getBio() {
        this.bio = sharedPrefs.getString("bio", null);
        return bio;
    }

    public void setBio(String bio) {
        editor = sharedPrefs.edit();
        editor.putString("bio", bio);
        editor.commit();
        editor = null;
        this.bio = bio;
    }

    public String getComment_notification() {
        this.comment_notification = sharedPrefs.getString("comment_notification", null);
        return comment_notification;
    }

    public void setComment_notification(String comment_notification) {
        editor = sharedPrefs.edit();
        editor.putString("comment_notification", comment_notification);
        editor.commit();
        editor = null;
        this.comment_notification = comment_notification;
    }

    public String getFront_page_notification() {
        this.front_page_notification = sharedPrefs.getString("front_page_notification", null);
        return front_page_notification;
    }

    public void setFront_page_notification(String front_page_notification) {
        editor = sharedPrefs.edit();
        editor.putString("front_page_notification", front_page_notification);
        editor.commit();
        editor = null;
        this.front_page_notification = front_page_notification;
    }

    public String getMention_notification() {
        this.mention_notification = sharedPrefs.getString("mention_notification", null);
        return mention_notification;
    }

    public void setMention_notification(String mention_notification) {
        editor = sharedPrefs.edit();
        editor.putString("mention_notification", mention_notification);
        editor.commit();
        editor = null;
        this.mention_notification = mention_notification;
    }

    public String getTrending_notification() {
        this.trending_notification = sharedPrefs.getString("trending_notification", null);
        return trending_notification;
    }

    public void setTrending_notification(String trending_notification) {
        editor = sharedPrefs.edit();
        editor.putString("trending_notification", trending_notification);
        editor.commit();
        editor = null;
        this.trending_notification = trending_notification;
    }

    public String getCamera_roll_save() {
        this.camera_roll_save = sharedPrefs.getString("camera_roll_save", null);
        return camera_roll_save;
    }

    public void setCamera_roll_save(String camera_roll_save) {
        editor = sharedPrefs.edit();
        editor.putString("camera_roll_save", camera_roll_save);
        editor.commit();
        editor = null;
        this.camera_roll_save = camera_roll_save;
    }

    public String getFirst_login() {
        this.first_login = sharedPrefs.getString("first_login", null);
        return first_login;
    }

    public void setFirst_login(String first_login) {
        editor = sharedPrefs.edit();
        editor.putString("first_login", first_login);
        editor.commit();
        editor = null;
        this.first_login = first_login;
    }

    public String getLast_login() {
        this.last_login = sharedPrefs.getString("last_login", null);
        return last_login;
    }

    public void setLast_login(String last_login) {
        editor = sharedPrefs.edit();
        editor.putString("last_login", last_login);
        editor.commit();
        editor = null;
        this.last_login = last_login;
    }

    public String getIs_logged_in() {
        this.is_logged_in = sharedPrefs.getString("is_logged_in", null);
        return is_logged_in;
    }

    public void setIs_logged_in(String is_logged_in) {
        editor = sharedPrefs.edit();
        editor.putString("is_logged_in", is_logged_in);
        editor.commit();
        editor = null;
        this.is_logged_in = is_logged_in;
    }

    public String getLogin_type() {
        this.login_type = sharedPrefs.getString("login_type", null);
        return login_type;
    }

    public void setLogin_type(String login_type) {
        editor = sharedPrefs.edit();
        editor.putString("login_type", login_type);
        editor.commit();
        editor = null;
        this.login_type = login_type;
    }

    public String getFacebook_sync() {
        this.facebook_sync = sharedPrefs.getString("facebook_sync", null);
        return facebook_sync;
    }

    public void setFacebook_sync(String facebook_sync) {
        editor = sharedPrefs.edit();
        editor.putString("facebook_sync", null);
        editor.commit();
        editor = null;
        this.facebook_sync = facebook_sync;
    }

    public String getSync_fb_id() {
        this.sync_fb_id = sharedPrefs.getString("sync_fb_id", null);
        return sync_fb_id;
    }

    public void setSync_fb_id(String sync_fb_id) {
        editor = sharedPrefs.edit();
        editor.putString("sync_fb_id", sync_fb_id);
        editor.commit();
        editor = null;
        this.sync_fb_id = sync_fb_id;
    }



    public String getUser_id() {
        this.user_id = sharedPrefs.getString("user_id", null);
        return user_id;
    }

    public void setUser_id(String user_id) {
        editor = sharedPrefs.edit();
        editor.putString("user_id", user_id);
        editor.commit();
        editor = null;
        this.user_id = user_id;
    }

    public String getUsername() {
        this.username = sharedPrefs.getString("username", null);
        return username;
    }

    public void setUsername(String username) {
        editor = sharedPrefs.edit();
        editor.putString("username", username);
        editor.commit();
        editor = null;
        this.username = username;
    }

    public String getFb_id() {
        this.fb_id = sharedPrefs.getString("fb_id", null);
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        editor = sharedPrefs.edit();
        editor.putString("fb_id", fb_id);
        editor.commit();
        editor = null;
        this.fb_id = fb_id;
    }

    public String getTwitter_username() {
        this.twitter_username = sharedPrefs.getString("twitter_username", null);
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        editor = sharedPrefs.edit();
        editor.putString("twitter_username", twitter_username);
        editor.commit();
        editor = null;
        this.twitter_username = twitter_username;
    }

    public String getTwitter_id() {
        this.twitter_id = sharedPrefs.getString("twitter_id", null);
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        editor = sharedPrefs.edit();
        editor.putString("twitter_id", twitter_id);
        editor.commit();
        editor = null;
        this.twitter_id = twitter_id;
    }

    public String getLast_posted() {
        this.last_posted = sharedPrefs.getString("last_posted", null);
        return last_posted;
    }

    public void setLast_posted(String last_posted) {
        editor = sharedPrefs.edit();
        editor.putString("last_posted", last_posted);
        editor.commit();
        editor = null;
        this.last_posted = last_posted;
    }

    public String getFull_name() {
        this.full_name = sharedPrefs.getString("full_name", null);
        return full_name;
    }

    public void setFull_name(String full_name) {
        editor = sharedPrefs.edit();
        editor.putString("full_name", full_name);
        editor.commit();
        editor = null;
        this.full_name = full_name;
    }

    public String getF_name() {
        this.f_name = sharedPrefs.getString("f_name", null);
        return f_name;
    }

    public void setF_name(String f_name) {
        editor = sharedPrefs.edit();
        editor.putString("f_name", f_name);
        editor.commit();
        editor = null;
        this.f_name = f_name;
    }

    public String getL_name() {
        this.l_name = sharedPrefs.getString("l_name", null);
        return l_name;
    }

    public void setL_name(String l_name) {
        editor = sharedPrefs.edit();
        editor.putString("l_name", l_name);
        editor.commit();
        editor = null;
        this.l_name = l_name;
    }

    public String getEmail() {
        this.email = sharedPrefs.getString("email", null);
        return email;
    }

    public void setEmail(String email) {
        editor = sharedPrefs.edit();
        editor.putString("email", email);
        editor.commit();
        editor = null;
        this.email = email;
    }

    public String getPhone_number() {
        this.phone_number = sharedPrefs.getString("phone_number", null);
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        editor = sharedPrefs.edit();
        editor.putString("phone_number", phone_number);
        editor.commit();
        editor = null;
        this.phone_number = phone_number;
    }

    public String getPicture() {
        this.picture = sharedPrefs.getString("picture", null);
        return picture;
    }

    public void setPicture(String picture) {
        editor = sharedPrefs.edit();
        editor.putString("picture", picture);
        editor.commit();
        editor = null;
        this.picture = picture;
    }

    public String getPhonebook_sync() {
        this.phonebook_sync = sharedPrefs.getString("phonebook_sync", null);
        return phonebook_sync;
    }

    public void setPhonebook_sync(String phonebook_sync) {
        editor = sharedPrefs.edit();
        editor.putString("phonebook_sync", phonebook_sync);
        editor.commit();
        editor = null;
        this.phonebook_sync = phonebook_sync;
    }

    public String getPush_notifications() {
        this.push_notifications = sharedPrefs.getString("push_notifications", null);
        return push_notifications;
    }

    public void setPush_notifications(String push_notifications) {
        editor = sharedPrefs.edit();
        editor.putString("push_notifications", push_notifications);
        editor.commit();
        editor = null;
        this.push_notifications = push_notifications;
    }

    public String getSave_to_roll() {
        this.save_to_roll = sharedPrefs.getString("save_to_roll", null);
        return save_to_roll;
    }

    public void setSave_to_roll(String save_to_roll) {
        editor = sharedPrefs.edit();
        editor.putString("save_to_roll", save_to_roll);
        editor.commit();
        editor = null;
        this.save_to_roll = save_to_roll;
    }

    public String getFb_token() {
        this.fb_token = sharedPrefs.getString("fb_token", null);
        return fb_token;
    }

    public void setFb_token(String fb_token) {
        editor = sharedPrefs.edit();
        editor.putString("fb_token", fb_token);
        editor.commit();
        editor = null;
        this.fb_token = fb_token;
    }
}