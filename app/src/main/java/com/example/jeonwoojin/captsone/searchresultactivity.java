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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class searchresultactivity extends AppCompatActivity {
    String[] SpinnerArr1 = {"전체","취업설명회","리크루팅"};
    String[] SpinnerArr2 = {"캠퍼스전체","인사캠","자과캠"};
    String[] SpinnerArr3 = {"기업명+제목","기업명","제목"};
    static String DropDown1 = "전체";
    static String DropDown2 = "캠퍼스전체";
    static String DropDown3 = "기업명+제목";
    EditText searchinput;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.searchresult);
            searchinput = (EditText) findViewById(R.id.SearchBoxInput);

            InputStream inputStream = getResources().openRawResource(R.raw.re);
            CSVFile CSV1 = new CSVFile(inputStream);
            String[][] reMatrix;
            reMatrix = CSV1.read().clone();

            /*String filename = "re.csv";
            int filerowcount = 0;
            try {
                Scanner input = new Scanner(new File(filename));

                while(input.hasNext()){
                    filerowcount++;
                }
                input.close();

            }catch (FileNotFoundException e){
                finish();
                e.printStackTrace();
            }
            String[][] recruitarr = new String[filerowcount][6];

            try{
                int inputflag = 0;
                Scanner input = new Scanner(new File(filename));
                while(input.hasNext()){
                    String temp = input.nextLine();
                    String[] temparr = temp.split(",");
                    for(int i = 0;i<temparr.length;i++){
                        recruitarr[inputflag][i] = temparr[i];
                    }
                    inputflag++;
                }
                input.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            */
            Intent previnput = getIntent();
            String presearchinput = previnput.getStringExtra("searchword");
            DropDown1 = previnput.getStringExtra("category");
            DropDown2 = previnput.getStringExtra("campus");
            DropDown3 = previnput.getStringExtra("content");

            searchinput.setText(presearchinput);

            Button searchButton = (Button) findViewById(R.id.SearchButton);
            searchButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent i = new Intent(getApplicationContext(), searchresultactivity.class);
                    i.putExtra("searchword",searchinput.getText().toString());
                    i.putExtra("category",DropDown1);
                    i.putExtra("campus",DropDown2);
                    i.putExtra("content",DropDown3);
                    startActivity(i);
                }
            });

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

        // 어뎁터 이용, 드롭다운 메뉴 내용 연결

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        // 어뎁터 세팅
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DropDown1 = SpinnerArr1[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown1 = "전체";
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DropDown2 = SpinnerArr2[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown2 = "캠퍼스전체";
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DropDown3 = SpinnerArr3[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown3 = "기업명+제목";
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

            listView = (ListView) findViewById(R.id.SearchlistView);
            listviewadapter = new SearchResultContentAdapter();

            for (int i = 0; i < 5; i++) {
                listviewadapter.addItem(new SearchResultContent(reMatrix[i][0],reMatrix[i][1],reMatrix[i][2],reMatrix[i][3],reMatrix[i][4]));


            }

            listView.setAdapter(listviewadapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getApplicationContext(), detailResult.class);

                    startActivity(i);
                }
            });
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
    void onContentClicked(View v){
        Intent i = new Intent(getApplicationContext(), detailResult.class);
        startActivity(i);
    }
}


