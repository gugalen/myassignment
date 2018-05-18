package com.example.admin.myassignment.model;


import android.util.Log;

import com.example.admin.myassignment.utilities.FirebaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDataModel  implements Serializable {
    String userId;
    String userEmail;
    String userName;
    String contactNumber;
    public UserDataModel() {
    }

    public UserDataModel(String userId, String userEmail, String userName, String contactNumber) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.contactNumber= contactNumber;
    }

    public UserDataModel(DataSnapshot snapshot) {
        this.userId = snapshot.child(FirebaseConstants.User.USER_ID).getValue().toString();
        if(snapshot.child(FirebaseConstants.User.USER_EMAIL) != null) {
            this.userEmail = snapshot.child(FirebaseConstants.User.USER_EMAIL).getValue().toString();
        }
        this.userName = snapshot.child(FirebaseConstants.User.USER_NAME).getValue().toString();
        this.contactNumber = snapshot.child(FirebaseConstants.User.CONTACT_NUMBER).getValue().toString();

    }

    public UserDataModel(HashMap<String, Object> snapshot) {

        this.userId = snapshot.get(FirebaseConstants.User.USER_ID).toString();
        this.userEmail = snapshot.get(FirebaseConstants.User.USER_EMAIL).toString();
        this.userName = snapshot.get(FirebaseConstants.User.USER_NAME).toString();
        this.contactNumber = snapshot.get(FirebaseConstants.User.CONTACT_NUMBER).toString();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

  @Exclude
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(FirebaseConstants.User.USER_ID, userId);
        result.put(FirebaseConstants.User.USER_EMAIL, userEmail);
      result.put(FirebaseConstants.User.USER_NAME, userName);
      result.put(FirebaseConstants.User.CONTACT_NUMBER, contactNumber);
        return result;
    }


    @Exclude
    @Override
    public String toString() {
        return "UserDataModel{" +
                "userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userEmail='" + userName + '\'' +
                ", userEmail='" + contactNumber + '\'' +
                '}';
    }
}
