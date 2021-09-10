package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class FriendRequest @JsonCreator constructor(
    @JsonProperty("sender") val sender: User,
    @JsonProperty("recipient") val recipient: User,
) : Sendable
