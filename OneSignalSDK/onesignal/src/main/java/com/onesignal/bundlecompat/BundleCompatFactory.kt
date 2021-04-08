package com.onesignal.bundlecompat

import android.os.Build

internal object BundleCompatFactory {
    fun createBundle(): BundleCompat<*> =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) BundleCompatPersistableBundle() else BundleCompatBundle()
}