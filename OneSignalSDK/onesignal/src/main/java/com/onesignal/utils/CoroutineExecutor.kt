package com.onesignal.utils

import androidx.annotation.AnyThread
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.concurrent.Executors

object CoroutineExecutor {

    private val singleThreadDispatcher = Executors.newFixedThreadPool(1).asCoroutineDispatcher()
    private val singleThreadScope = CoroutineScope(SupervisorJob() + singleThreadDispatcher)

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

    // Don't call Thread.sleep in your runnable
    @JvmStatic
    @AnyThread
    fun launchInSingleThread(runnable: Runnable) {
        singleThreadScope.launch {
            runnable.run()
        }
    }

}