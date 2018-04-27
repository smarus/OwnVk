package com.ruslan.android.ownvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.ruslan.android.ownvk.CurrentUser;
import com.ruslan.android.ownvk.mvp.view.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

	public void checkAuth() {
		if (!CurrentUser.isAuthorized()) {
			getViewState().startSignIn();
		} else {
			getViewState().signedIn();
		}
	}
}
