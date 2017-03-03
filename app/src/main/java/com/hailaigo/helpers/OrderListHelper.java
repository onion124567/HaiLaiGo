package com.hailaigo.helpers;

import android.text.TextUtils;

import com.hailaigo.business.baseandcommon.TApplication;
import com.hailaigo.factory.bean.base.OpenListBean;
import com.hailaigo.factory.bean.base.OrderList;
import com.hailaigo.utils.ACache;
import com.hailaigo.utils.Config;

/**
 * Created by onion on 2016/11/17.
 */
public class OrderListHelper {

    private long maxOrderList = 0;
    private String key = "key";
    private StringBuilder userIdKey=new StringBuilder("");
    public OrderListHelper(String key) {
        this.key = key;
        userIdKey.append(TApplication.getInstance().userId);
    }

    public long getMaxOrderList() {
        String orderliststr = ACache.get(TApplication.getInstance(), Config.ORDERLIST_KEY+userIdKey.toString()).getAsString(key);
        if(!TextUtils.isEmpty(orderliststr)){
            maxOrderList= Long.parseLong(orderliststr);
        }
        return maxOrderList;
    }

    public void saveMaxOrderList(OrderList orderList) {
        if (orderList.getOrderList() > maxOrderList) {
            maxOrderList = orderList.getOrderList();
            ACache.get(TApplication.getInstance(), Config.ORDERLIST_KEY+userIdKey.toString()).put(key, orderList.getOrderList() + "");
        }
    }


    //修改最大值，刷新的时候做提示请求
    public void updateMaxOrderList(OpenListBean<? extends OrderList> bean) {
        for (OrderList orderList  : bean.getPager()) {
            saveMaxOrderList(orderList);
        }
    }
}
