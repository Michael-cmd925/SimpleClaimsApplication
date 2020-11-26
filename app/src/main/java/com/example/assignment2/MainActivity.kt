package com.example.assignment2

import android.appwidget.AppWidgetManager.getInstance
import android.media.MediaRouter2.getInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//This is the version of the program that is completely hard programmed not using the layout .xml file.
class MainActivity : AppCompatActivity() {

    lateinit var cList: MutableList<Claim>
    var cService : ClaimService = ClaimService.getInstance(this)

    //refresh screen's job is to clear title and date after the user presses add button.

    fun refreshScreenTrue(){
        Log.d("Claim Service", "Refreshing the Screen")
        var title : EditText = findViewById(R.id.title)
        var date : EditText = findViewById(R.id.date)

        var status: TextView = findViewById(R.id.status)
        status.text = "Claim ${title.text} was successfully created."
        date.text.clear()
        title.text.clear()

    }

    //Note since this runs when input fails it'll take a bit longer to register compared to refreshScreenTrue
    fun refreshScreenFalse(){
        Log.d("Claim Service", "Refreshing the Screen")
        var title : EditText = findViewById(R.id.title)
        var date : EditText = findViewById(R.id.date)

        var status: TextView = findViewById(R.id.status)
        status.text = "Claim ${title.text} failed to be created."
        date.text.clear()
        title.text.clear()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val program  = ProgramLayout(this).generate()
        setContentView(program)

        val bView : Button = findViewById(R.id.add_btn)
        val bView2: Button = findViewById(R.id.add_btn)
        //Need to create an instance of ClaimService so that I can keep track on whether or not add succeeded or not.
        val date : EditText = findViewById(R.id.date)
        val title: EditText = findViewById(R.id.title)


        bView.setOnClickListener{
            var t1: String = title.text.toString()
            var d1: String = date.text.toString()
            val cObj : Claim = Claim(t1, d1)
            cService.addClaim(cObj)
        }


    }
}