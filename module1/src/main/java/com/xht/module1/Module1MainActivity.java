package com.xht.module1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xht.annotations.Route;

@Route(path = "/module1/main")
public class Module1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1_main);
    }
}
