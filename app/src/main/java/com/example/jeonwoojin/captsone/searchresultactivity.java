package com.example.jeonwoojin.captsone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class searchresultactivity extends AppCompatActivity {
    String[] SpinnerArr1 = {"전체","취업설명회","리크루팅"};
    String[] SpinnerArr2 = {"캠퍼스전체","인사캠","자과캠"};
    String[] SpinnerArr3 = {"기업명+제목","기업명","제목"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.searchresult);
            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            // 스피너 이용 드롭다운
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    SpinnerArr1
            );
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    SpinnerArr2
            );
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    SpinnerArr3
            );
            // 어뎁터 이용, 드롭다운 메뉴 내용

            spinner1.setAdapter(adapter1);
            spinner2.setAdapter(adapter2);
            spinner3.setAdapter(adapter3);
            // 어뎁터 세팅
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

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
                    view.setCategory(item.getCategory());
                    view.setCampus(item.getCampus());
                    view.setStatus(item.getStatus());
                    view.setContenttitle(item.getContenttitle());
                    view.setTime(item.getTime());

                    return view;
                }
            }

            ListView listView;
            SearchResultContentAdapter listviewadapter;

            listView = (ListView) findViewById(R.id.listView);
            listviewadapter = new SearchResultContentAdapter();
            for (int i = 0; i < 5; i++) {
                listviewadapter.addItem(new SearchResultContent("리크루팅", "인사캠", "종료", "인사캠 : 17.05.25 10:00 ~ 17:00",
                        "17년도 Naver 및 관계사 하계 인턴십 모집" + i));
            }

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
}


