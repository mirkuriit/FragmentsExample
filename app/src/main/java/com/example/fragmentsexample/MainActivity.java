package com.example.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button currButton, complButton, repeatButton;
    CurrentTaskFragment currentTaskFragment;
    CompleteTaskFragment completeTaskFragment;
    RepeatTaskFragment repeatTaskFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currButton = findViewById(R.id.curr_button);
        complButton = findViewById(R.id.copml_button);
        repeatButton = findViewById(R.id.repeat_button);

        completeTaskFragment = new CompleteTaskFragment();
        currentTaskFragment = new CurrentTaskFragment();
        repeatTaskFragment = new RepeatTaskFragment();
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.container, repeatTaskFragment);
            ft.commit();
        }
        complButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container, currentTaskFragment);
                ft.commit();
            }
        });
        currButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container, completeTaskFragment);
                ft.commit();
            }
        });
        repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container, repeatTaskFragment);
                ft.commit();
            }
        });
    }
}