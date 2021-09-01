package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class AcceptFriendRequestQuery @JsonCreator constructor(
    @JsonProperty("senderID") senderID: Long,
    @JsonProperty("friendID") val friendID: Long,
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(senderID, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AcceptFriendRequestQuery) return false
        if (!super.equals(other)) return false

        if (friendID != other.friendID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + friendID.hashCode()
        return result
    }

    override fun toString(): String = "AcceptFriendRequestQuery(senderID=$userID, friendID=$friendID, callerID=$callerID)"
}