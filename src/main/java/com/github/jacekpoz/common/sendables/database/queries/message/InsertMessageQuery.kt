package com.github.jacekpoz.common.sendables.database.queries.message

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery

open class InsertMessageQuery @JsonCreator constructor(
    @JsonProperty("messageID") messageID: Long,
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("authorID") val authorID: Long,
    @JsonProperty("content") val content: String?,
    @JsonProperty("callerID") callerID: Long,
) : MessageQuery(messageID, chatID, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is InsertMessageQuery) return false
        if (!super.equals(other)) return false

        if (authorID != other.authorID) return false
        if (content != other.content) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + authorID.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }

    override fun toString(): String = "InsertMessageQuery(messageID=$messageID, chatID=$chatID, authorID=$authorID, content='$content', callerID=$callerID)"
}