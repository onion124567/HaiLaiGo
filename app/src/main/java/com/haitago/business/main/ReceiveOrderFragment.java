package com.haitago.business.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.view.adapter.OnionRecycleAdapter;
import com.haitago.R;
import com.haitago.business.baseandcommon.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcong on 2017/3/5.
 */

public class ReceiveOrderFragment extends BaseFragment{
    RecyclerView recyclerView;
    OnionRecycleAdapter adapter;
    TextView footerView;
    List<String> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_receiveorder,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView= (RecyclerView) getView().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        footerView=new TextView(getActivity());
        footerView.setText("添加新路线");
        adapter=new OnionRecycleAdapter(R.layout.item_receiveorder,list);
        adapter.addFooterView(footerView);
        testData();
    }

    private void testData() {
          for(int i=0;i<3;i++){
              list.add("i");
          }
    }

}
