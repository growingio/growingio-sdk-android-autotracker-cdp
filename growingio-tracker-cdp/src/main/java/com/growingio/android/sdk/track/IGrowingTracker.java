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

package com.growingio.android.sdk.track;


import androidx.annotation.Nullable;

import java.util.Map;

/**
 * GrowingIO 对外提供的埋点接口
 */
public interface IGrowingTracker {

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
}
