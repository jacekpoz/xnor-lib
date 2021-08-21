package com.github.jacekpoz.common.exceptions

import java.lang.RuntimeException
import com.github.jacekpoz.common.sendables.Sendable

open class UnknownSendableException : RuntimeException {
    constructor() : super()
    constructor(s: Sendable) : super("Unknown sendable type: " + s.javaClass)

    companion object {
        private const val serialVersionUID = -2232176022034976590L
    }
}