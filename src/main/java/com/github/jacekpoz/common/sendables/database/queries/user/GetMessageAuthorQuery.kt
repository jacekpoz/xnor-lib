package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class GetMessageAuthorQuery @JsonCreator constructor(
    @JsonProperty("messageID") val messageID: Long,
    @JsonProperty("chatID") val chatID: Long,
    @JsonProperty("authorID") val authorID: Long,
    @JsonProperty("callerID") callerID: Long,
) : GetUserQuery(authorID, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetMessageAuthorQuery) return false
        if (!super.equals(other)) return false

        if (messageID != other.messageID) return false
        if (chatID != other.chatID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + messageID.hashCode()
        result = 31 * result + chatID.hashCode()
        return result
    }

    override fun toString(): String = "GetMessageAuthorQuery(messageID=$messageID, chatID=$chatID, authorID=$userID, callerID=$callerID)"
}