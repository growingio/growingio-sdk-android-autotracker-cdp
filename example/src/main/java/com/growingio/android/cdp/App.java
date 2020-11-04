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

package com.growingio.android.cdp;

import android.app.Application;

import com.growingio.android.sdk.autotrack.CdpAutotrackConfiguration;
import com.growingio.android.sdk.autotrack.GrowingAutotracker;
import com.growingio.android.sdk.track.CdpTrackConfiguration;
import com.growingio.android.sdk.track.GrowingTracker;

public class App extends Application {
    private boolean mIsAutotracker = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mIsAutotracker) {
            GrowingAutotracker.startWithConfiguration(this, new CdpAutotrackConfiguration()
                    .setProjectId("cdpProjectId")
                    .setDataSourceId("cdpDataSourceId")
                    .setUrlScheme("cdpUrlScheme")
                    .setDebugEnabled(true));
        } else {
            GrowingTracker.startWithConfiguration(this, new CdpTrackConfiguration()
                    .setProjectId("cdpProjectId")
                    .setDataSourceId("cdpDataSourceId")
                    .setUrlScheme("cdpUrlScheme")
                    .setDebugEnabled(true));
        }
    }
}
