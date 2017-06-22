package com.example.jeonwoojin.captsone;

import android.content.Intent;
import android.net.Uri;
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

import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static String[] SpinnerArr1 = {"전체","취업설명회","리크루팅"};
    static String[] SpinnerArr2 = {"캠퍼스전체","인사캠","자과캠"};
    static String[] SpinnerArr3 = {"기업명+제목","기업명","제목"};
    static String DropDown1 = "전체";
    static String DropDown2 = "캠퍼스전체";
    static String DropDown3 = "기업명+제목";
    EditText searchinput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        InputStream inputStream = getResources().openRawResource(R.raw.re);
        CSVFile CSV1 = new CSVFile(inputStream);
        ArrayList<String[]> reMatrix = (ArrayList) CSV1.read();

        InputStream inputStream1 = getResources().openRawResource(R.raw.ch);
        CSVFile CSV2 = new CSVFile(inputStream1);
        ArrayList<String[]> chMatrix = (ArrayList) CSV2.read();


        class MainContentAdapter extends BaseAdapter {
            ArrayList<MainContent> items = new ArrayList<>();

            public int getCount() {
                return items.size();
            }

            public void addItem(MainContent item) {
                items.add(item);
            }

            public Object getItem(int position) {
                return items.get(position);
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View converView, ViewGroup viewGroup) {
                MainContentView view = new MainContentView(getApplicationContext());
                MainContent item = items.get(position);

                view.setCampus(item.getCampus());
                view.setContenttitle(item.getContenttitle());
                view.setTime(item.getTime());

                return view;
            }


        }

        final ListView listView;
        final MainContentAdapter listviewadapter;


        listviewadapter = new MainContentAdapter();

        for(int i = 0;i<6;i++){
                listviewadapter.addItem(new MainContent(reMatrix.get(i)[0],reMatrix.get(i)[1],reMatrix.get(i)[3]));
        }




        searchinput = (EditText) findViewById(R.id.SearchBoxInput);

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

        Button moreButton = (Button) findViewById(R.id.MoreButton);
        moreButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), searchresultactivity.class);
                i.putExtra("searchword",searchinput.getText().toString());
                i.putExtra("category",DropDown1);
                i.putExtra("campus",DropDown2);
                i.putExtra("content",DropDown3);
                startActivity(i);
            }
        });

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
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
                DropDown1 = spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown1 = "전체";
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DropDown2 = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown2 = "캠퍼스전체";
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DropDown3 = spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                DropDown3 = "기업명+제목";
            }
        });

        Button SkkuButton = (Button) findViewById(R.id.SKKULinkButton);
        SkkuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://job.skku.edu"));
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
        Button BackButton = (Button) findViewById(R.id.btnBack);
        BackButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button HomeButton = (Button) findViewById(R.id.btnhome);
        HomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(i);
            }
        });


        return true;
    }


    void onContentClicked(View v){
        Intent i = new Intent(getApplicationContext(), detailResult.class);
        startActivity(i);
    }

}


