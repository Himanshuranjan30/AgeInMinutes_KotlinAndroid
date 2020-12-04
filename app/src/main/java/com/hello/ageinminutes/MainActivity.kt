package com.hello.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but= findViewById<Button>(R.id.button)
        but.setOnClickListener {
            view->clickDatePicker(view)
            Toast.makeText(this,"Pick a Date",Toast.LENGTH_LONG).show() }


    }

    fun clickDatePicker(view:View){
        
        var mycalendar= Calendar.getInstance()
        val year= mycalendar.get(Calendar.YEAR)
        val month= mycalendar.get(Calendar.MONTH)
        val day= mycalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this,"The choosen year is $selectedyear,the month is ${selectedmonth+1} and the day is $selecteddayOfMonth",Toast.LENGTH_LONG)

            val selecteddate= "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            val textid= findViewById<TextView>(R.id.tvSelectedDate)
            textid.setText(selecteddate)

            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate= sdf.parse(selecteddate)

            val selectedDateinminutes= theDate!!.time/60000

            val currentdate= sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentdateinminutes= currentdate!!.time/60000;

            val output= currentdateinminutes-selectedDateinminutes

            val textid2= findViewById<TextView>(R.id.tvSelectedDateInMinutes)

            textid2.setText(output.toString())
                                                                 },year,month,day).show()
        
    }
}