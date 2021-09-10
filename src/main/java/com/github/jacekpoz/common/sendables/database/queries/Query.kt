package com.github.jacekpoz.common.sendables.database.queries

import com.github.jacekpoz.common.sendables.Sendable

/**
 * Queries are used to ask the server to do things in the database and return some values.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
interface Query<T> : Sendable {

    /**
     * Values of the query.
     *
     * @author jacekpoz
     * @since  0.5.2
     */
    val values: MutableMap<String, Any>

    /**
     * Returns the value or `null` if it's not there.
     *
     * @author jacekpoz
     * @since  0.5.2
     */
    fun <T> getValue(key: String, type: Class<T>): T = type.cast(values[key])

    /**
     * Puts the value if it's allowed in this type of query.
     *
     * @author jacekpoz
     * @since  0.5.2
     */
    fun putValue(key: String, value: Any) {
        if (!queryType.allowedValues.keys.contains(key))
            throw IllegalArgumentException("Value $key not allowed")
        val allowedType = queryType.allowedValues[key]
        val givenType = value::class.java
        if (allowedType != givenType)
            throw IllegalArgumentException("Value $key of type $givenType has to be of type $allowedType")
        values[key] = value
    }

    /**
     * If true it will update the screen that called it.
     *
     * @author jacekpoz
     * @since  0.5.2
     */
    val update: Boolean

    /**
     * Used to identify which screen sent this query.
     *
     * @author jacekpoz
     * @since  0.5.0
     */
    val callerID: Long

    /**
     * Used to determine which data this query requests.
     *
     * @author jacekpoz
     * @since  0.5.2
     */
    val queryType: QueryEnum<T>
}