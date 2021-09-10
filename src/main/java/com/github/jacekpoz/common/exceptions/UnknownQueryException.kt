package com.github.jacekpoz.common.exceptions

import com.github.jacekpoz.common.sendables.database.queries.Query

class UnknownQueryException : UnknownSendableException {
    constructor() : super()
    constructor(q: Query<*>) : super(q)

    companion object {
        private const val serialVersionUID = 6003384360314407592L
    }
}