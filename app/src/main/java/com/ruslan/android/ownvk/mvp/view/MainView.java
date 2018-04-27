package com.ruslan.android.ownvk.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
	void startSignIn();
	void signedIn();
}
