package com.dawnlight.binding.input.capture;

import android.app.Activity;

import com.dawnlight.AppLog;
import com.dawnlight.BuildConfig;
import com.dawnlight.R;
import com.dawnlight.binding.input.evdev.EvdevCaptureProviderShim;
import com.dawnlight.binding.input.evdev.EvdevListener;

public class InputCaptureManager {
    public static InputCaptureProvider getInputCaptureProvider(Activity activity, EvdevListener rootListener) {
        if (AndroidNativePointerCaptureProvider.isCaptureProviderSupported()) {
            AppLog.info("Using Android O+ native mouse capture");
            return new AndroidNativePointerCaptureProvider(activity, activity.findViewById(R.id.surfaceView));
        }
        // LineageOS implemented broken NVIDIA capture extensions, so avoid using them on root builds.
        // See https://github.com/LineageOS/android_frameworks_base/commit/d304f478a023430f4712dbdc3ee69d9ad02cebd3
        else if (!BuildConfig.ROOT_BUILD && ShieldCaptureProvider.isCaptureProviderSupported()) {
            AppLog.info("Using NVIDIA mouse capture extension");
            return new ShieldCaptureProvider(activity);
        }
        else if (EvdevCaptureProviderShim.isCaptureProviderSupported()) {
            AppLog.info("Using Evdev mouse capture");
            return EvdevCaptureProviderShim.createEvdevCaptureProvider(activity, rootListener);
        }
        else if (AndroidPointerIconCaptureProvider.isCaptureProviderSupported()) {
            // Android N's native capture can't capture over system UI elements
            // so we want to only use it if there's no other option.
            AppLog.info("Using Android N+ pointer hiding");
            return new AndroidPointerIconCaptureProvider(activity, activity.findViewById(R.id.surfaceView));
        }
        else {
            AppLog.info("Mouse capture not available");
            return new NullCaptureProvider();
        }
    }
}
