package com.example.assignment2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.provider.ContactsContract
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop


//This files purpose is to create the gui for users to input claims into the database.
class ProgramLayout (val ctx : Context) {

    fun generate() : LinearLayout{

        //First set up vertical linear layout obj.
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL

        //Set up header for the program.
        var hlayoutObj = LinearLayout(ctx)
        var hlParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        hlayoutObj.layoutParams = hlParams
        hlayoutObj.orientation = LinearLayout.HORIZONTAL

        val header = TextView(ctx)
        header.text = "Please Enter Claim Information"
        header.textSize = 18F
        header.typeface = Typeface.DEFAULT_BOLD
        header.setTextColor(Color.BLACK)
        val headerParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        headerParams.gravity = Gravity.CENTER
        layoutObj.addView(header, headerParams)



        //Now we set up a horizontal linear layout to hold title textview and edit text
         hlayoutObj = LinearLayout(ctx)
         hlParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        hlayoutObj.layoutParams = hlParams
        hlayoutObj.orientation = LinearLayout.HORIZONTAL

        //set up textview object for title
        var lblView = TextView(ctx)
        lblView.text = "Title"
        lblView.typeface = Typeface.DEFAULT_BOLD
        lblView.gravity = Gravity.CENTER
        var lbParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        hlayoutObj.addView(lblView, lbParams)
        //
        // Now setup edittext to allow user to input claim title
        var valView = EditText(ctx)
        valView.gravity = Gravity.START
        valView.id = R.id.title
        var vParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.weight = 2.0F
        vParams.width = 0
        hlayoutObj.addView(valView, vParams)
        layoutObj.addView(hlayoutObj)

        // Stuff for date now

        hlayoutObj = LinearLayout(ctx)
        hlParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        hlayoutObj.layoutParams = hlParams
        hlayoutObj.orientation = LinearLayout.HORIZONTAL
        //
        // TextView to print date
        lblView = TextView(ctx)
        lblView.text = "Date"
        lblView.typeface = Typeface.DEFAULT_BOLD
        lblView.gravity = Gravity.CENTER
        lbParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        hlayoutObj.addView(lblView, lbParams)
        //
        // Now we create an edittext so that the user can input the claim's date.
        valView = EditText(ctx)
        valView.id = R.id.date
        valView.gravity = Gravity.START
        vParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.weight = 2.0F
        vParams.width = 0
        hlayoutObj.addView(valView, vParams)
        layoutObj.addView(hlayoutObj)


        // Button Implementation
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_btn)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.END
        layoutObj.addView(nButton, nbParams)

        //Finally we set up another horizontal layout to contain two viewtext for status
        hlayoutObj = LinearLayout(ctx)
        var hParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        hlayoutObj.layoutParams = hParams
        hlayoutObj.orientation = LinearLayout.HORIZONTAL
        //
        //set up textview to print "Status"
        var hlblView = TextView(ctx)
        hlblView.text = "Status: "
        hlblView.typeface = Typeface.DEFAULT_BOLD
        hlblView.gravity = Gravity.CENTER
        var hlbParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT)
        hlbParams.weight = 1.0F
        hlayoutObj.addView(hlblView, hlbParams)
        //
        // Set up text view to show to user the result of adding a claim to the database (whether it failed or succeeded)/
        val hlblView2 = TextView(ctx)
        hlblView2.text = "<Status Message>"
        hlblView2.id = R.id.status
        hlblView2.gravity = Gravity.START
        hlbParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        hlbParams.weight = 1.6F
        hlbParams.width = 0
        hlayoutObj.addView(hlblView2, hlbParams)
        layoutObj.addView(hlayoutObj)


        return layoutObj
    }
}