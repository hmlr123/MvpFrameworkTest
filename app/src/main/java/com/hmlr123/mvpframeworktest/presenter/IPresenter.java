package com.hmlr123.mvpframeworktest.presenter;

import com.hmlr123.mvpframeworktest.view.IView;

/**
 * 公共的Presenter 接口 View 的生命周期映射到Presenter 中
 * 定义基础的方法
 */
public interface IPresenter<T extends IView> {

    /**
     * 依附生命view
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 分离View
     */
    void detachView();

    /**
     * 判断View是否已经销毁
     *
     * @return
     */
    boolean isViewAttached();
}
