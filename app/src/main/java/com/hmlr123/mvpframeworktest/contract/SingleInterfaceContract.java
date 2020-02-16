package com.hmlr123.mvpframeworktest.contract;

import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.view.IView;

/**
 * 总接口
 */
public interface SingleInterfaceContract {

    interface View extends IView {
        void showArticleSuccess(ArticleListBean bean);

        void showArticleFail(String errorMsg);
    }

    interface Presenter {
        void getData(int curPage);
    }
}
