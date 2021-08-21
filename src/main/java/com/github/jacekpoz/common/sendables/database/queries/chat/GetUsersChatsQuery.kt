package com.github.jacekpoz.common.sendables.database.queries.chat

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class GetUsersChatsQuery @JsonCreator constructor(
    @JsonProperty("userID") val userID: Long,
    @JsonProperty("callerID") callerID: Long,
) : GetChatQuery(-1, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetUsersChatsQuery) return false
        if (!super.equals(other)) return false

        if (userID != other.userID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + userID.hashCode()
        return result
    }

    override fun toString(): String = "GetUsersChatsQuery(userID=$userID, callerID=$callerID)"
}