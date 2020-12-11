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

import androidx.annotation.Nullable;

import java.util.Map;

/**
 * GrowingAutotracker 无埋点 SDK 对外 API
 */
public interface IGrowingAutotracker {
    /**
     * 发送一个自定义事件。
     * 在添加所需要发送的事件代码之前，需要在事件管理用户界面配置事件以及事件级变量。
     *
     * @param eventName 事件名，事件标识符
     */
    void trackCustomEvent(String eventName);

    /**
     * 发送一个自定义事件。
     * 在添加所需要发送的事件代码之前，需要在事件管理用户界面配置事件以及事件级变量。
     *
     * @param eventName  事件名，事件标识符
     * @param attributes 事件发生时所伴随的维度信息
     */
    void trackCustomEvent(String eventName, Map<String, String> attributes);

    /**
     * 发送一个自定义事件。
     * 在添加所需要发送的事件代码之前，需要在事件管理用户界面配置事件以及事件级变量。
     *
     * @param eventName 事件名，事件标识符
     * @param itemKey   事件发生关联的物品模型Key
     * @param itemId    事件发生关联的物品模型ID
     */
    void trackCustomEvent(String eventName, String itemKey, String itemId);

    /**
     * 发送一个自定义事件。
     * 在添加所需要发送的事件代码之前，需要在事件管理用户界面配置事件以及事件级变量。
     *
     * @param eventName  事件名，事件标识符
     * @param attributes 事件发生时所伴随的维度信息
     * @param itemKey    事件发生关联的物品模型Key
     * @param itemId     事件发生关联的物品模型ID
     */
    void trackCustomEvent(String eventName, Map<String, String> attributes, String itemKey, String itemId);

    /**
     * 以登录用户的身份定义用户属性变量，用于用户信息相关分析。
     *
     * @param attributes 用户属性信息
     */
    void setLoginUserAttributes(Map<String, String> attributes);

    /**
     * 当用户登录之后调用，设置登录用户ID
     *
     * @param userId 用户ID，长度限制大于0且小于等于1000，如果大于长度1000将只截取前1000长度
     */
    void setLoginUserId(String userId);

    /**
     * 当用户登出之后调用，清除已经设置的登录用户ID。
     */
    void cleanLoginUserId();

    /**
     * 设置用户当前的地理位置，基于WGS-84坐标
     *
     * @param latitude  地理坐标点纬度
     * @param longitude 地理坐标点经度
     */
    void setLocation(double latitude, double longitude);

    /**
     * 清除用户当前的地理位置
     */
    void cleanLocation();

    /**
     * 打开或关闭数据采集
     * 如果关闭，从代码调用开始, 后续所有事件不再采集, 但是之前采集生成的历史数据仍会发送
     *
     * @param enabled true打开数据采集，false关闭数据采集
     */
    void setDataCollectionEnabled(boolean enabled);

    /**
     * 获取deviceId，又称为匿名用户id，SDK 自动生成用来定义唯一设备。
     * 如果没有初始化SDK 或者关闭采集开关可能返回值为null，且可能有IO操作
     *
     * @return deviceId，又称为匿名用户id
     */
    @Nullable
    String getDeviceId();

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
