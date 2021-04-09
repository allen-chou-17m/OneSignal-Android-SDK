package com.onesignal.bundlecompat

import android.os.Parcelable

interface BundleCompat<T> {
    fun putString(key: String?, value: String?)
    fun putInt(key: String?, value: Int?)
    fun putLong(key: String?, value: Long?)
    fun putBoolean(key: String?, value: Boolean?)
    fun getString(key: String?): String?
    fun getInt(key: String?): Int?
    fun getLong(key: String?): Long?
    fun getBoolean(key: String?): Boolean
    fun getBoolean(key: String?, value: Boolean): Boolean
    fun containsKey(key: String?): Boolean
    fun getBundle(): T
    fun setBundle(bundle: Parcelable)
}