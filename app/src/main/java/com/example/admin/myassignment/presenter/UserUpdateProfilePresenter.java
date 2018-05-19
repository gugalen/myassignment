package com.example.admin.myassignment.presenter;

import android.net.Uri;
import android.util.Log;

import com.example.admin.myassignment.model.UserDataModel;
import com.example.admin.myassignment.utilities.FirebaseConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class UserUpdateProfilePresenter extends UserUpdateProfileContract.Presenter{
    private static final String TAG = "UserUpdateProfilePresenter";
    private UserUpdateProfileContract.View view;
    private FirebaseAuth firebaseAuth;

    @Override
    public void attachView(UserUpdateProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void attachStorageReference(StorageReference storageReference) {
    }

    @Override
    public void attachFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void updateUserDetails(final String name, final String contact) {
        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        Query query = FirebaseDatabase.getInstance().getReference(FirebaseConstants.User.TABLE_NAME)
                .orderByChild(FirebaseConstants.User.USER_EMAIL)
                .equalTo(currentUser.getEmail());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getRef().child(FirebaseConstants.User.USER_NAME).setValue(name);
                    snapshot.getRef().child(FirebaseConstants.User.CONTACT_NUMBER).setValue(contact);
                    Log.e(LOG_TAG, "updateUserTableData onDataChange  :" + snapshot.toString());
                }
                view.dismissLoadingView();
                view.onUserUpdateProfile();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(LOG_TAG, "updateUserTableData onCancelled :" + databaseError.getDetails());
            }
        });
    }
}