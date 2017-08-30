package com.foney.android;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.foney.android.base.BaseFragment;
import com.foney.android.fragment.ChatFragment;
import com.foney.android.fragment.PersonFragment;
import com.foney.android.fragment.StoryFragment;
import com.foney.android.fragment.ToldFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by foney on 2017/8/30.
 */

public class MainActivity extends FragmentActivity {

    private RadioGroup bootomButtonRadioGroup;
    private List<BaseFragment> baseFragments;
    //当前底部菜单的位置
    private int position;
    //当前存在的Fragment
    private BaseFragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        //设置RadioGroup的监听
        setRadioGroupListener();
    }

    private void setRadioGroupListener() {
        bootomButtonRadioGroup.setOnCheckedChangeListener(new MyOnCheckChangeListenter());
        bootomButtonRadioGroup.check(R.id.story_radio_button);
    }


    private void initFragment() {
        baseFragments = new ArrayList<BaseFragment>();
        baseFragments.add(new StoryFragment());
        baseFragments.add(new ToldFragment());
        baseFragments.add(new ChatFragment());
        baseFragments.add(new PersonFragment());
    }

    /**
     * 初始化View
     */
    private void initView() {
        bootomButtonRadioGroup = (RadioGroup)findViewById(R.id.bootom_button_radio_group);
    }

    private class MyOnCheckChangeListenter implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i) {
                case R.id.story_radio_button:
                    position = 0;
                    break;
                case R.id.told_radio_button:
                    position = 1;
                    break;
                case R.id.chat_radio_button:
                    position = 2;
                    break;
                case R.id.person_radio_button:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置得到相应的Fragment
            BaseFragment to = getBaseFragment();
            //替换Fragment
            switchFragment(mFragment,to);
        }
    }

    /**
     * 替换Fragment
     * @param from
     * @param to
     */
    private void switchFragment(BaseFragment from,BaseFragment to) {
        if(from != to) {
            mFragment = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断from不为空,隐藏from
            if(from != null) {
                ft.hide(from);
            }
            //判断to是否存在
            if(!to.isAdded()) {
                //to不存在,创建to
                if(to != null) {
                    ft.add(R.id.center_content_frameLayout,to).commit();
                }
            }else {
                //to已存在,显示to
                if(to != null) {
                    ft.show(to).commit();
                }
            }
        }
    }


    private BaseFragment getBaseFragment() {
        BaseFragment baseFragment = baseFragments.get(position);
        return baseFragment;
    }
}
