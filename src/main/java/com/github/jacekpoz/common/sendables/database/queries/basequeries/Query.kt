package com.github.jacekpoz.common.sendables.database.queries.basequeries

import com.github.jacekpoz.common.sendables.Sendable

/**
 * Queries are used to ask the server to do things in the database and return some values.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
interface Query<T> : Sendable {

    /**
     * Used to identify which screen sent this query.
     *
     * @author jacekpoz
     * @since  0.5.0
     */
    val callerID: Long
}