package com.example.admin.myassignment.utilities;

import com.pixplicity.easyprefs.library.Prefs;

public class UserPreferencesUtility {

    public static String IS_USER_LOGGED_IN = "is_user_logged_in";

    private static final UserPreferencesUtility ourInstance = new UserPreferencesUtility();

    public static UserPreferencesUtility getInstance() {
        return ourInstance;
    }

    private UserPreferencesUtility() {
    }

    public void setLoginUserData(boolean  isUserLogggedIn) {
        Prefs.putBoolean(IS_USER_LOGGED_IN, isUserLogggedIn);
    }
    public boolean isUserLoggedIn() {
        return Prefs.getBoolean(IS_USER_LOGGED_IN,false);
    }
}