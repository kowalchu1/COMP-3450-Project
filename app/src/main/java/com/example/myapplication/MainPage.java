package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button timeButton = findViewById(R.id.TimeButton);
        Button drillButton = findViewById(R.id.DrillButton);
        Button eventButton = findViewById(R.id.EventButton);
        FloatingActionButton share = findViewById(R.id.Share);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //This is for sharing the file/data to the athlete
                Intent intentShareFile = new Intent(Intent.ACTION_SEND);
                File fileWithinMyDir = new File(/*Empty till database is created*/);

                if(fileWithinMyDir.exists()) {
                    intentShareFile.setType("application/pdf");
                    intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:// //File goes here"));

                    intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                            "Sharing File...");
                    intentShareFile.putExtra(Intent.EXTRA_TEXT, "Sharing File...");

                    startActivity(Intent.createChooser(intentShareFile, "Share File"));
                }

            }
        });
    }
}