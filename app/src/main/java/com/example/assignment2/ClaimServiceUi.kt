package com.example.assignment2

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class ClaimServiceUi (val ctx: UIEditor) {

    lateinit var claimList: MutableList<Claim>
    var add_true = false

    companion object{
        private var cService : ClaimServiceUi? = null

        fun getInstance(act : UIEditor) : ClaimServiceUi{
            if(cService == null){
                cService = ClaimServiceUi(act)
            }

            return cService!!
        }

    }

    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                Log.d("Claim Service", "The response JSON string is ${String(responseBody)}")
                val gson = Gson()
                val claimListType: Type = object : TypeToken<List<Claim>>() {}.type
                claimList = gson.fromJson(String(responseBody), claimListType)
                //
                //act.runOnUiThread {
                //    cbLambdaFunction()
                //}
                Log.d("Claim Service", "The Claim List: ${claimList}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("Claim Service", "Error Detected!")
        }

    }


    inner class addServiceRespHandler : AsyncHttpResponseHandler() {

        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                ctx.refreshScreenTrue()
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Claim response : ${respStr}")

            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            //Note this takes considerably longer as the code first detects what the error is.
            ctx.refreshScreenFalse()
            Log.d("Claim Service", "Error Detected!")

        }
    }

    fun addClaim(cObj : Claim){
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.174:8020/ClaimService/add"
        val pJsonString = Gson().toJson(cObj)
        val entity = StringEntity(pJsonString)
        client.post(ctx, requestUrl, entity, "application/json", addServiceRespHandler())
    }

    fun getAll( ){
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.174:8020/ClaimService/getAll"
        Log.d("Claim Service", "About Sending the HTTP Request. ")
        client.get(requestUrl, GetAllServiceRespHandler())
    }



}