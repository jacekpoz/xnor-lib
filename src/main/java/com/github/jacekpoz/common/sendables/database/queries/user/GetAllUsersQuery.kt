package com.github.jacekpoz.common.sendables.database.queries.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery

open class GetAllUsersQuery @JsonCreator constructor(
    @JsonProperty("callerID") callerID: Long,
) : UserQuery(-1, callerID) {

    override fun toString(): String = "GetAllUsersQuery(callerID=$callerID)"
}