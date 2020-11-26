package com.example.assignment2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


// This is the file that configures the assignment2.xml file to output the correct commands.
class UIEditor : AppCompatActivity() {

    fun refreshScreenTrue(){
        Log.d("Claim Service", "Refreshing the Screen")
        var title : EditText = findViewById(R.id.title)
        var date : EditText = findViewById(R.id.date)

        var status: TextView = findViewById(R.id.status)
        status.text = "Claim ${title.text} was successfully created."
        date.text.clear()
        title.text.clear()

    }

    //Note since this runs when input fails it'll take a bit longer to register compared to refreshScreenTrue as Claim Service tries to detect what the error was.
    fun refreshScreenFalse(){
        Log.d("Claim Service", "Refreshing the Screen")
        var title : EditText = findViewById(R.id.title)
        var date : EditText = findViewById(R.id.date)

        var status: TextView = findViewById(R.id.status)
        status.text = "Claim ${title.text} failed to be created."
        date.text.clear()
        title.text.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.assignment2)
        val bView : Button = findViewById(R.id.button)
        var cService = ClaimServiceUi.getInstance(this)
     //  var cService = ClaimService.getInstance(this)

        bView.setOnClickListener{
            val date : EditText = findViewById(R.id.date)
            val title: EditText = findViewById(R.id.title)

            var t1: String = title.text.toString()
            var d1: String = date.text.toString()
            val cObj : Claim = Claim(t1, d1)

            cService.addClaim(cObj)

        }

    }


}