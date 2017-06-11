package com.example.jeonwoojin.captsone;

/**
 * Created by Jeon Woojin on 2017-06-11.
 */

public class SearchResultContent {
    String category, campus, status, time, contenttitle;

    public SearchResultContent(String category, String campus, String status, String time, String contenttitle){
        this.category = category;
        this.campus = campus;
        this.status = status;
        this.time  = time;
        this.contenttitle = contenttitle;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
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
