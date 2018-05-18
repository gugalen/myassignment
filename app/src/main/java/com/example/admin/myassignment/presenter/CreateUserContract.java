package com.example.admin.myassignment.presenter;


import com.example.admin.myassignment.model.UserDataModel;


public class CreateUserContract {
    public interface View extends BaseView {
        void onUserSaveSuccess();

        void onUserSaveFailed();

        void onError(String error);
    }

    public static abstract class Presenter extends BasePresenter<View> {
        public abstract void storeUser(UserDataModel userDataModel);
    }
}
