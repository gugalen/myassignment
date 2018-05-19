package com.example.admin.myassignment.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.myassignment.R;
import com.example.admin.myassignment.model.UserDataModel;
import com.example.admin.myassignment.presenter.FetchUserContract;
import com.example.admin.myassignment.presenter.FetchUserPresenter;
import com.example.admin.myassignment.utilities.FirebaseConstants;
import com.example.admin.myassignment.utilities.UserPreferencesUtility;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

public class ShowUserProfileActivity extends AppCompatActivity implements FetchUserContract.View{

    private FetchUserPresenter fetchUserPresenter;
    TextView tvName, tvContact, tvEmail;

    private void initPresenter() {
        fetchUserPresenter = new FetchUserPresenter();
        fetchUserPresenter.attachStorageReference(FirebaseStorage.getInstance().getReference());
        fetchUserPresenter.attachFirebaseAuth(FirebaseAuth.getInstance());
        fetchUserPresenter.attachView(this);

    }
    public static void start(Context context) {
        Intent intent = new Intent(context, ShowUserProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_profile);
        setTitle("User Details");
        initPresenter();

        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvContact = findViewById(R.id.tv_contact);
        findViewById(R.id.btn_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserActivity.start(ShowUserProfileActivity.this);
            }
        });

        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPreferencesUtility.getInstance(ShowUserProfileActivity.this).setLoginUserData(false);
                LoginActivity.start(ShowUserProfileActivity.this);
                ShowUserProfileActivity.this.finish();
            }
        });

        fetchUserPresenter.getUserByEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());
    }

    @Override
    public void onUserFetched(UserDataModel userDataModel) {
        tvName.setText(userDataModel.getUserName());
        tvEmail.setText(userDataModel.getUserEmail());
        tvContact.setText(userDataModel.getContactNumber());
    }

    @Override
    public void onUserFetchedFailed() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void dismissLoadingView() {

    }

    @Override
    public void showNetworkError() {

    }
}
