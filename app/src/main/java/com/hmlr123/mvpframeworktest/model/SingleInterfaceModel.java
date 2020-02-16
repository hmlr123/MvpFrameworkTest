package com.hmlr123.mvpframeworktest.model;

import com.hmlr123.mvpframeworktest.api.Api;
import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.interfaces.Callback;
import com.hmlr123.mvpframeworktest.utils.LP;
import com.hmlr123.mvpframeworktest.utils.NetUtils;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SingleInterfaceModel implements ISingleInterfaceModel {

    @Override
    public void getData(int curPage, final Callback callback) {
        NetUtils.getRetrofit()
                .create(Api.class)
                .getData(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleListBean>() {
                    @Override
                    public void onCompleted() {
                        LP.w("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail("出现错误");
                    }

                    @Override
                    public void onNext(ArticleListBean articleListBean) {
                        if (null == articleListBean) {
                            callback.onFail("出现错误");
                        } else if (articleListBean.errorCode != 0) {
                            callback.onFail(articleListBean.errorMsg);
                        } else {
                            // 调用回调方法
                            callback.onSuccess(articleListBean);
                        }
                    }
                });
    }
}
