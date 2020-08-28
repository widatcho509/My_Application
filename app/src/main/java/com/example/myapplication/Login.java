package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.model.UsersLogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Login extends AppCompatActivity {
    LoginViewModel loginViewModel;
    ActivityLoginBinding   binding;
    String HttpUrl="https://weedy-android.000webhostapp.com/ips/Practice/login.php";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        //loginViewModel= ViewModelProviders.of(this, new LoginViewModelFactory(Login.this,new UsersLogin(liveDataEmail.getValue(), liveDataPassword.getValue()))).get(LoginViewModel.class);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

       // binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);
       // setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
       loginViewModel.getUser().observe(this, new Observer<UsersLogin>() {
            @Override
            public void onChanged(UsersLogin usersLogin) {
             /*   if (TextUtils.isEmpty(Objects.requireNonNull(usersLogin).getUser())){
                    binding.etUsername.setError("Please enter your ID number");
                    binding.etUsername.requestFocus();
                }else if (!TextUtils.isEmpty(Objects.requireNonNull(usersLogin).getUser()) && !usersLogin.isEmailValid()) {
                    binding.etUsername.setError("Enter a Valid ID number");
                    binding.etUsername.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(usersLogin).getPassword())) {
                    binding.etPassword.setError("Enter a Password");
                    binding.etPassword.requestFocus();
                }
                else if (!usersLogin.isPasswordLengthGreaterThan5()) {
                    binding.etPassword.setError("Enter at least 6 Digit password");
                    binding.etPassword.requestFocus();
                }
                else {*/
                    String userId,userPassword;
                    userId=usersLogin.getUser();
                    userPassword=usersLogin.getPassword();
                    binding.etUsername.setText(usersLogin.getUser());
                    binding.etPassword.setText(usersLogin.getPassword());
                    FunctionLogin(userId,userPassword);
              //  }
            }
        });
    }

    private void FunctionLogin(String userId, String password) {
      StringRequest request = new StringRequest(Request.Method.POST, HttpUrl, response -> {
        Log.e("RESP",response);
      }, error -> {

      }){
          @Override
          protected Map<String, String> getParams() throws AuthFailureError {
              HashMap<String,String> parametro=new HashMap<>();
              parametro.put("userID",userId);
              parametro.put("userPass",password);
              parametro.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
              parametro.put("Content-Type", "application/json");
              parametro.put("Accept", "application/json");

              return parametro;
          }
      };
      RequestQueue queue= Volley.newRequestQueue(this);
      queue.add(request);

        //Toast.makeText(this, userId+"///"+password, Toast.LENGTH_SHORT).show();
    }
}