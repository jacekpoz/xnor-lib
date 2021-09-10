package com.github.jacekpoz.common.sendables.database.queries

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.Chat

/**
 * Query used for chats.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class ChatQuery @JsonCreator constructor(
    @JsonProperty("update") override val update: Boolean,
    @JsonProperty("callerID") override val callerID: Long,
    @JsonProperty("queryType") override val queryType: QueryEnum<Chat>,
) : Query<Chat> {

    @JsonProperty("values") override val values: MutableMap<String, Any> = mutableMapOf()

}