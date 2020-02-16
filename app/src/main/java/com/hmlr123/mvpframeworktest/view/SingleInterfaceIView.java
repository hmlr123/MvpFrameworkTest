package com.hmlr123.mvpframeworktest.view;

import com.hmlr123.mvpframeworktest.bean.ArticleListBean;

/**
 * 单个请求的回调接口 成功 / 失败 在 SingleInterfaceContract 中集成 可废弃
 */
public interface SingleInterfaceIView extends IView {

    void showArticleSuccess(ArticleListBean bean);

    void showArticleFail(String errorMsg);
}
