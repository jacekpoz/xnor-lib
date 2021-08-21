package com.github.jacekpoz.common.sendables.database.queries.chat


import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery

open class InsertChatQuery @JsonCreator constructor(
    @JsonProperty("chatName") val chatName: String?,
    @JsonProperty("memberIDs") val memberIDs: List<Long> = ArrayList(),
    @JsonProperty("callerIDs") callerID: Long,
) : ChatQuery(-1, callerID) {

    override fun toString(): String = "InsertChatQuery(chatName=$chatName, memberIDs=$memberIDs, callerID=$callerID)"
}