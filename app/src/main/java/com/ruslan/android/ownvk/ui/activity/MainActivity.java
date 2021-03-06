package com.ruslan.android.ownvk.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.ruslan.android.ownvk.CurrentUser;
import com.ruslan.android.ownvk.R;
import com.ruslan.android.ownvk.constant.ApiConst;
import com.ruslan.android.ownvk.mvp.presenter.MainPresenter;
import com.ruslan.android.ownvk.mvp.view.MainView;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

public class MainActivity extends BaseActivity implements MainView{


	@InjectPresenter
	MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//
		mainPresenter.checkAuth();
	}




	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
			@Override
			public void onResult(VKAccessToken res) {
// Пользователь успешно авторизовался
				mainPresenter.checkAuth();
			}
			@Override
			public void onError(VKError error) {
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
			}
		})) {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public void startSignIn() {
		VKSdk.login(this, ApiConst.DEFAULT_LOGIN_SCOPE);

	}

	@Override
	public void signedIn() {
		Toast.makeText(this,"User id " + CurrentUser.getId(),Toast.LENGTH_LONG).show();
	}
}
