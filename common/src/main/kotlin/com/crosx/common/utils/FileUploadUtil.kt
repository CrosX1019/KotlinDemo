package com.crosx.common.utils

import com.qiniu.android.storage.UploadManager
import com.qiniu.android.storage.UploadOptions

object FileUploadUtil {

    fun uploadFile(filePath: String) : String{
        val uploadManager = UploadManager()
        uploadManager.put(filePath, "", "",
            { key, info, response ->

            }, UploadOptions(null, null, false,
                { key, percent ->

                }, null
            ))
        return ""
    }

}