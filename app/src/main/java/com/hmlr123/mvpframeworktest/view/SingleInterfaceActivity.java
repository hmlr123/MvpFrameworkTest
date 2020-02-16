package com.hmlr123.mvpframeworktest.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hmlr123.mvpframeworktest.R;
import com.hmlr123.mvpframeworktest.base.BaseMVPActivity;
import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.contract.SingleInterfaceContract;
import com.hmlr123.mvpframeworktest.presenter.SingleInterfacePresenter;

public class SingleInterfaceActivity extends BaseMVPActivity<SingleInterfacePresenter> implements SingleInterfaceContract.View {

    private Button mButton;

    private TextView mTextView;

    @Override
    protected void init() {
        setContentView(R.layout.activity_single_interface);
        mButton = findViewById(R.id.button3);
        mTextView = findViewById(R.id.textView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData(0);
            }
        });
    }

    @Override
    protected SingleInterfacePresenter createPresenter() {
        return new SingleInterfacePresenter();
    }


    @Override
    public void showArticleSuccess(ArticleListBean bean) {
        mTextView.setText(bean.data.datas.get(0).title);
    }

    @Override
    public void showArticleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
