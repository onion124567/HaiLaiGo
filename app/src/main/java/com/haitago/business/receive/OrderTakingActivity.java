package com.haitago.business.receive;

import android.os.Bundle;
import android.view.View;

import com.haitago.business.baseandcommon.BaseFragment;
import com.haitago.business.baseandcommon.TableActivity;

/**
 * Created by onion on 2017/3/8.
 */
public class OrderTakingActivity extends TableActivity {
   String titles[]=new String[]{"今天","明天","后天"};
   BaseFragment [] fragments=new BaseFragment[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iv_arrow.setVisibility(View.GONE);
        for(int i=0;i<3;i++){
            fragments[i]=new OrderTakingFragment();
        }
        initTab(titles,fragments);
    }
}
