package com.example.admin.myassignment.presenter;

public interface BaseView {
    void showLoadingView();
    void dismissLoadingView();
    void showNetworkError();
}