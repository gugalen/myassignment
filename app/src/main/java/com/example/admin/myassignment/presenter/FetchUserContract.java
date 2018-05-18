package com.example.admin.myassignment.presenter;

import com.example.admin.myassignment.model.UserDataModel;

public class FetchUserContract {
    public interface View extends BaseView {
        void onUserFetched(UserDataModel userDataModel);

        void onUserFetchedFailed();

        void onError(String error);
    }

    public static abstract class Presenter extends BasePresenter<View> {
        public abstract void getUserByEmail(String email);

        public abstract void getUserByFacebookId(String facebookId);
    }
}
