package com.hmlr123.mvpframeworktest.base;

import com.hmlr123.mvpframeworktest.presenter.IPresenter;
import com.hmlr123.mvpframeworktest.view.IView;

/**
 * 实现基本的生命周期方法 封装实现大部分的基础方法
 *
 * @param <T>
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

    /**
     * 依附生命view
     *
     * @param view
     */
    @Override
    public void attachView(T view) {
        mView = view;
    }

    /**
     * 分离View
     */
    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 判断View是否已经销毁
     *
     * @return
     */
    @Override
    public boolean isViewAttached() {
        return mView != null;
    }
}
