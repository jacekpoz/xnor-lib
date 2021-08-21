package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery
import com.github.jacekpoz.common.sendables.Chat
import com.fasterxml.jackson.annotation.JsonGetter
import com.github.jacekpoz.common.sendables.User
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery
import java.util.ArrayList

open class UserResult @JsonCreator constructor(
    @JsonProperty("query") override val query: UserQuery?
) : Result<User> {

    @JsonProperty("users")
    private val users: MutableList<User> = ArrayList()

    @JsonProperty("success")
    override var success = false

    @JsonGetter("users")
    override fun get(): List<User> {
        return users
    }

    override fun get(index: Int): User {
        return users[index]
    }

    override fun add(item: User) {
        users.add(item)
    }

    override fun add(items: List<User>) {
        users.addAll(items)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserResult) return false

        if (query != other.query) return false
        if (users != other.users) return false
        if (success != other.success) return false

        return true
    }

    override fun hashCode(): Int {
        var result = query.hashCode()
        result = 31 * result + users.hashCode()
        result = 31 * result + success.hashCode()
        return result
    }

    override fun toString(): String = "UserResult(query=$query, chats=$users, success=$success)"

}