package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener(){
            try {


                val calWeight = inputWeight.text.toString().toDouble()
                val calHeight = inputHeight.text.toString().toDouble()
                val bmi: Double = calWeight / Math.pow((calHeight / 100), 2.0)
                val status: String

                if (bmi < 18.5) {
                    empt.setImageResource(R.drawable.under)
                    status = "Under"
                }
                else if (bmi >= 18.5 && bmi <= 24.9) {
                    empt.setImageResource(R.drawable.normal)
                    status = "Normal"
                }
                else  {
                    empt.setImageResource(R.drawable.over)
                    status = "Over"
                }
                bmiOut.text = ":%.2f(%s)".format(bmi,status)


            }catch(ex:Exception){

               val toast:Toast= Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }

        reset.setOnClickListener(){
            empt.setImageResource(R.drawable.empty)
            bmiOut.text=""
            inputWeight.setText("")
            inputHeight.setText("")
        }
    }
}
