package com.hmlr123.mvpframeworktest.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hmlr123.mvpframeworktest.R;
import com.hmlr123.mvpframeworktest.base.BaseMVPActivity;
import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.bean.BannerBean;
import com.hmlr123.mvpframeworktest.contract.MultipleInterfaceContract;
import com.hmlr123.mvpframeworktest.contract.SingleInterfaceContract;
import com.hmlr123.mvpframeworktest.presenter.MultipleInterfacePresenter;
import com.hmlr123.mvpframeworktest.base.MultiplePresenter;
import com.hmlr123.mvpframeworktest.presenter.SingleInterfacePresenter;

public class MultipleInterfaceActivity extends BaseMVPActivity<MultiplePresenter> implements SingleInterfaceContract.View, MultipleInterfaceContract.View {

    private Button mBtn1;
    private Button mBtn2;
    private TextView mTextView1;
    private TextView mTextView2;

    private SingleInterfacePresenter singleInterfacePresenter;
    private MultipleInterfacePresenter multipleInterfacePresenter;


    @Override
    protected MultiplePresenter createPresenter() {
        // 中间处理 将单个的网络请求封装成一个
        MultiplePresenter multiplePresenter = new MultiplePresenter(this);

        singleInterfacePresenter = new SingleInterfacePresenter();
        multipleInterfacePresenter = new MultipleInterfacePresenter();

        multiplePresenter.addPresenter(singleInterfacePresenter);
        multiplePresenter.addPresenter(multipleInterfacePresenter);
        return multiplePresenter;
    }


    /**
     * 初始化处理
     */
    @Override
    protected void init() {
        setContentView(R.layout.activity_multiple_interface);
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mTextView1 = findViewById(R.id.textView1);
        mTextView2 = findViewById(R.id.textView2);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleInterfacePresenter.getData(0);
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multipleInterfacePresenter.getBanner();
            }
        });
    }

    @Override
    public void showArticleSuccess(ArticleListBean bean) {
        mTextView1.setText(bean.data.datas.get(0).title);
    }

    @Override
    public void showArticleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMultipleSuccess(BannerBean bean) {
        mTextView2.setText(bean.data.get(0).title);
    }

    @Override
    public void showMultipleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
