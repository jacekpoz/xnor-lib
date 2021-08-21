package com.github.jacekpoz.common.sendables.database.queries.basequeries

import com.github.jacekpoz.common.sendables.Message

/**
 * Base query for doing stuff with messages containing fields used in most message queries.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
abstract class MessageQuery(
    open val messageID: Long,
    open val chatID: Long,
    override val callerID: Long,
) : Query<Message> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MessageQuery) return false

        if (messageID != other.messageID) return false
        if (chatID != other.chatID) return false
        if (callerID != other.callerID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = messageID.hashCode()
        result = 31 * result + chatID.hashCode()
        result = 31 * result + callerID.hashCode()
        return result
    }

    override fun toString(): String = "MessageQuery(messageID=$messageID, chatID=$chatID, callerID=$callerID)"

}