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

enum EmptyGrowingTracker implements IGrowingTracker {
    INSTANCE;

    @Override
    public void trackCustomEvent(String eventName) {

    }

    @Override
    public void trackCustomEvent(String eventName, Map<String, String> attributes) {

    }

    @Override
    public void trackCustomEvent(String eventName, String itemKey, String itemId) {

    }

    @Override
    public void trackCustomEvent(String eventName, Map<String, String> attributes, String itemKey, String itemId) {

    }

    @Override
    public void setLoginUserAttributes(Map<String, String> attributes) {

    }

    @Override
    public void setLoginUserId(String userId) {

    }

    @Override
    public void cleanLoginUserId() {

    }

    @Override
    public void setLocation(double latitude, double longitude) {

    }

    @Override
    public void cleanLocation() {

    }

    @Override
    public void setDataCollectionEnabled(boolean enabled) {

    }

    @Nullable
    @Override
    public String getDeviceId() {
        return null;
    }

}
