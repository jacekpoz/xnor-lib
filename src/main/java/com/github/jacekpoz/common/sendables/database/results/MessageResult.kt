package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.MessageQuery
import com.fasterxml.jackson.annotation.JsonGetter
import com.github.jacekpoz.common.sendables.Message
import java.util.ArrayList

open class MessageResult @JsonCreator constructor(
    @JsonProperty("query") override val query: MessageQuery?,
) : Result<Message> {

    @JsonProperty("messages")
    private val messages: MutableList<Message> = ArrayList()

    @JsonProperty("success")
    override var success = false

    @JsonGetter("messages")
    override fun get(): List<Message> {
        return messages
    }

    override operator fun get(index: Int): Message {
        return messages[index]
    }

    override fun add(item: Message) {
        messages.add(item)
    }

    override fun add(items: List<Message>) {
        this.messages.addAll(items)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MessageResult) return false

        if (query != other.query) return false
        if (messages != other.messages) return false
        if (success != other.success) return false

        return true
    }

    override fun hashCode(): Int {
        var result = query.hashCode()
        result = 31 * result + messages.hashCode()
        result = 31 * result + success.hashCode()
        return result
    }

    override fun toString(): String = "MessageResult(query=$query, messages=$messages, success=$success)"

}