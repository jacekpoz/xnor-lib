@file:JvmName("QueryEnums")
package com.github.jacekpoz.common.sendables.database.queries

import com.github.jacekpoz.common.sendables.Chat
import com.github.jacekpoz.common.sendables.FriendRequest
import com.github.jacekpoz.common.sendables.Message
import com.github.jacekpoz.common.sendables.User

interface QueryEnum<T> {
    val allowedValues: Map<String, Class<*>>
}

enum class ChatQueryEnum constructor(
    override val allowedValues: Map<String, Class<*>>
    ) : QueryEnum<Chat> {
    DELETE_CHAT(
        mapOf(
            Pair("chatID", Long::class.java),
        )
    ),
    GET_CHAT(
        mapOf(
            Pair("chatID", Long::class.java),
        )
    ),
    GET_USERS_CHATS(
        mapOf(
            Pair("userID", Long::class.java),
        )
    ),
    INSERT_CHAT(
        mapOf(
            Pair("chatName", String::class.java),
            Pair("memberIDs", LongArray::class.java),
        )
    ),
    MODIFY_CHAT(
        mapOf(
            Pair("chatID", Long::class.java),
            Pair("columnToModify", String::class.java),
            Pair("newValue", String::class.java),
        )
    ),
}

enum class MessageQueryEnum constructor(
    override val allowedValues: Map<String, Class<*>>
) : QueryEnum<Message> {
    DELETE_MESSAGE(
        mapOf(
            Pair("messageID", Long::class.java),
            Pair("chatID", Long::class.java),
        )
    ),
    DELETE_MESSAGES_IN_CHAT(
       mapOf(
           Pair("chatID", Long::class.java),
       )
    ),
    GET_MESSAGE(
        mapOf(
            Pair("messageID", Long::class.java),
            Pair("chatID", Long::class.java),
        )
    ),
    GET_MESSAGES_IN_CHAT(
        mapOf(
            Pair("chatID", Long::class.java),
            Pair("offset", Long::class.java),
            Pair("limit", Long::class.java),
        )
    ),
    INSERT_MESSAGE(
        mapOf(
            Pair("messageID", Long::class.java),
            Pair("chatID", Long::class.java),
            Pair("authorID", Long::class.java),
            Pair("content", String::class.java),
        )
    ),
    MODIFY_MESSAGE(
        mapOf(
            Pair("messageID", Long::class.java),
            Pair("chatID", Long::class.java),
            Pair("columnToModify", String::class.java),
            Pair("newValue", String::class.java),
        )
    ),
}

enum class UserQueryEnum constructor(
    override val allowedValues: Map<String, Class<*>>
) : QueryEnum<User> {
    DELETE_USER(
        mapOf(
            Pair("userID", Long::class.java),
        )
    ),
    GET_USER(
        mapOf(
            Pair("userID", Long::class.java),
            Pair("username", String::class.java),
        )
    ),
    MODIFY_USER(
        mapOf(
            Pair("userID", Long::class.java),
            Pair("columnToModify", String::class.java),
            Pair("newValue", String::class.java),
        )
    ),
    LOGIN(
        mapOf(
            Pair("username", String::class.java),
            Pair("password", ByteArray::class.java),
        )
    ),
    REGISTER(
        mapOf(
            Pair("username", String::class.java),
            Pair("hash", String::class.java),
        )
    ),
    GET_ALL_USERS(
        mapOf(

        )
    ),
    GET_FRIENDS(
        mapOf(
            Pair("userID", Long::class.java),
        )
    ),
    GET_MESSAGE_AUTHOR(
        mapOf(
            Pair("messageID", Long::class.java),
            Pair("chatID", Long::class.java),
        )
    ),
    GET_USERS_IN_CHAT(
        mapOf(
            Pair("chatID", Long::class.java),
        )
    ),
    REMOVE_FRIEND(
        mapOf(
            Pair("userID", Long::class.java),
            Pair("friendID", Long::class.java),
        )
    ),
}

enum class FriendRequestQueryEnum constructor(
    override val allowedValues: Map<String, Class<*>>
) : QueryEnum<FriendRequest> {
    GET_FRIEND_REQUESTS(
        mapOf(
            Pair("userID", Long::class.java),
        )
    ),
    SEND_FRIEND_REQUEST(
        mapOf(
            Pair("senderID", Long::class.java),
            Pair("receiverID", Long::class.java),
        )
    ),
    ACCEPT_FRIEND_REQUEST(
        mapOf(
            Pair("senderID", Long::class.java),
            Pair("receiverID", Long::class.java),
        )
    ),
    DENY_FRIEND_REQUEST(
        mapOf(
            Pair("senderID", Long::class.java),
            Pair("receiverID", Long::class.java),
        )
    ),
}