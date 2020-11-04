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

    public String getDataSourceId() {
        return mDataSourceId;
    }

    public CdpTrackConfiguration setDataSourceId(String dataSourceId) {
        mDataSourceId = dataSourceId;
        return this;
    }

    @Override
    public CdpTrackConfiguration setProjectId(String projectId) {
        super.setProjectId(projectId);
        return this;
    }

    @Override
    public CdpTrackConfiguration setDataCollectionEnabled(boolean dataCollectionEnabled) {
        super.setDataCollectionEnabled(dataCollectionEnabled);
        return this;
    }

    @Override
    public CdpTrackConfiguration setUrlScheme(String urlScheme) {
        super.setUrlScheme(urlScheme);
        return this;
    }

    @Override
    public CdpTrackConfiguration setChannel(String channel) {
        super.setChannel(channel);
        return this;
    }

    @Override
    public CdpTrackConfiguration setUploadExceptionEnabled(boolean uploadExceptionEnabled) {
        super.setUploadExceptionEnabled(uploadExceptionEnabled);
        return this;
    }

    @Override
    public CdpTrackConfiguration setDebugEnabled(boolean enabled) {
        super.setDebugEnabled(enabled);
        return this;
    }

    @Override
    public CdpTrackConfiguration setCellularDataLimit(int cellularDataLimit) {
        super.setCellularDataLimit(cellularDataLimit);
        return this;
    }

    @Override
    public CdpTrackConfiguration setDataUploadInterval(int dataUploadInterval) {
        super.setDataUploadInterval(dataUploadInterval);
        return this;
    }

    @Override
    public CdpTrackConfiguration setSessionInterval(int sessionInterval) {
        super.setSessionInterval(sessionInterval);
        return this;
    }

    @Override
    public CdpTrackConfiguration setDataCollectionServerHost(String dataCollectionServerHost) {
        super.setDataCollectionServerHost(dataCollectionServerHost);
        return this;
    }

    @NonNull
    @Override
    public CdpTrackConfiguration clone() {
        return new CdpTrackConfiguration()
                .setProjectId(getProjectId())
                .setUrlScheme(getUrlScheme())
                .setChannel(getChannel())
                .setDebugEnabled(isDebugEnabled())
                .setCellularDataLimit(getCellularDataLimit())
                .setDataUploadInterval(getDataUploadInterval())
                .setSessionInterval(getSessionInterval())
                .setUploadExceptionEnabled(isUploadExceptionEnabled())
                .setDataCollectionEnabled(isDataCollectionEnabled())
                .setDataCollectionServerHost(getDataCollectionServerHost())
                .setDataSourceId(getDataSourceId());
    }
}
