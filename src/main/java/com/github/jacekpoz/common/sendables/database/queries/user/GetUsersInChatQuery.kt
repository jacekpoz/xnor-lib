package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class GetUsersInChatQuery @JsonCreator constructor(
    @JsonProperty("chatID") val chatID: Long,
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(-1, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetUsersInChatQuery) return false
        if (!super.equals(other)) return false

        if (chatID != other.chatID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + chatID.hashCode()
        return result
    }

    override fun toString(): String = "GetUsersInChatQuery(chatID=$chatID, callerID=$callerID)"
}