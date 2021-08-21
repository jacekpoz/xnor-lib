package com.github.jacekpoz.common.sendables.database.queries.message

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.Constants
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery

open class GetMessagesInChatQuery @JsonCreator constructor(
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("offset") val offset: Long = 0,
    @JsonProperty("limit") val limit: Long = Constants.DEFAULT_MESSAGES_LIMIT,
    @JsonProperty("callerID") callerID: Long,
) : MessageQuery(-1, chatID, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetMessagesInChatQuery) return false
        if (!super.equals(other)) return false

        if (offset != other.offset) return false
        if (limit != other.limit) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + offset.hashCode()
        result = 31 * result + limit.hashCode()
        return result
    }

    override fun toString(): String = "GetMessagesInChatQuery(chatID=$chatID, offset=$offset, limit=$limit, callerID=$callerID)"

}