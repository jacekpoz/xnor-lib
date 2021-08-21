package com.github.jacekpoz.common.sendables.database.queries.basequeries;

import com.github.jacekpoz.common.sendables.Sendable;

/**
 * Queries are used to ask the server to do things in the database and return some values.
 *
 * @param   <T> type of object the query is asking for
 * @author  jacekpoz
 * @version 0.0.1
 * @since   0.2.0
 */
public interface Query<T> extends Sendable {

    /**
     * Used to identify which screen sent this query.
     *
     * @return the ID of the screen that sent this query
     * @author jacekpoz
     * @since  0.2.0
     */
    long getCallerID();

}
