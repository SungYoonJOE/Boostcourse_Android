package com.example.hahajsu.listviewstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Student> studentList = new ArrayList<Student>();

    public ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_student, parent, false);
        }

        TextView textName = (TextView)convertView.findViewById(R.id.student_name);
        TextView textAge = (TextView)convertView.findViewById(R.id.student_age);
        TextView textMajor = (TextView)convertView.findViewById(R.id.student_major);

        Student student = studentList.get(position);

        textName.setText(student.getName());
        textAge.setText(student.getAge()+"");
        textMajor.setText(student.getMajor());
        return convertView;
    }

    public void addItem(String name, int age, String major){
        Student student = new Student();

        student.setName(name);
        student.setAge(age);
        student.setMajor(major);

        studentList.add(student);
    }
}
