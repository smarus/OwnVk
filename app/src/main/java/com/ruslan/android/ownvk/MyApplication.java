package com.ruslan.android.ownvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		VKSdk.initialize(this);
	}
}
