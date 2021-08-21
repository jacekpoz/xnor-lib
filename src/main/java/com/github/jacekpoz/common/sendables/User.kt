package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Yup.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class User @JsonCreator constructor(
    @JsonProperty("userID") val userID: Long,
    @JsonProperty("username") var username: String?,
    @JsonProperty("hashedPassword") var hashedPassword: String?,
    @JsonProperty("dateJoined") val dateJoined: LocalDateTime? = LocalDateTime.MIN,
) : Sendable {

    private val friendsIDs: MutableList<Long> = ArrayList()

    fun addFriend(u: User) = run { if (!friendsIDs.contains(u.userID)) friendsIDs.add(u.userID) }

    fun addFriend(id: Long) = run { if (!friendsIDs.contains(id)) friendsIDs.add(id) }

    fun removeFriend(u: User) = run { friendsIDs.remove(u.userID) }

    fun removeFriend(id: Long) = run { friendsIDs.remove(id) }

}
