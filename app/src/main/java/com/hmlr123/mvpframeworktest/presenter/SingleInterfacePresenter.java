package com.hmlr123.mvpframeworktest.presenter;

import com.hmlr123.mvpframeworktest.base.BasePresenter;
import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.contract.SingleInterfaceContract;
import com.hmlr123.mvpframeworktest.interfaces.Callback;
import com.hmlr123.mvpframeworktest.model.SingleInterfaceModel;
import com.hmlr123.mvpframeworktest.utils.LP;

public class SingleInterfacePresenter extends BasePresenter<SingleInterfaceContract.View> implements SingleInterfaceContract.Presenter {

    // 持有Model 的对象方法
    private final SingleInterfaceModel mSingleInterfaceModel;


    public SingleInterfacePresenter() {
        mSingleInterfaceModel = new SingleInterfaceModel();
    }

    @Override
    public void getData(int curPage) {
        // 调用Model 的方法 实现回调方法
        mSingleInterfaceModel.getData(curPage, new Callback<ArticleListBean, String>() {
            @Override
            public void onSuccess(ArticleListBean loginResultBean) {
                // 如果Model层请求数据成功,则此处应执行通知View层的代码
                LP.w(loginResultBean.toString());
                if (isViewAttached()) {
                    // 调用回调方法
                    mView.showArticleSuccess(loginResultBean);
                }
            }

            @Override
            public void onFail(String errorMsg) {
                // 如果Model层请求数据失败,则此处应执行通知View层的代码
                if (isViewAttached()) {
                    mView.showArticleFail(errorMsg);
                }
            }
        });
    }
}
