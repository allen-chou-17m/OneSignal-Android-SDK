package com.onesignal.bundlecompat

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

internal class BundleCompatBundle : BundleCompat<Bundle?> {
    private var mBundle: Bundle

    constructor() {
        mBundle = Bundle()
    }

    constructor(bundle: Bundle) {
        mBundle = bundle
    }

    constructor(intent: Intent) {
        mBundle = intent.extras ?: Bundle()
    }

    override fun putString(key: String?, value: String?) {
        mBundle.putString(key, value)
    }

    override fun putInt(key: String?, value: Int?) {
        value ?: return
        mBundle.putInt(key, value)
    }

    override fun putLong(key: String?, value: Long?) {
        value ?: return
        mBundle.putLong(key, value)
    }

    override fun putBoolean(key: String?, value: Boolean?) {
        value ?: return
        mBundle.putBoolean(key, value)
    }

    override fun getString(key: String?): String {
        return mBundle.getString(key) ?: ""
    }

    override fun getInt(key: String?): Int {
        return mBundle.getInt(key)
    }

    override fun getLong(key: String?): Long {
        return mBundle.getLong(key)
    }

    override fun getBoolean(key: String?): Boolean {
        return mBundle.getBoolean(key)
    }

    override fun containsKey(key: String?): Boolean {
        return mBundle.containsKey(key)
    }

    override fun getBundle(): Bundle {
        return mBundle
    }

    override fun setBundle(bundle: Parcelable) {
        if (bundle is Bundle) {
            mBundle = bundle
        }
    }

    override fun getBoolean(key: String?, value: Boolean): Boolean {
        return mBundle.getBoolean(key, value)
    }
}