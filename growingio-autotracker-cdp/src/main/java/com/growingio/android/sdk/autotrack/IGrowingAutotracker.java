/*
 * Copyright (C) 2020 Beijing Yishu Technology Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.growingio.android.sdk.autotrack;

import android.app.Activity;
import android.view.View;

import com.growingio.android.sdk.track.IGrowingTracker;

import java.util.Map;

/**
 * GrowingAutotracker 无埋点 SDK 对外 API
 */
public interface IGrowingAutotracker extends IGrowingTracker {
    /**
     * 给页面设置一个别名。
     *
     * @param page  需要设置别名的页面对象，建议在onCreate生命周期中调用
     * @param alias 页面别名
     */
    void setPageAlias(Activity page, String alias);

    /**
     * 给页面设置一个别名。
     *
     * @param page  需要设置别名的页面对象，建议在onCreate生命周期中调用
     * @param alias 页面别名
     */
    void setPageAlias(android.app.Fragment page, String alias);

    /**
     * 给页面设置一个别名。
     *
     * @param page  需要设置别名的页面对象，建议在onCreate生命周期中调用
     * @param alias 页面别名
     */
    void setPageAlias(android.support.v4.app.Fragment page, String alias);

    /**
     * 给页面设置一个别名。
     *
     * @param page  需要设置别名的页面对象，建议在onCreate生命周期中调用
     * @param alias 页面别名
     */
    void setPageAlias(androidx.fragment.app.Fragment page, String alias);

    /**
     * 设置忽略的页面, 被设置忽略的页面，不再触发无埋点的page事件。
     *
     * @param page   需要忽略的页面对象，建议在onCreate生命周期中调用
     * @param policy {@link IgnorePolicy}
     */
    void ignorePage(Activity page, IgnorePolicy policy);

    /**
     * 设置忽略的页面, 被设置忽略的页面，不再触发无埋点的page事件。
     *
     * @param page   需要忽略的页面对象，建议在onCreate生命周期中调用
     * @param policy {@link IgnorePolicy}
     */
    void ignorePage(android.app.Fragment page, IgnorePolicy policy);

    /**
     * 设置忽略的页面, 被设置忽略的页面，不再触发无埋点的page事件。
     *
     * @param page   需要忽略的页面对象，建议在onCreate生命周期中调用
     * @param policy {@link IgnorePolicy}
     */
    void ignorePage(android.support.v4.app.Fragment page, IgnorePolicy policy);

    /**
     * 设置忽略的页面, 被设置忽略的页面，不再触发无埋点的page事件。
     *
     * @param page   需要忽略的页面对象，建议在onCreate生命周期中调用
     * @param policy {@link IgnorePolicy}
     */
    void ignorePage(androidx.fragment.app.Fragment page, IgnorePolicy policy);

    /**
     * 设置采集View的曝光事件，当被设置的View出现在屏幕内时将触发曝光事件
     *
     * @param view                需要采集曝光事件的View对象
     * @param impressionEventName 曝光的事件名
     */
    void trackViewImpression(View view, String impressionEventName);

    /**
     * 设置采集View的曝光事件，当被设置的View出现在屏幕内时将触发曝光事件
     *
     * @param view                需要采集曝光事件的View对象
     * @param impressionEventName 曝光的事件名
     * @param attributes          曝光的事件属性
     */
    void trackViewImpression(View view, String impressionEventName, Map<String, String> attributes);

    /**
     * 停止采集View的曝光事件
     *
     * @param trackedView 需要停止采集曝光事件的View对象
     */
    void stopTrackViewImpression(View trackedView);

    /**
     * 设置忽略的View，被设置忽略的VIew，不再触发点击、曝光等任何事件，被忽略的WebView也不会采集Hybrid的事件。
     *
     * @param view   需要忽略的View对象
     * @param policy {@link IgnorePolicy}
     */
    void ignoreView(View view, IgnorePolicy policy);

    /**
     * 给View设置唯一的Tag，方便点击等事件确定唯一的View，一般用于动态布局的场景
     *
     * @param view 需要设置唯一Tag的View对象
     * @param tag  需要设置的Tag
     */
    void setUniqueTag(View view, String tag);
}
