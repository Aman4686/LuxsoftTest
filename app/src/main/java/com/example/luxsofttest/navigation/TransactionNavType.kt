package com.example.luxsofttest.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.example.luxsofttest.cloud.model.BaseTransaction
import com.google.gson.Gson

class TransactionNavType : NavType<BaseTransaction>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): BaseTransaction? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): BaseTransaction {
        return Gson().fromJson(value, BaseTransaction::class.java)
    }
    override fun put(bundle: Bundle, key: String, value: BaseTransaction) {
        bundle.putParcelable(key, value)
    }
}