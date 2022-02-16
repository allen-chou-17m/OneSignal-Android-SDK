package com.onesignal.utils

import androidx.annotation.AnyThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object CoroutineExecutor {

    @JvmStatic
    @AnyThread
    fun launchIO(block: suspend CoroutineScope.() -> Unit) = GlobalScope.launch(Dispatchers.IO) {
        block()
    }

    // Don't call Thread.sleep in your runnable
    @JvmStatic
    @AnyThread
    fun launchIO(runnable: Runnable) {
        launchIO {
            runnable.run()
        }
    }
}