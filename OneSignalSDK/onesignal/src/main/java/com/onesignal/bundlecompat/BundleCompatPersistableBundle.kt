package com.onesignal.bundlecompat

import android.os.Build
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.annotation.RequiresApi

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
internal class BundleCompatPersistableBundle : BundleCompat<PersistableBundle?> {
    private var mBundle: PersistableBundle

    constructor() {
        mBundle = PersistableBundle()
    }

    constructor(bundle: PersistableBundle) {
        mBundle = bundle
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

    override fun getBoolean(key: String?, value: Boolean): Boolean {
        return mBundle.getBoolean(key, value)
    }

    override fun containsKey(key: String?): Boolean {
        return mBundle.containsKey(key)
    }

    override fun getBundle(): PersistableBundle {
        return mBundle
    }

    override fun setBundle(bundle: Parcelable) {
        if (bundle is PersistableBundle) {
            mBundle = bundle
        }
    }
}