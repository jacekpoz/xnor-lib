package com.github.jacekpoz.common.sendables.database.queries.message

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery

open class ModifyMessageQuery @JsonCreator constructor(
    @JsonProperty("messageID") messageID: Long,
    @JsonProperty("chatID") chatID: Long,
    @JsonProperty("columnToModify") private val columnToModify: String,
    @JsonProperty("newValue") private val newValue: String,
    @JsonProperty("callerID") callerID: Long
) : MessageQuery(messageID, chatID, callerID) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ModifyMessageQuery) return false
        if (!super.equals(other)) return false

        if (columnToModify != other.columnToModify) return false
        if (newValue != other.newValue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + columnToModify.hashCode()
        result = 31 * result + newValue.hashCode()
        return result
    }

    override fun toString(): String = "ModifyMessageQuery(messageID=$messageID, chatID=$chatID, columnToModify='$columnToModify', newValue='$newValue', callerID=$callerID)"
}