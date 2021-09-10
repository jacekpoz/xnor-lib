package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.Chat
import com.github.jacekpoz.common.sendables.database.queries.ChatQuery

open class ChatResult @JsonCreator constructor(
    @JsonProperty("query") override val query: ChatQuery,
) : Result<Chat> {

    @JsonProperty("chats")
    private val chats: MutableList<Chat> = ArrayList()

    @JsonProperty("success")
    override var success = false

    @JsonGetter("chats")
    override fun get(): List<Chat> {
        return chats
    }

    override fun get(index: Int): Chat {
        return chats[index]
    }

    override fun add(item: Chat) {
        chats.add(item)
    }

    override fun add(items: List<Chat>) {
        this.chats.addAll(items)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChatResult) return false

        if (query != other.query) return false
        if (chats != other.chats) return false
        if (success != other.success) return false

        return true
    }

    override fun hashCode(): Int {
        var result = query.hashCode()
        result = 31 * result + chats.hashCode()
        result = 31 * result + success.hashCode()
        return result
    }

    override fun toString(): String = "ChatResult(query=$query, chats=$chats, success=$success)"

}