package com.example.luxsofttest.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavType
import com.example.luxsofttest.cloud.model.Transaction
import com.google.gson.Gson

class PostType : NavType<Transaction>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Transaction? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): Transaction {
        return Gson().fromJson(value, Transaction::class.java)
    }
    override fun put(bundle: Bundle, key: String, value: Transaction) {
        bundle.putParcelable(key, value)
    }
}