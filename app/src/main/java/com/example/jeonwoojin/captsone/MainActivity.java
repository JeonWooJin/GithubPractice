package com.example.jeonwoojin.captsone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    void onSKKUlinkButtonClicked(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://job.skku.edu"));
        startActivity(i);
    }
}
