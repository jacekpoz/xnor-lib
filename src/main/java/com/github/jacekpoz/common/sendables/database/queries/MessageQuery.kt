package com.github.jacekpoz.common.sendables.database.queries

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.Message

/**
 * Query used for messages.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class MessageQuery @JsonCreator constructor(
    @JsonProperty("update") override val update: Boolean,
    @JsonProperty("callerID") override val callerID: Long,
    @JsonProperty("queryType") override val queryType: MessageQueryEnum,
) : Query<Message> {

    @JsonProperty("values") override val values: MutableMap<String, Any> = mutableMapOf()

}