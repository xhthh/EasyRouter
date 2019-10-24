package com.xht.easyrouter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.xht.annotations.Route;
import com.xht.api.EasyRouter;

@Route(path = "/main/main")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn_1);

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                toModule1();
                break;
        }
    }

    private void toModule1() {
        EasyRouter.getInstance().build("/module1/main").navigation();
    }
}
