package com.github.jacekpoz.common.sendables.database.queries.basequeries

import com.github.jacekpoz.common.sendables.Chat

/**
 * Base query for doing stuff with chats containing fields used in most chat queries.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
abstract class ChatQuery(
    open val chatID: Long,
    override val callerID: Long,
) : Query<Chat> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChatQuery) return false

        if (chatID != other.chatID) return false
        if (callerID != other.callerID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = chatID.hashCode()
        result = 31 * result + callerID.hashCode()
        return result
    }

    override fun toString(): String = "ChatQuery(chatID=$chatID, callerID=$callerID)"


}