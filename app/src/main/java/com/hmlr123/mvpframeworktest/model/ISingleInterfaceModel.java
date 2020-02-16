package com.hmlr123.mvpframeworktest.model;

import com.hmlr123.mvpframeworktest.interfaces.Callback;

/**
 * 定义基本的接口方法
 */
public interface ISingleInterfaceModel extends IModel {

    /**
     * @param curPage  分页请求
     * @param callback 回调接口 需要子类实现
     */
    void getData(int curPage, final Callback callback);
}
