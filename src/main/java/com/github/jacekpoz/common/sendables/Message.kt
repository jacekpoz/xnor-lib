package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Do I really have to describe this class?
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class Message @JsonCreator constructor(
    @JsonProperty("messageID") val messageID: Long,
    @JsonProperty("chatID") val chatID: Long,
    @JsonProperty("authorID") val authorID: Long,
    @JsonProperty("content") var content: String,
    @JsonProperty("dateSent") val sentDate: LocalDateTime? = LocalDateTime.MIN,
) : Sendable {

    constructor(
        content: String
    ): this(-1, -1, -1, content, LocalDateTime.MIN)

    @JsonProperty("attachments")
    val attachments: List<Attachment> = ArrayList()

    override fun equals(other: Any?): Boolean = (other is Message) &&
            messageID == other.messageID &&
            chatID == other.chatID &&
            authorID == other.authorID

    override fun hashCode(): Int {
        var result = messageID.hashCode()
        result = 31 * result + chatID.hashCode()
        result = 31 * result + authorID.hashCode()
        return result
    }
}
