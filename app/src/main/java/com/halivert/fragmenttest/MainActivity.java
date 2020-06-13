package com.halivert.fragmenttest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private LoginFragment loginFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        loginFragment = LoginFragment.newInstance();
        fragmentTransaction.add(R.id.frameLayout, loginFragment);
        fragmentTransaction.commit();
    }

    public void sendName(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(
                R.id.frameLayout,
                MainFragment.newInstance(loginFragment.getName())
        );

        fragmentTransaction.commit();
    }
}