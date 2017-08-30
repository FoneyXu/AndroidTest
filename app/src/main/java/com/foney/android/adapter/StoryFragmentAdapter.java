package com.foney.android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by foney on 2017/8/30.
 */

public class StoryFragmentAdapter extends BaseAdapter{

    private final Context mContext;
    private final String[] datas;

    public StoryFragmentAdapter(Context mContext,String[] datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(10,10,0,10);
        textView.setText(datas[i]);
        return textView;
    }
}
