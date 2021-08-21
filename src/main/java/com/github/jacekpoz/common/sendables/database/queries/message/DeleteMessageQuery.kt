package com.github.jacekpoz.common.sendables.database.queries.message

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery

open class DeleteMessageQuery @JsonCreator constructor(
    @JsonProperty("messageID") messageID: Long = -1,
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("callerID") callerID: Long
) : MessageQuery(messageID, chatID, callerID) {

    override fun toString(): String = "DeleteMessageQuery(messageID=$messageID, chatID=$chatID, callerID=$callerID)"
}