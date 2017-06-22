package com.example.jeonwoojin.captsone;

/**
 * Created by Jeon Woojin on 2017-06-11.
 */

public class MainContent {
    String campus, time, contenttitle;

    public MainContent(String campus, String company, String contenttitle){
        this.campus = campus;
        this.time  = time;
        this.contenttitle = contenttitle;
    }

    public String getCampus(){
        return campus;
    }
    public void setCampus(String campus){
        this.campus = campus;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getContenttitle(){
        return contenttitle;
    }
    public void setContenttitle(String contenttitle){
        this.contenttitle = contenttitle;
    }

}
