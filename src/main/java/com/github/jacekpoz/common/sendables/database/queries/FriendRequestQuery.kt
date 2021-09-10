package com.github.jacekpoz.common.sendables.database.queries

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.FriendRequest

/**
 * Query used for friend requests.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
data class FriendRequestQuery(
    @JsonProperty("update") override val update: Boolean,
    @JsonProperty("callerID") override val callerID: Long,
    @JsonProperty("queryType") override val queryType: QueryEnum<FriendRequest>,
) : Query<FriendRequest> {

    override val values: MutableMap<String, Any> = mutableMapOf()

}