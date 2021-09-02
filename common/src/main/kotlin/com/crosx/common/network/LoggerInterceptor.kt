package com.crosx.common.network

import android.text.TextUtils
import android.util.Log
import okhttp3.*
import okio.Buffer
import java.io.IOException

class LoggerInterceptor @JvmOverloads constructor(private val showResponse: Boolean = false) :
    Interceptor {

    companion object {
        const val TAG = "KotlinDemo"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logForRequest(request)
        val response = chain.proceed(request)
        return logForResponse(response)
    }

    private fun logForResponse(response: Response): Response {
        try {
            //===>response log
            Log.i(TAG, "========response_log========start")
            val builder = response.newBuilder()
            val clone = builder.build()
            Log.i(TAG, "url : ${clone.request.url}")
            Log.i(TAG, "code : ${clone.code}")
            Log.i(TAG, "protocol : ${clone.protocol}")
            if (!TextUtils.isEmpty(clone.message)) Log.i(TAG, "message : ${clone.message}")
            if (showResponse) {
                var body = clone.body
                if (body != null) {
                    val mediaType = body.contentType()
                    if (mediaType != null) {
                        Log.i(TAG, "responseBody's contentType : $mediaType")
                        if (isText(mediaType)) {
                            val resp = body.string()
                            Log.i(TAG, "responseBody's content : $resp")
                            body = ResponseBody.create(mediaType, resp)
                            return response.newBuilder().body(body).build()
                        } else {
                            Log.i(
                                TAG,
                                "responseBody's content : " + " maybe [file part] , too large too print , ignored!"
                            )
                        }
                    }
                }
            }
            Log.i(TAG, "========response_log========end")
        } catch (e: Exception) {
            e.printStackTrace();
        }
        return response
    }

    private fun logForRequest(request: Request) {
        try {
            val url = request.url.toString()
            val headers = request.headers
            Log.i(TAG, "========request_log========start")
            Log.i(TAG, "method : ${request.method}")
            Log.i(TAG, "url : $url")
            if (headers.size > 0) {
                Log.i(TAG, "headers : $headers")
            }
            val requestBody = request.body
            if (requestBody != null) {
                val mediaType = requestBody.contentType()
                if (mediaType != null) {
                    Log.i(TAG, "requestBody's contentType : $mediaType")
                    if (isText(mediaType)) {
                        Log.i(TAG, "requestBody's content : ${bodyToString(request)}")
                    } else {
                        Log.i(
                            TAG,
                            "requestBody's content : " + " maybe [file part] , too large too print , ignored!"
                        )
                    }
                }
            }
            Log.i(TAG, "========request_log========end")
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }

    private fun isText(mediaType: MediaType): Boolean {
        if (mediaType.type == "text") {
            return true
        }
        if (mediaType.subtype == "json" || mediaType.subtype == "xml" || mediaType.subtype == "html" || mediaType.subtype == "webviewhtml") return true
        return false
    }

    private fun bodyToString(request: Request): String {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body!!.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "something error when show requestBody."
        }
    }


}