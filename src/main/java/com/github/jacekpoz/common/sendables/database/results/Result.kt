package com.github.jacekpoz.common.sendables.database.results

import com.github.jacekpoz.common.sendables.Sendable
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query

/**
 * Results are returned by the server to the client in response to queries.
 *
 * @author  jacekpoz
 * @since   0.5.0
 * @version 0.0.3
 */
interface Result<T : Sendable?> : Sendable {

    /**
     * Query's type is needed to properly handle the result.
     *
     * @author jacekpoz
     * @since  0.5.0
     */
    val query: Query<T>?

    /**
     * Did the query succeed or fail.
     *
     * @author jacekpoz
     * @since  0.5.0
     */
    var success: Boolean

    /**
     * List containing the objects returned with the result.
     *
     * @return the result
     * @author jacekpoz
     * @since  0.5.0
     */
    fun get(): List<T>?

    /**
     * I just didn't want to do `result.get().get(0)` each time.
     *
     * @param  index the index
     * @return one element from the result
     * @author jacekpoz
     * @since  0.5.0
     */
    fun get(index: Int): T

    /**
     * Adds the item to the result.
     *
     * @param  item yep
     * @author jacekpoz
     * @since  0.5.0
     */
    fun add(item: T)

    /**
     * Adds the items to the result.
     *
     * @param  items yeah
     * @author jacekpoz
     * @since  0.5.0
     */
    fun add(items: List<T>)
}