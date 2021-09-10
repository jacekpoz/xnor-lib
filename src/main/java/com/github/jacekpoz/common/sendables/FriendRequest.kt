package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class FriendRequest @JsonCreator constructor(
    @JsonProperty("senderID") val senderID: Long,
    @JsonProperty("recipientID") val recipientID: Long,
) : Sendable
