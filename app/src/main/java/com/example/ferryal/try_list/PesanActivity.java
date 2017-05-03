package com.example.ferryal.try_list;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PesanActivity extends AppCompatActivity {

    private TextView hartot;
    String tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        hartot = (TextView) findViewById(R.id.pesan);

        tot = hartot.getText().toString();


    }
}
