package com.hmlr123.mvpframeworktest.interfaces;


/**
 * 同意回调接口
 *
 * @param <K>
 * @param <V>
 */
public interface Callback<K, V> {

    void onSuccess(K data);

    void onFail(V data);
}
