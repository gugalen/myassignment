package com.example.admin.myassignment.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myassignment.R;
import com.example.admin.myassignment.presenter.CreateUserPresenter;
import com.example.admin.myassignment.presenter.FetchUserPresenter;
import com.example.admin.myassignment.presenter.UserUpdateProfileContract;
import com.example.admin.myassignment.presenter.UserUpdateProfilePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

public class UserActivity extends AppCompatActivity implements UserUpdateProfileContract.View{

    private static final String TAG = "UserActivity";
    private static final String LOG_TAG = UserActivity.class.getSimpleName();

    private UserUpdateProfilePresenter userUpdateProfilePresenter;

    private void initPresenter() {
        userUpdateProfilePresenter = new UserUpdateProfilePresenter();
        userUpdateProfilePresenter.attachStorageReference(FirebaseStorage.getInstance().getReference());
        userUpdateProfilePresenter.attachFirebaseAuth(FirebaseAuth.getInstance());
        userUpdateProfilePresenter.attachView(this);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initPresenter();

        final EditText etName = findViewById(R.id.et_name);
        final EditText etContact = findViewById(R.id.et_contact);
        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUpdateProfilePresenter.updateUserDetails(etName.getText().toString(),etContact.getText().toString());
            }
        });
    }

    @Override
    public void onUserUpdateProfile() {
        Toast.makeText(UserActivity.this, "Update Successful",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUserUpdateProfileFailed() {
        Toast.makeText(UserActivity.this, "Update Failed",Toast.LENGTH_LONG).show();
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
