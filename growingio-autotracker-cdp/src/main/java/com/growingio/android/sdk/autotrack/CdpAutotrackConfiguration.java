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

import androidx.annotation.NonNull;

public class CdpAutotrackConfiguration extends AutotrackConfiguration {
    private String mDataSourceId;

    public CdpAutotrackConfiguration(String projectId, String urlScheme) {
        super(projectId, urlScheme);
    }

    public String getDataSourceId() {
        return mDataSourceId;
    }

    public CdpAutotrackConfiguration setDataSourceId(String dataSourceId) {
        mDataSourceId = dataSourceId;
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setImpressionScale(float scale) {
        super.setImpressionScale(scale);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setChannel(String channel) {
        super.setChannel(channel);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setUploadExceptionEnabled(boolean uploadExceptionEnabled) {
        super.setUploadExceptionEnabled(uploadExceptionEnabled);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setDebugEnabled(boolean enabled) {
        super.setDebugEnabled(enabled);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setCellularDataLimit(int cellularDataLimit) {
        super.setCellularDataLimit(cellularDataLimit);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setDataUploadInterval(int dataUploadInterval) {
        super.setDataUploadInterval(dataUploadInterval);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setSessionInterval(int sessionInterval) {
        super.setSessionInterval(sessionInterval);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setDataCollectionEnabled(boolean dataCollectionEnabled) {
        super.setDataCollectionEnabled(dataCollectionEnabled);
        return this;
    }

    @Override
    public CdpAutotrackConfiguration setDataCollectionServerHost(String dataCollectionServerHost) {
        super.setDataCollectionServerHost(dataCollectionServerHost);
        return this;
    }

    @NonNull
    @Override
    public CdpAutotrackConfiguration clone() {
        return new CdpAutotrackConfiguration(getProjectId(), getUrlScheme())
                .setChannel(getChannel())
                .setDebugEnabled(isDebugEnabled())
                .setCellularDataLimit(getCellularDataLimit())
                .setDataUploadInterval(getDataUploadInterval())
                .setSessionInterval(getSessionInterval())
                .setUploadExceptionEnabled(isUploadExceptionEnabled())
                .setDataCollectionEnabled(isDataCollectionEnabled())
                .setDataCollectionServerHost(getDataCollectionServerHost())
                .setImpressionScale(getImpressionScale())
                .setDataSourceId(getDataSourceId());
    }
}
