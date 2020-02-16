package com.hmlr123.mvpframeworktest.presenter;

import com.hmlr123.mvpframeworktest.base.BasePresenter;
import com.hmlr123.mvpframeworktest.bean.BannerBean;
import com.hmlr123.mvpframeworktest.contract.MultipleInterfaceContract;
import com.hmlr123.mvpframeworktest.interfaces.Callback;
import com.hmlr123.mvpframeworktest.model.IMultipleInterfaceModel;
import com.hmlr123.mvpframeworktest.model.MultipleInterfaceModel;
import com.hmlr123.mvpframeworktest.utils.LP;

/**
 * Presenter层代码
 * 单个请求的数据处理
 */
public class MultipleInterfacePresenter extends BasePresenter<MultipleInterfaceContract.View>
        implements MultipleInterfaceContract.Presenter {

    private final IMultipleInterfaceModel multipleInterfaceModel;

    public MultipleInterfacePresenter() {
        this.multipleInterfaceModel = new MultipleInterfaceModel();
    }

    @Override
    public void getBanner() {
        multipleInterfaceModel.getBanner(new Callback<BannerBean, String>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                //如果Model层请求数据成功,则此处应执行通知View层的代码
                //LP.w()是一个简单的log打印
                LP.w(bannerBean.toString());
                if (isViewAttached()) {
                    // 调用回调方法
                    mView.showMultipleSuccess(bannerBean);
                }
            }

            @Override
            public void onFail(String errorMsg) {
                //如果Model层请求数据失败,则此处应执行通知View层的代码
                LP.w(errorMsg);
                if (isViewAttached()) {
                    mView.showMultipleFail(errorMsg);
                }
            }
        });
    }
}
