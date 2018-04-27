package com.ruslan.android.ownvk.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.ruslan.android.ownvk.R;
import com.ruslan.android.ownvk.ui.fragment.BaseFragment;

public abstract class BaseActivity  extends MvpAppCompatActivity{


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getMainContentLayout();
	}

	public void fragmentOnScreen(BaseFragment fragment){

 }

    @LayoutRes
    protected abstract int getMainContentLayout();
}
