package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.Chat
import com.github.jacekpoz.common.sendables.FriendRequest
import com.github.jacekpoz.common.sendables.database.queries.FriendRequestQuery

open class FriendRequestResult @JsonCreator constructor(
    @JsonProperty("query") override val query: FriendRequestQuery,
) : Result<FriendRequest> {

    @JsonProperty("friendRequests")
    private val friendRequests: MutableList<FriendRequest> = ArrayList()

    @JsonProperty("success")
    override var success = false

    @JsonGetter("chats")
    override fun get(): List<FriendRequest> {
        return friendRequests
    }

    override fun get(index: Int): FriendRequest {
        return friendRequests[index]
    }

    override fun add(item: FriendRequest) {
        friendRequests.add(item)
    }

    override fun add(items: List<FriendRequest>) {
        this.friendRequests.addAll(items)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FriendRequestResult) return false

        if (query != other.query) return false
        if (friendRequests != other.friendRequests) return false
        if (success != other.success) return false

        return true
    }

    override fun hashCode(): Int {
        var result = query.hashCode()
        result = 31 * result + friendRequests.hashCode()
        result = 31 * result + success.hashCode()
        return result
    }

    override fun toString(): String = "FriendRequestQuery(query=$query, friendRequests=$friendRequests, success=$success)"
}