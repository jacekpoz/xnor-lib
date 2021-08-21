package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Generic class description.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class Chat @JsonCreator constructor(
    @JsonProperty("chatID") val chatID: Long = -1,
    @JsonProperty("chatName") var chatName: String?,
    @JsonProperty("dateCreated") val created: LocalDateTime? = LocalDateTime.MIN,
    @JsonProperty("messageCounter") var messageCounter: Long = -1,
) : Sendable {

    val memberIDs: MutableList<Long> = ArrayList()
    val messages: MutableList<Message> = ArrayList()

    override fun equals(other: Any?): Boolean = (other is Chat) && chatID == other.chatID
    override fun hashCode(): Int = chatID.hashCode()
    override fun toString(): String = "Chat(chatID=$chatID, chatName=$chatName)"
}
