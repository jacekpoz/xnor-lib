package com.github.jacekpoz.common.sendables.database.queries.chat

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery

open class DeleteChatQuery @JsonCreator constructor(
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("callerID") callerID: Long,
) : ChatQuery(chatID, callerID) {

    override fun toString(): String = "DeleteChatQuery(chatID=$chatID, callerID=$callerID)"
}