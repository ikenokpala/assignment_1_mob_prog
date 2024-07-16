package com.example.assignment1_mob_prog

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.thefirst)
        val edtxt2: EditText = findViewById(R.id.thesecond)
        val resultTV: TextView = findViewById(R.id.textResult)

        var flag : String = "sum"
        // spinner items
        var spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("sum","multiply","divide","subtract","mean")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener() {view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt()

            if(flag == "sum")
                resultTV.text = sum(x,y).toString();
            else if (flag == "multiply")
                resultTV.text = multiply(x,y).toString()
            else if(flag == "subtract")
                resultTV.text = subtract(x,y).toString()
            else if (flag == "mean" )
                resultTV.text = mean(x,y).toString()

            if(flag == "divide" && x>y )
                resultTV.text = divide(x,y).toString()
            else
                println("Can't perform action")

        }


        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                // p2 is the index of selected item }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //     TODO("Not yet implemented")
            }
        }
        }

    public fun sum(a: Int, b: Int): Int{return a+b;}
    public fun multiply(a: Int, b: Int): Int{return a*b;}
    public fun divide(a: Int, b: Int): Int {return a/b;}
    public fun subtract(a: Int, b: Int): Int {return a-b;}
    public fun mean(a: Int, b: Int): Int {return (a+b)/2;}

}