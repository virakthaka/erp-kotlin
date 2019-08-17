package com.example.erpkotlin.utils

import com.example.erpkotlin.models.response.ResponseObject

class ResponseObjectMap {
    private val responseObject = ResponseObject()

    fun responseObject(obj: Any?, totalElements: Long): MutableMap<String, Any> {
        val response: MutableMap<String, Any> = HashMap()
        if (obj != null) {
            response["results"] = obj
            response["length"] = totalElements
            response["response"] = responseObject.success()
        } else {
            response["response"] = responseObject.error()
        }
        return response
    }

    fun responseObject(obj: Any?): MutableMap<String, Any> {
        val response: MutableMap<String, Any> = HashMap()
        if (obj != null) {
            response["results"] = obj
            response["response"] = responseObject.success()
        } else {
            response["response"] = responseObject.error()
        }
        return response
    }
}