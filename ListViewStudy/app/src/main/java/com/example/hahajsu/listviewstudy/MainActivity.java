package com.example.hahajsu.listviewstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_res);

        adapter = new ListViewAdapter();

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        adapter.addItem("김민지", 21, "경영학과");
        adapter.addItem("이지민", 26, "컴퓨터공학과");
        adapter.addItem("박수진", 24, "경영학과");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student)parent.getItemAtPosition(position);

                String name = student.getName();
                int age = student.getAge();
                String major = student.getMajor();

                textView.setText("이름: "+name+"  나이: "+age+"\n전공: "+major);
            }
        });

    }
}
