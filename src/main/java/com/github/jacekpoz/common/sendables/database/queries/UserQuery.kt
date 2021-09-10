package com.github.jacekpoz.common.sendables.database.queries

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.User

/**
 * Query used for users.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class UserQuery(
    @JsonProperty("update") override val update: Boolean,
    @JsonProperty("callerID") override val callerID: Long,
    @JsonProperty("queryType") override val queryType: UserQueryEnum,
) : Query<User> {

    @JsonProperty("values") override val values: MutableMap<String, Any> = mutableMapOf()

}