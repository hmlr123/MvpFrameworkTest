package com.hmlr123.mvpframeworktest.model;


import com.hmlr123.mvpframeworktest.interfaces.Callback;

public interface IMultipleInterfaceModel extends IModel {
    void getBanner(final Callback callback);
}
