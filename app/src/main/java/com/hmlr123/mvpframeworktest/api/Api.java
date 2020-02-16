package com.hmlr123.mvpframeworktest.api;

import com.hmlr123.mvpframeworktest.bean.ArticleListBean;
import com.hmlr123.mvpframeworktest.bean.BannerBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface Api {

    /**
     * wanandroid 首页文章列表
     *
     * @param curPage 当前第几页
     * @return
     */
    @GET("article/list/{curPage}/json")
    Observable<ArticleListBean> getData(@Path("curPage") int curPage);

    /**
     * 获取首页banner数据
     *
     * @return
     */
    @GET("banner/json")
    Observable<BannerBean> getBanner();

}
