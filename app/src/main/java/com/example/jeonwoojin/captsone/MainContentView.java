package com.example.jeonwoojin.captsone;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainContentView extends LinearLayout{

    TextView campus;

    TextView contenttitle;
    TextView time;

    public MainContentView(Context context){
        super(context);
        init(context);
    }

    public MainContentView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singleresultlist, this, true);

        campus = (TextView) findViewById(R.id.campus);

        contenttitle = (TextView) findViewById(R.id.contenttitle);
        time = (TextView) findViewById(R.id.time);
    }

    public void setCampus(String campus){
        this.campus.setText(campus);
    }
    public void setContenttitle(String contenttitle){
        this.contenttitle.setText(contenttitle);
    }
    public void setTime(String time){
        this.time.setText(time);
    }


}
