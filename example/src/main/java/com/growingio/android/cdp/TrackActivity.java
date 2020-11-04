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

import android.app.Activity;
import android.os.Bundle;

import com.growingio.android.sdk.track.GrowingTracker;

public class TrackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        findViewById(R.id.btn_set_user_zhangsan).setOnClickListener(v -> {
            GrowingTracker.get().setLoginUserId("zhangsan");
        });
        findViewById(R.id.btn_clean_userId).setOnClickListener(v -> {
            GrowingTracker.get().cleanLoginUserId();
        });
        findViewById(R.id.btn_set_user_lisi).setOnClickListener(v -> {
            GrowingTracker.get().setLoginUserId("lisi");
        });
        findViewById(R.id.btn_track_item_custom).setOnClickListener(v -> {
            GrowingTracker.get().trackCustomEvent("testCustomEvent", "itemKey", "itemValue");
        });
    }
}