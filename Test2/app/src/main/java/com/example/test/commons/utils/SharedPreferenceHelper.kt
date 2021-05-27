package com.example.test.commons.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


class SharedPreferenceHelper constructor(context: Context){
    init {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    companion object{
        private const val PREFS_NAME = "share_prefs"
        private var mInstance: SharedPreferenceHelper? = null
        private var mSharedPreferences: SharedPreferences? = null



        @Synchronized
        fun initialize(context: Context?) {
            if (context == null) {
                throw NullPointerException("ApplicationContext is null")
            }
            if (mInstance == null) {
                synchronized(SharedPreferenceHelper::class.java) {
                    if (mInstance == null) {
                        mInstance = SharedPreferenceHelper(context)
                    }
                }
            }
        }

        private fun getPrefs(): SharedPreferences? {
            return mSharedPreferences
        }

        fun clearPrefs() {
            val editor = getPrefs()!!.edit()
            editor.clear()
            editor.apply()
        }

        fun removeKey(key: String?) {
            getPrefs()!!.edit().remove(key).commit()
        }

        fun containsKey(key: String?): Boolean {
            return getPrefs()!!.contains(key)
        }

        fun getString(key: String?, defValue: String?): String? {
            return getPrefs()!!.getString(key, defValue)
        }

        fun getString(key: String?): String? {
            return getString(key, null)
        }

        fun setString(key: String?, value: String?) {
            val editor = getPrefs()!!.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun getInt(key: String?, defValue: Int): Int {
            return getPrefs()!!.getInt(key, defValue)
        }

        fun getInt(key: String?): Int {
            return getInt(key, 0)
        }

        fun setInt(key: String?, value: Int) {
            val editor = getPrefs()!!.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        fun getLong(key: String?, defValue: Long): Long {
            return getPrefs()!!.getLong(key, defValue)
        }

        fun getLong(key: String?): Long {
            return getLong(key, 0L)
        }

        fun setLong(key: String?, value: Long) {
            val editor = getPrefs()!!.edit()
            editor.putLong(key, value)
            editor.apply()
        }

        fun getBoolean(key: String?, defValue: Boolean): Boolean {
            return getPrefs()!!.getBoolean(key, defValue)
        }

        fun getBoolean(key: String?): Boolean {
            return getBoolean(key, false)
        }

        fun setBoolean(key: String?, value: Boolean) {
            val editor = getPrefs()!!.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }

        fun getFloat(key: String?): Boolean {
            return getFloat(key, 0f)
        }

        fun getFloat(key: String?, defValue: Float): Boolean {
            return getFloat(key, defValue)
        }

        fun setFloat(key: String?, value: Float?) {
            val editor = getPrefs()!!.edit()
            editor.putFloat(key, value!!)
            editor.apply()
        }

//        fun setUser(key: String?, userDTO: UserDTO?) {
//            val editor = getPrefs()!!.edit()
//            val gson = Gson()
//            val json = gson.toJson(userDTO)
//            editor.putString(key, json)
//            editor.apply()
//        }
//
//        fun getUser(key: String?): UserDTO? {
//            val gson = Gson()
//            val json = getPrefs()!!.getString(key, "")
//            return gson.fromJson(json, UserDTO::class.java)
//        }
    }
}