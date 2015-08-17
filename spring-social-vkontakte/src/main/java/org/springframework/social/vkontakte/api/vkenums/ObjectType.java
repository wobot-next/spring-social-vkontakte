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
package org.springframework.social.vkontakte.api.vkenums;

/**
 * Like Object Types
 * @author XaeroZero
 */
public enum ObjectType {
	/**
	 * post on user or community wall
	 * */
	TYPE_POST("post"),
	/**
	 *  comment on a wall post
	 * */
	TYPE_COMMENT("comment"),
	/**
	 * photo
	 * */
	TYPE_PHOTO("photo"),
	/**
	 * audio
	 * */
	TYPE_AUDIO("audio"),
	/**
	 * video
	 * */
	TYPE_VIDEO("video"),
	/**
	 * note
	 * */
	TYPE_NOTE("note"),
	/**
	 * comment on the photo
	 * */
	TYPE_PHOTO_COMMENT("photo_comment"),
	/**
	 * comment on the video
	 * */
	TYPE_VIDEO_COMMENT("video_comment"),
	/**
	 * comment in the discussion
	 * */
	TYPE_TOPIC_COMMENT("topic_comment"),
	/**
	 * page of the site where the Like widget is installed
	 * */
	TYPE_SITEPAGE("sitepage");

	private final String typeName;

	private ObjectType(String typeName){
		this.typeName = typeName;
	}

	public String toString(){
		return typeName;
	}
}
