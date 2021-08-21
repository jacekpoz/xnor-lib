package com.github.jacekpoz.common.sendables.database.queries.message

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery

open class GetMessageQuery @JsonCreator constructor(
    @JsonProperty("messageID") messageID: Long,
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("callerID") callerID: Long,
) : MessageQuery(messageID, chatID, callerID) {

    override fun toString(): String = "GetMessageQuery(messageID=$messageID, chatID=$chatID, callerID=$callerID)"
}