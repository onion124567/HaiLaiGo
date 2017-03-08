package com.haitago.business.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.common.view.adapter.OnionRecycleAdapter;
import com.haitago.R;
import com.haitago.business.baseandcommon.BaseFragment;

/**
 * Created by wangcong on 2017/3/5.
 */

public class OrderListFragment extends BaseFragment{
    RecyclerView recyclerView;
    OnionRecycleAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_receiveorder,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView= (RecyclerView) getView().findViewById(R.id.recyclerview);
        adapter=new OnionRecycleAdapter(R.layout.item_receiveorder,null);
    }

}
