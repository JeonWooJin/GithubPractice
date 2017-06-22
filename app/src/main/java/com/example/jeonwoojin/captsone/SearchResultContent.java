package com.example.jeonwoojin.captsone;

/**
 * Created by Jeon Woojin on 2017-06-11.
 */

public class SearchResultContent {
    String company, campus, status, time, contenttitle;

    public SearchResultContent( String campus, String company,  String contenttitle, String time, String status){
        this.company = company;
        this.campus = campus;
        this.status = status;
        this.time  = time;
        this.contenttitle = contenttitle;
    }

    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
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
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
