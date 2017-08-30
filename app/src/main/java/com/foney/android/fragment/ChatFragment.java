package com.foney.android.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.foney.android.base.BaseFragment;

/**
 * Created by foney on 2017/8/30.
 */

public class ChatFragment extends BaseFragment {

    private TextView textView;
    private static final String Tag = ChatFragment.class.getSimpleName();


    @Override
    protected View initView() {
        Log.e(Tag,"ChatFragment页面被初始化了...");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(Tag,"ChatFragment数据被初始化了");
        textView.setText("ChatFragment");
    }
}
