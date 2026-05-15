package com.dawnlight.binding;

import android.content.Context;

import com.dawnlight.binding.crypto.AndroidCryptoProvider;
import com.dawnlight.nvstream.http.LimelightCryptoProvider;

public class PlatformBinding {
    public static LimelightCryptoProvider getCryptoProvider(Context c) {
        return new AndroidCryptoProvider(c);
    }
}
