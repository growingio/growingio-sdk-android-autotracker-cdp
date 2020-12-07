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
import android.os.Build;
import android.webkit.WebView;

import com.growingio.android.sdk.autotrack.CdpAutotrackConfiguration;
import com.growingio.android.sdk.autotrack.GrowingAutotracker;
import com.growingio.android.sdk.track.CdpTrackConfiguration;
import com.growingio.android.sdk.track.GrowingTracker;

public class App extends Application {
    private boolean mIsAutotracker = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (mIsAutotracker) {
            GrowingAutotracker.startWithConfiguration(this,
                    new CdpAutotrackConfiguration("bfbb9ccbd64c2232", "growing.d80871b41ef40518")
                            .setDataCollectionServerHost("http://106.75.81.105:8080/")
                            .setDataSourceId("aa87ed9f71c2edf9")
                            .setDebugEnabled(true));
        } else {
            GrowingTracker.startWithConfiguration(this, new CdpTrackConfiguration("cdpProjectId", "cdpUrlScheme")
                    .setDataSourceId("cdpDataSourceId")
                    .setDebugEnabled(true));
        }
    }
}
