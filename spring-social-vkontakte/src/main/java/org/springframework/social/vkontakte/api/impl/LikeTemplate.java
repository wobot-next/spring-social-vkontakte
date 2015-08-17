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
package org.springframework.social.vkontakte.api.impl;

import java.net.URI;
import java.util.Properties;

import org.springframework.social.vkontakte.api.ApiVersion;
import org.springframework.social.vkontakte.api.ILikeOperations;
import org.springframework.social.vkontakte.api.VKGenericResponse;
import org.springframework.social.vkontakte.api.impl.json.VKArray;
import org.springframework.social.vkontakte.api.vkenums.ObjectType;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {@link org.springframework.social.vkontakte.api.ILikeOperations} implementation.
 * @author XaeroZero
 */
public class LikeTemplate extends AbstractVKontakteOperations implements ILikeOperations {
    private final RestTemplate restTemplate;

    public LikeTemplate(RestTemplate restTemplate, String accessToken, ObjectMapper objectMapper, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser, accessToken, objectMapper);
        this.restTemplate = restTemplate;
    }

	public VKArray<String> getLikes(ObjectType type, Long ownerId, Long itemId, String pageUrl, String filter, int friendsOnly,
			int extended, int offset, int count, int skipOwn) {
		Properties props = new Properties();
		props.put("type", type);
		props.put("owner_id", ownerId);
		props.put("item_id", itemId);
		if(!StringUtils.isEmpty(pageUrl))
			props.put("page_url", pageUrl);
		if(!StringUtils.isEmpty(filter))
			props.put("filter", filter);
		if(friendsOnly>0)
			props.put("friends_only", friendsOnly);
		if(extended>0)
			props.put("extended", extended);
		if(offset>0)
			props.put("offset", offset);
		if(count>0)
			props.put("count", count);
		if(skipOwn>0)
			props.put("skip_own", skipOwn);

		// http://vk.com/dev/likes.getList
        URI uri = makeOperationURL("likes.getList", props, ApiVersion.VERSION_5_37);
        VKGenericResponse response = restTemplate.getForObject(uri, VKGenericResponse.class);
        checkForError(response);

        return deserializeVK50ItemsResponse(response, String.class);
	}

	public VKArray<String> getLikes(ObjectType type, Long ownerId, Long itemId,int offset, int count) {
		return getLikes(type,ownerId,itemId,null,null,0,0,offset,count,1);
	}

	public VKArray<String> getLikes(ObjectType type, Long ownerId, Long itemId) {
		return getLikes(type,ownerId,itemId,null,null,0,0,0,1000,1);
	}

}
