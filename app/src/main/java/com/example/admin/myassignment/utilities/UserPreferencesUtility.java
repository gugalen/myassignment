package com.example.admin.myassignment.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import com.pixplicity.easyprefs.library.Prefs;

public class UserPreferencesUtility {

    public static String IS_USER_LOGGED_IN = "is_user_logged_in";
    private static UserPreferencesUtility userPreferencesUtility;
    private SharedPreferences sharedPreferences;

    public static UserPreferencesUtility getInstance(Context context) {
        if (userPreferencesUtility == null) {
            userPreferencesUtility = new UserPreferencesUtility(context);
        }
        return userPreferencesUtility;
    }

    private UserPreferencesUtility(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPreferencesUtility",Context.MODE_PRIVATE);
    }

    public void setLoginUserData(boolean isUserLogggedIn) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putBoolean(IS_USER_LOGGED_IN, isUserLogggedIn);
        prefsEditor.commit();
    }
    public boolean isUserLoggedIn() {
        if (sharedPreferences!= null) {
            return sharedPreferences.getBoolean(IS_USER_LOGGED_IN,false);
        }
        return false;
    }
}