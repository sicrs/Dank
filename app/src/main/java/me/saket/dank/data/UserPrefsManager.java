package me.saket.dank.data;

import android.content.SharedPreferences;
import android.text.format.DateUtils;

/**
 * Used for accessing user's preferences.
 */
public class UserPrefsManager {

    private static final long DEFAULT_INTERVAL_FOR_MESSAGES_CHECK_MILLIS = DateUtils.MINUTE_IN_MILLIS * 30;

    private static final String KEY_DEFAULT_SUBREDDIT = "defaultSubreddit";
    private static final String KEY_UNREAD_MESSAGES_CHECK_INTERVAL_MILLIS = "unreadMessagesCheckInterval";

    private SharedPreferences sharedPrefs;

    public UserPrefsManager(SharedPreferences sharedPrefs) {
        this.sharedPrefs = sharedPrefs;
    }

    public String defaultSubreddit(String valueIfNull) {
        return sharedPrefs.getString(KEY_DEFAULT_SUBREDDIT, valueIfNull);
    }

    public void setDefaultSubreddit(String subredditName) {
        sharedPrefs.edit().putString(KEY_DEFAULT_SUBREDDIT, subredditName).apply();
    }

    public long unreadMessagesCheckIntervalMillis() {
        return sharedPrefs.getLong(KEY_UNREAD_MESSAGES_CHECK_INTERVAL_MILLIS, DEFAULT_INTERVAL_FOR_MESSAGES_CHECK_MILLIS);
    }

}