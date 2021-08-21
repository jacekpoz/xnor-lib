package com.github.jacekpoz.common.sendables.database.queries.chat

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery

open class ModifyChatQuery @JsonCreator constructor(
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("columnToModify") val columnToModify: String?,
    @JsonProperty("newValue") val newValue: String?,
    @JsonProperty("callerID") callerID: Long,
) : ChatQuery(chatID, callerID) {

    override fun toString(): String = "ModifyChatQuery(chatID=$chatID, columnToModify=$columnToModify, newValue=$newValue, callerID=$callerID)"
}