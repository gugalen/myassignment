package com.example.admin.myassignment.presenter;

import com.example.admin.myassignment.model.UserDataModel;

public class UserUpdateProfileContract {
    public interface View extends BaseView {
        void onUserUpdateProfile();
        void onUserUpdateProfileFailed();
        void onError(String error);
    }
    public static abstract class Presenter extends BasePresenter<View> {
        public abstract void updateUserDetails(String name, String contact);
    }
}
