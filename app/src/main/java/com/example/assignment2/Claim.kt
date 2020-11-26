package com.example.assignment2

import java.util.*


//Note we don't need to put the id or issolved as it will be created in the restful server code.
//So all we care about is title and date which is data that will be entered by the user.
data class Claim (var title:String?, var date:String?)