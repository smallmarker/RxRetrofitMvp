package com.zl.rxretrofitmvp.model;

import android.annotation.SuppressLint;

import com.orhanobut.logger.Logger;
import com.zl.rxretrofitmvp.base.BaseModel;
import com.zl.rxretrofitmvp.bean.Province;
import com.zl.rxretrofitmvp.http.rx.HttpRx;
import com.zl.rxretrofitmvp.http.rx.MySubscriber;

import java.util.List;

/**
 * @author xiaolong
 * @ClassName MainModel
 * @Date 2018/8/22
 **/
public class MainModel extends BaseModel {

    @SuppressLint("CheckResult")
    public void getProvince(MainListener listener) {
        HttpRx.normal(getApiManager().province())
                .subscribe(new MySubscriber<List<Province>>() {
                    @Override
                    protected void onSuccess(List<Province> provinces) {
                        Logger.d(provinces);
                        listener.setProvinces(provinces);
                    }
                });
    }

}
