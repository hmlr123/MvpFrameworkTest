package com.hmlr123.mvpframeworktest.base;

import com.hmlr123.mvpframeworktest.presenter.IPresenter;
import com.hmlr123.mvpframeworktest.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个请求当一个请求处理 数据集合
 * 泛型持有View 上限为公共接口IView
 *
 * @param <T>
 */
public class MultiplePresenter<T extends IView> extends BasePresenter<T> {

    private T mView;

    // 存储单个的Presenter
    private List<IPresenter> presenters = new ArrayList<>();

    public MultiplePresenter(T view) {
        mView = view;
    }

    /**
     * 将单个的网络请求 封装到一个请求中
     *
     * @param addPresenter
     * @param <K>
     */
    public final <K extends IPresenter<T>> void addPresenter(K... addPresenter) {
        for (K ap : addPresenter) {
            // 绑定生命周期 每个Presenter 添加到View的生命周期中
            ap.attachView(mView);
            presenters.add(ap);
        }
    }

    /**
     * View 销毁的时候 逐一解绑
     */
    @Override
    public void detachView() {
        for (IPresenter presenter : presenters) {
            presenter.detachView();
        }
    }


}
