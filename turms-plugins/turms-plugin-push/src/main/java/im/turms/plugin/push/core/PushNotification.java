/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
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

package im.turms.plugin.push.core;

import jakarta.annotation.Nullable;

/**
 * @author James Chen
 */
public record PushNotification(
        PushNotificationType type,
        PushNotificationServiceProvider serviceProvider,
        String deviceToken,
        @Nullable String title,
        String body,
        @Nullable Integer badgeNumber
) {

    public String toStringWithoutDate() {
        return "PushNotification{" +
                "type=" + type +
                ", serviceProvider=" + serviceProvider +
                ", deviceToken=\"" + deviceToken + '\"' +
                ", title=\"" + title + '\"' +
                ", body=\"" + body + '\"' +
                ", badgeNumber=" + badgeNumber +
                '}';
    }

}