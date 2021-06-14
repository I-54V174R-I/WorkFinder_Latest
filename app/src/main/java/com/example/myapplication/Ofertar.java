package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class Ofertar extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button timeButton;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertar);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        timeButton = findViewById(R.id.timeButton);
    }
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);


            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;

        datePickerDialog = new DatePickerDialog(this, style, dataSetListener, year, month, day);
    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return getMonthFormat(month) + " " +dayOfMonth +" " +year;
    }

    private String getMonthFormat(int month) {
        if(month==1)
            return "Enero";
        if(month==2)
            return "Febrero";
        if(month==3)
            return "Marzo";
        if(month==4)
            return "Abril";
        if(month==5)
            return "Mayo";
        if(month==6)
            return "Junio";
        if(month==7)
            return "Julio";
        if(month==8)
            return "Agosto";
        if(month==9)
            return "Septiembre";
        if(month==10)
            return "Octubre";
        if(month==11)
            return "Noviembre";
        if(month==12)
            return "Diciembre";

        return "Enero";

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                minute = minute;
                hour = hourOfDay;
                timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute));
            }
        };
        int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,style ,onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select time");
        timePickerDialog.show();
    }
}