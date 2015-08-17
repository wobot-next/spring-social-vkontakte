/*
 * Copyright 2015 the original author or authors.
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
package org.springframework.social.vkontakte.api;

import org.springframework.social.vkontakte.api.impl.json.VKArray;
import org.springframework.social.vkontakte.api.vkenums.ObjectType;

/**
 * User operations.
 * @author XaeroZero
 */
public interface ILikeOperations {
    /**
     * Retrieve Likes for specified itemId and ownerId.</br>
     * TODO: Add Description
     */
	VKArray<String> getLikes(ObjectType type, Long ownerId,Long itemId,String pageUrl,
			String filter,int friendsOnly,int extended, int offset, int count, int skipOwn);

	VKArray<String> getLikes(ObjectType type,Long ownerId,Long itemId,int offset, int count);

	VKArray<String> getLikes(ObjectType type,Long ownerId,Long itemId);
}
