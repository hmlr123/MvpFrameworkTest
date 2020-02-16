package com.hmlr123.mvpframeworktest.contract;

import com.hmlr123.mvpframeworktest.bean.BannerBean;
import com.hmlr123.mvpframeworktest.view.IView;

public interface MultipleInterfaceContract {


    interface View extends IView {
        void showMultipleSuccess(BannerBean bean);

        void showMultipleFail(String errorMsg);
    }

    interface Presenter {
        void getBanner();
    }


}
