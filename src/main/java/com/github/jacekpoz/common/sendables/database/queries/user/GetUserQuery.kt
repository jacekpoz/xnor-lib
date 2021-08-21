package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class GetUserQuery @JsonCreator constructor(
    @JsonProperty("userID") userID: Long = -1,
    @JsonProperty("username") val username: String? = null,
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(userID, callerID) {

    constructor(
        userID: Long,
        callerID: Long,
    ) : this(userID, null, callerID)

    constructor(
        username: String?,
        callerID: Long,
    ) : this(-1, username, callerID)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetUserQuery) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (username?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String = "GetUserQuery(userID=$userID, username='$username', callerID=$callerID)"

}