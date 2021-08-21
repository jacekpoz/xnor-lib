package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class LoginQuery @JsonCreator constructor(
    @JsonProperty("username") username: String?,
    @JsonProperty("password") val password: ByteArray,
    @JsonProperty("callerID") callerID: Long,
) : GetUserQuery(username, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LoginQuery) return false
        if (!super.equals(other)) return false

        if (!password.contentEquals(other.password)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + password.contentHashCode()
        return result
    }

    override fun toString(): String = "LoginQuery(username=$username, password=${password.contentToString()}, callerID=$callerID)"
}