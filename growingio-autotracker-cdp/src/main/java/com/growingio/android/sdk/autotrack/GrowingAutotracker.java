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
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.growingio.android.sdk.track.ContextProvider;
import com.growingio.android.sdk.track.SDKConfig;
import com.growingio.android.sdk.track.TrackMainThread;
import com.growingio.android.sdk.track.cdp.CdpEventBuildInterceptor;
import com.growingio.android.sdk.track.cdp.ResourceItem;
import com.growingio.android.sdk.track.cdp.ResourceItemCustomEvent;
import com.growingio.android.sdk.track.interfaces.ResultCallback;
import com.growingio.android.sdk.track.log.Logger;
import com.growingio.android.sdk.track.utils.ThreadUtils;

import java.util.HashMap;
import java.util.Map;

public class GrowingAutotracker implements IGrowingAutotracker {
    private static final String TAG = "GrowingAutotracker";

    private final Autotracker mAutotracker;

    private static volatile GrowingAutotracker sInstance;

    public GrowingAutotracker(Autotracker autotracker) {
        mAutotracker = autotracker;
    }

    @NonNull
    public static IGrowingAutotracker get() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (IGrowingAutotracker.class) {
            if (sInstance != null) {
                return sInstance;
            }
            return makeEmpty();
        }
    }

    public static void startWithConfiguration(Application application, CdpAutotrackConfiguration trackConfiguration) {
        if (sInstance != null) {
            Logger.e(TAG, "GrowingAutotracker is running");
            return;
        }
        if (application == null) {
            throw new IllegalStateException("application is NULL");
        }
        ContextProvider.setContext(application);

        if (TextUtils.isEmpty(trackConfiguration.getProjectId())) {
            throw new IllegalStateException("ProjectId is NULL");
        }

        if (TextUtils.isEmpty(trackConfiguration.getUrlScheme())) {
            throw new IllegalStateException("UrlScheme is NULL");
        }

        if (TextUtils.isEmpty(trackConfiguration.getDataSourceId())) {
            throw new IllegalStateException("DataSourceId is NULL");
        }

        if (!ThreadUtils.runningOnUiThread()) {
            throw new IllegalStateException("startWithConfiguration必须在主线程中调用。");
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Log.e(TAG, "GrowingAutotracker 暂不支持Android 4.2以下版本");
            return;
        }
        Autotracker autotracker = new Autotracker(application, trackConfiguration);
        TrackMainThread.trackMain().addEventBuildInterceptor(new CdpEventBuildInterceptor(trackConfiguration.getDataSourceId()));
        sInstance = new GrowingAutotracker(autotracker);

        Log.i(TAG, "!!! Thank you very much for using GrowingIO. We will do our best to provide you with the best service. !!!");
        Log.i(TAG, "!!! GrowingIO Auto Tracker version: " + SDKConfig.SDK_VERSION + " !!!");
    }

    private static IGrowingAutotracker makeEmpty() {
        Logger.e(TAG, "GrowingAutotracker is UNINITIALIZED, please initialized before use API");
        return EmptyGrowingAutotracker.INSTANCE;
    }

    @Override
    public void trackCustomEvent(String eventName) {
        mAutotracker.trackCustomEvent(eventName);
    }

    @Override
    public void trackCustomEvent(String eventName, Map<String, String> attributes) {
        mAutotracker.trackCustomEvent(eventName, attributes);
    }

    @Override
    public void trackCustomEvent(String eventName, String itemKey, String itemId) {
        trackCustomEvent(eventName, null, itemKey, itemId);
    }

    @Override
    public void trackCustomEvent(String eventName, Map<String, String> attributes, String itemKey, String itemId) {
        if (TextUtils.isEmpty(itemKey) || TextUtils.isEmpty(itemId)) {
            Logger.e(TAG, "trackCustomEvent: itemKey or itemId is NULL");
            return;
        }

        if (attributes != null) {
            attributes = new HashMap<>(attributes);
        }

        TrackMainThread.trackMain().postEventToTrackMain(
                new ResourceItemCustomEvent.Builder()
                        .setEventName(eventName)
                        .setAttributes(attributes)
                        .setResourceItem(new ResourceItem(itemKey, itemId))
        );
    }

    @Override
    public void setLoginUserAttributes(Map<String, String> attributes) {
        mAutotracker.setLoginUserAttributes(attributes);
    }

    @Override
    public void getDeviceId(@Nullable ResultCallback<String> callback) {
        mAutotracker.getDeviceId(callback);
    }

    @Override
    public void setDataCollectionEnabled(boolean enabled) {
        mAutotracker.setDataCollectionEnabled(enabled);
    }

    @Override
    public void setLoginUserId(String userId) {
        mAutotracker.setLoginUserId(userId);
    }

    @Override
    public void cleanLoginUserId() {
        mAutotracker.cleanLoginUserId();
    }

    @Override
    public void setLocation(double latitude, double longitude) {
        mAutotracker.setLocation(latitude, longitude);
    }

    @Override
    public void cleanLocation() {
        mAutotracker.cleanLocation();
    }

    @Override
    public void setUniqueTag(final View view, final String tag) {
        mAutotracker.setUniqueTag(view, tag);
    }

    @Override
    public void trackViewImpression(View view, String impressionEventName) {
        mAutotracker.trackViewImpression(view, impressionEventName);
    }

    @Override
    public void trackViewImpression(final View view, final String impressionEventName, final Map<String, String> attributes) {
        mAutotracker.trackViewImpression(view, impressionEventName, attributes);
    }

    @Override
    public void stopTrackViewImpression(final View trackedView) {
        mAutotracker.stopTrackViewImpression(trackedView);
    }

    @Override
    public void setPageAlias(final Activity page, final String alias) {
        mAutotracker.setPageAlias(page, alias);
    }

    @Override
    public void setPageAlias(final Fragment page, final String alias) {
        mAutotracker.setPageAlias(page, alias);
    }

    @Override
    public void setPageAlias(final android.support.v4.app.Fragment page, final String alias) {
        mAutotracker.setPageAlias(page, alias);
    }

    @Override
    public void setPageAlias(final androidx.fragment.app.Fragment page, final String alias) {
        mAutotracker.setPageAlias(page, alias);
    }

    @Override
    public void ignorePage(final Activity page, final IgnorePolicy policy) {
        mAutotracker.ignorePage(page, policy);
    }

    @Override
    public void ignorePage(final Fragment page, final IgnorePolicy policy) {
        mAutotracker.ignorePage(page, policy);
    }

    @Override
    public void ignorePage(final android.support.v4.app.Fragment page, final IgnorePolicy policy) {
        mAutotracker.ignorePage(page, policy);
    }

    @Override
    public void ignorePage(final androidx.fragment.app.Fragment page, final IgnorePolicy policy) {
        mAutotracker.ignorePage(page, policy);
    }

    @Override
    public void ignoreView(final View view, final IgnorePolicy policy) {
        mAutotracker.ignoreView(view, policy);
    }

}
