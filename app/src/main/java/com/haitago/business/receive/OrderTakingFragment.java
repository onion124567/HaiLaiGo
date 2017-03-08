package com.haitago.business.receive;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.view.adapter.OnionRecycleAdapter;
import com.common.view.recyclerview.BaseViewHolder;
import com.common.view.recyclerview.DividerItemDecoration;
import com.haitago.R;
import com.haitago.business.baseandcommon.BaseFragment;
import com.haitago.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onion on 2017/3/8.
 */
public class OrderTakingFragment extends BaseFragment {
    //请求参数的id
    public long time;
    RecyclerView recyclerView;
    TextView footerView;
    View headView;
    OnionRecycleAdapter adapter;
    List<String> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_ordertaking,null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView= (RecyclerView) getView().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        footerView=new TextView(getActivity());
        footerView.setText("添加新路线");
        adapter=new OnionRecycleAdapter(R.layout.item_ordertaking,list){
            @Override
            protected void convert(BaseViewHolder helper, Object item) {
                super.convert(helper, item);
                TextView textView=    helper.getView(R.id.tv_money);
                SpannableString sp = new SpannableString("¥385");
                AbsoluteSizeSpan span=new AbsoluteSizeSpan(ScreenUtils.dip2px(getActivity(), 10));
                sp.setSpan(span,0,1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                textView.setText(sp);
            }
        };
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        adapter.addFooterView(footerView);
        headView=View.inflate(getActivity(),R.layout.headview_normal,null);
        adapter.addHeaderView(headView);
        initHeadView();
        recyclerView.setAdapter(adapter);
        testData();
    }

    private void initHeadView(){
        TextView textView= (TextView) headView.findViewById(R.id.tv_title);
        textView.setText("接单");
        textView= (TextView) headView.findViewById(R.id.tv_second);
        textView.setText("张鹤立，你好");
    }
    private void testData() {
        for(int i=0;i<3;i++){
            list.add("i");
        }
    }
}
