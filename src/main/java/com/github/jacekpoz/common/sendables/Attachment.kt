package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Attachment @JsonCreator constructor(
    @JsonProperty("attachmentID") val attachmentID: Long,
    @JsonProperty("attachmentPosition") val attachmentPosition: Long?,
    @JsonProperty("fileName") val fileName: String,
    @JsonProperty("fileExtension") val fileExtension: String,
) : Sendable {

    @JsonProperty("fileContents")
    val fileContents: List<Byte> = ArrayList()

    fun getFullName(): String = "$fileName.$fileExtension"
}
