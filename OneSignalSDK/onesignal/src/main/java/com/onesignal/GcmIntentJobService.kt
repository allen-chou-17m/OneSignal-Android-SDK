package com.onesignal

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.onesignal.bundlecompat.BundleCompatFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Uses modified JobIntentService class that's part of the onesignal package
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
internal class GcmIntentJobService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        val bundle = BundleCompatFactory.createBundle()
        bundle.setBundle(intent.extras.getParcelable(BUNDLE_EXTRA))
        NotificationBundleProcessor.ProcessFromGCMIntentService(this, bundle, null)
    }

    companion object {
        const val BUNDLE_EXTRA = "Bundle:Parcelable:Extras"
        private const val JOB_ID = 123890
        @JvmStatic
        fun enqueueWork(context: Context?, intent: Intent?) {
            context ?: return
            intent ?: return

            // not do enqueue work due to background service could delay until app goto foreground
//            enqueueWork(context, GcmIntentJobService::class.java, JOB_ID, intent, false)
            GlobalScope.launch(Dispatchers.IO){
                val bundle = BundleCompatFactory.createBundle()
                val data: Parcelable = intent.extras?.getParcelable(BUNDLE_EXTRA) ?: return@launch
                bundle.setBundle(data)
                NotificationBundleProcessor.ProcessFromGCMIntentService(context, bundle, null)
            }
        }
    }
}