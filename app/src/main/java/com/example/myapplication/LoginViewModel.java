package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Login_Poo;
import com.example.myapplication.model.UsersLogin;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> liveDataEmail= new MutableLiveData<>();
    public MutableLiveData<String> liveDataPassword= new MutableLiveData<>();
    private MutableLiveData<UsersLogin> usersLogin ;
    private MutableLiveData<UsersLogin> userMutableLiveData;
    Context context;
    public MutableLiveData<UsersLogin> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick() {

        UsersLogin loginUser = new UsersLogin(liveDataEmail.getValue(), liveDataPassword.getValue());

        userMutableLiveData.setValue(loginUser);
        Log.e("INFO", String.valueOf(loginUser.getUser()+"/"+loginUser.getPassword()));

    }

   /* public void onClick( ){
       //
        UsersLogin users= new UsersLogin();
        user.setUser(liveDataEmail.getValue());
        users.setPassword(liveDataPassword.getValue());
        Toast.makeText(context, user.getUser(), Toast.LENGTH_SHORT).show();
        //usersLogin.setValue(users);
    }*/

}
