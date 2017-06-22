package com.example.jeonwoojin.captsone;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchResultContentView extends LinearLayout{
    TextView company;
    TextView campus;
    TextView status;
    TextView contenttitle;
    TextView time;

    public SearchResultContentView(Context context){
        super(context);
        init(context);
    }

    public SearchResultContentView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singleresultlist, this, true);
        company = (TextView) findViewById(R.id.company);
        campus = (TextView) findViewById(R.id.campus);
        status = (TextView) findViewById(R.id.status);
        contenttitle = (TextView) findViewById(R.id.contenttitle);
        time = (TextView) findViewById(R.id.time);
    }

    public void setCompany(String company){
        this.company.setText(company);
    }
    public void setCampus(String campus){
        this.campus.setText(campus);
    }
    public void setStatus(String status){
        this.status.setText(status);
    }
    public void setContenttitle(String contenttitle){
        this.contenttitle.setText(contenttitle);
    }
    public void setTime(String time){
        this.time.setText(time);
    }


}
