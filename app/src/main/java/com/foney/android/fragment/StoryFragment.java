package com.foney.android.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.foney.android.R;
import com.foney.android.adapter.StoryFragmentAdapter;
import com.foney.android.base.BaseFragment;

/**
 * Created by foney on 2017/8/30.
 */

public class StoryFragment extends BaseFragment {

//    private TextView textView;
    private static final String Tag = StoryFragment.class.getSimpleName();

    private ListView storyListView;
    private String[] datas;
    private BaseAdapter adapter;

    @Override
    protected View initView() {
        Log.e(Tag,"StoryFragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.story_layout,null);
        storyListView = (ListView)view.findViewById(R.id.story_list_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(Tag,"StoryFragment数据被初始化了");
        datas = new String[]{"nihsf","dfsfsd","dsfdasfas","DFSGSDF"};
        adapter = new StoryFragmentAdapter(mContext,datas);
        storyListView.setAdapter(adapter);
    }
}
