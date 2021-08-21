package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class GetFriendRequestsQuery @JsonCreator constructor(
    @JsonProperty("userID") userID: Long,
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(userID, callerID) {

    override fun toString(): String = "GetFriendRequestsQuery(userID=$userID, callerID=$callerID)"
}