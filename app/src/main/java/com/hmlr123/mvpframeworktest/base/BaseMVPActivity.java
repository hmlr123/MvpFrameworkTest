package com.hmlr123.mvpframeworktest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hmlr123.mvpframeworktest.presenter.IPresenter;
import com.hmlr123.mvpframeworktest.view.IView;

/**
 * 基本的Activity
 *
 * @param <T>
 */
public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {
    protected T mPresenter;

    /**
     * 实现Activity大部分的 的初始化操作 预留子类初始化抽象方法
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        // 留给子类初始化处理
        init();
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 初始化Presenter
     */
    protected void initPresenter() {
        mPresenter = createPresenter();
        // 绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    /**
     * 初始化操作
     */
    protected abstract void init();
}
