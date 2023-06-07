package com.rncallandroid;

import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import javax.annotation.Nonnull;

class ZZYModule extends ReactContextBaseJavaModule {

    private Context mContext;
    public ZZYModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @Nonnull
    @Override
    public String getName() {
        return "ZZYModule";
    }

    @ReactMethod
    public void JSCallToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
}