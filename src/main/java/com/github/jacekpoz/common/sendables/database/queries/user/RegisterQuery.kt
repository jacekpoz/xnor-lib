package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class RegisterQuery @JsonCreator constructor(
    @JsonProperty("username") private val username: String,
    @JsonProperty("hash") private val hash: String,
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(-1, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RegisterQuery) return false
        if (!super.equals(other)) return false

        if (username != other.username) return false
        if (hash != other.hash) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + username.hashCode()
        result = 31 * result + hash.hashCode()
        return result
    }

    override fun toString(): String = "RegisterQuery(username='$username', hash='$hash', callerID=$callerID)"
}