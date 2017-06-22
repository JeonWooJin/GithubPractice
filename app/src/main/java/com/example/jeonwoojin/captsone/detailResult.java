package com.example.jeonwoojin.captsone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class detailResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailresult);
        class SearchResultContentAdapter extends BaseAdapter {
            ArrayList<SearchResultContent> items = new ArrayList<SearchResultContent>();

            public int getCount() {
                return items.size();
            }

            public void addItem(SearchResultContent item) {
                items.add(item);
            }

            public Object getItem(int position) {
                return items.get(position);
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View converView, ViewGroup viewGroup) {
                SearchResultContentView view = new SearchResultContentView(getApplicationContext());
                SearchResultContent item = items.get(position);
                view.setCompany(item.getCompany());
                view.setCampus(item.getCampus());
                view.setStatus(item.getStatus());
                view.setContenttitle(item.getContenttitle());
                view.setTime(item.getTime());

                return view;
            }
        }

        ListView listView;
        SearchResultContentAdapter listviewadapter;

        listView = (ListView) findViewById(R.id.ResultlistView);
        listviewadapter = new SearchResultContentAdapter();

        listviewadapter.addItem(new SearchResultContent("리크루팅", "인사캠", "종료", "인사캠 : 17.05.25 10:00 ~ 17:00",
                    "17년도 Naver 및 관계사 하계 인턴십 모집"));


        listView.setAdapter(listviewadapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);


        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.actionbar, null);

        actionBar.setCustomView(actionbar);
        return true;
    }

    void onBackButtonClicked(View v){
        finish();
    }
    void onHomeButtonClicked(View v){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(i);
    }
    void AddCalenderClicked(View v){
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        startActivity(i);
    }
}
