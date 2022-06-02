package com.example.practical14;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Timer;
public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button date,time;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText) findViewById(R.id.editTextd);
        editText2=(EditText) findViewById(R.id.editTextt);
        date=(Button) findViewById(R.id.dateButton);
        time=(Button) findViewById(R.id.timeButton);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                final int year=calendar.get(Calendar.YEAR);
                final int month=calendar.get(Calendar.MONTH);
                final int day=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(MainActivity.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int
                                    dayOfMonth) {
                                editText1.setText(day+"-"+(month+1)+"-"+year);
                            }
                        },year,month,day);
                datePickerDialog.show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                final int hour=calendar.get(Calendar.HOUR);
                final int min=calendar.get(Calendar.MINUTE);
                TimePickerDialog timePicker=new
                        TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editText2.setText(hour+":"+min);
                    }
                },hour,min,true);
                timePicker.show();
            }
        });
    }
}