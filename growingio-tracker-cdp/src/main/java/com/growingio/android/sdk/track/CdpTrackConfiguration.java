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

import androidx.annotation.NonNull;

public class CdpTrackConfiguration extends TrackConfiguration {
    private String mDataSourceId;

    /**
     * 埋点SDK 初始化配置
     *
     * @param projectId 官网的中您的项目ID
     * @param urlScheme 官网的中您的相应APP的UrlScheme
     */
    public CdpTrackConfiguration(String projectId, String urlScheme) {
        super(projectId, urlScheme);
    }

    public String getDataSourceId() {
        return mDataSourceId;
    }

    /**
     * 设置dataSourceId
     *
     * @param dataSourceId 官网的中您的相应APP的DataSourceId
     * @return this
     */
    public CdpTrackConfiguration setDataSourceId(String dataSourceId) {
        mDataSourceId = dataSourceId;
        return this;
    }

    /**
     * 是否采集数据
     *
     * @param dataCollectionEnabled 采集开关，默认值 true
     * @return this
     */
    @Override
    public CdpTrackConfiguration setDataCollectionEnabled(boolean dataCollectionEnabled) {
        super.setDataCollectionEnabled(dataCollectionEnabled);
        return this;
    }

    /**
     * 设置APP的分发渠道
     *
     * @param channel 渠道名
     * @return this
     */
    @Override
    public CdpTrackConfiguration setChannel(String channel) {
        super.setChannel(channel);
        return this;
    }

    /**
     * 收集SDK内部异常上报服务端
     *
     * @param uploadExceptionEnabled 上报开关，默认值 true
     * @return this
     */
    @Override
    public CdpTrackConfiguration setUploadExceptionEnabled(boolean uploadExceptionEnabled) {
        super.setUploadExceptionEnabled(uploadExceptionEnabled);
        return this;
    }

    /**
     * 调试模式，会打印SDK log，抛出错误异常，在线上环境务必关闭
     *
     * @param enabled 调试开关，默认值 false
     * @return this
     */
    @Override
    public CdpTrackConfiguration setDebugEnabled(boolean enabled) {
        super.setDebugEnabled(enabled);
        return this;
    }

    /**
     * 每天发送数据的流量限制，单位MB
     *
     * @param cellularDataLimit 流量阈值，默认值 10
     * @return this
     */
    @Override
    public CdpTrackConfiguration setCellularDataLimit(int cellularDataLimit) {
        super.setCellularDataLimit(cellularDataLimit);
        return this;
    }

    /**
     * 数据发送的间隔，单位秒
     *
     * @param dataUploadInterval 时间间隔，默认值 15
     * @return this
     */
    @Override
    public CdpTrackConfiguration setDataUploadInterval(int dataUploadInterval) {
        super.setDataUploadInterval(dataUploadInterval);
        return this;
    }

    /**
     * 每次访问会话的最大时长，单位秒
     *
     * @param sessionInterval 时间间隔，默认值 30
     * @return this
     */
    @Override
    public CdpTrackConfiguration setSessionInterval(int sessionInterval) {
        super.setSessionInterval(sessionInterval);
        return this;
    }

    /**
     * 您部署服务的后端Host
     *
     * @param dataCollectionServerHost 如"http://myhost.com/"
     * @return this
     */
    @Override
    public CdpTrackConfiguration setDataCollectionServerHost(String dataCollectionServerHost) {
        super.setDataCollectionServerHost(dataCollectionServerHost);
        return this;
    }

    /**
     * 是否采集Android OAID，如果设置为采集的话，受OAID获取时间的限制，事件采集可能会延迟
     *
     * @param enabled 采集开关，默认值 false
     * @return this
     */
    @Override
    public CdpTrackConfiguration setOaidEnabled(boolean enabled) {
        super.setOaidEnabled(enabled);
        return this;
    }

    @NonNull
    @Override
    public CdpTrackConfiguration clone() {
        return new CdpTrackConfiguration(getProjectId(), getUrlScheme())
                .setChannel(getChannel())
                .setDebugEnabled(isDebugEnabled())
                .setCellularDataLimit(getCellularDataLimit())
                .setDataUploadInterval(getDataUploadInterval())
                .setSessionInterval(getSessionInterval())
                .setUploadExceptionEnabled(isUploadExceptionEnabled())
                .setDataCollectionEnabled(isDataCollectionEnabled())
                .setDataCollectionServerHost(getDataCollectionServerHost())
                .setDataSourceId(getDataSourceId())
                .setOaidEnabled(isOaidEnabled());
    }
}
