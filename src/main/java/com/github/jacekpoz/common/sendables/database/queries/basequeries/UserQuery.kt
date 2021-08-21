package com.github.jacekpoz.common.sendables.database.queries.basequeries

import com.github.jacekpoz.common.sendables.User

/**
 * Base query for doing stuff with users containing fields used in most user queries.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
abstract class UserQuery(
    open val userID: Long,
    override val callerID: Long,
) : Query<User> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserQuery) return false

        if (userID != other.userID) return false
        if (callerID != other.callerID) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userID.hashCode()
        result = 31 * result + callerID.hashCode()
        return result
    }

    override fun toString(): String = "UserQuery(userID=$userID, callerID=$callerID)"

}