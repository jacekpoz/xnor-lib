package com.github.jacekpoz.common.sendables.database.results;

import com.github.jacekpoz.common.sendables.Sendable;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query;

import java.util.List;

/**
 * Results are returned by the server to the client in response to queries.
 *
 * @param   <T> type of object to be stored in the result
 * @author  jacekpoz
 * @since   0.2.0
 * @version 0.0.2
 */
public interface Result<T extends Sendable> extends Sendable {

    /**
     * List containing the objects returned with the result.
     *
     * @return the result
     * @author jacekpoz
     * @since  0.2.0
     */
    List<T> get();

    /**
     * I just didn't want to do {@code result.get().get(0)} each time.
     *
     * @param  index the index
     * @return one element from the result
     * @author jacekpoz
     * @since  0.2.0
     */
    T get(int index);

    /**
     * Adds the element to the result.
     *
     * @param  t element to be added to the result
     * @author jacekpoz
     * @since  0.2.0
     */
    void add(T t);

    /**
     * Adds the elements to the result.
     *
     * @param  ts list of elements to be added to the result (multiple of t - pronounced tees)
     * @author jacekpoz
     * @since  0.2.0
     */
    void add(List<T> ts);

    /**
     * Query's type is needed to properly handle the result.
     *
     * @return the query that called this result
     * @author jacekpoz
     * @since  0.2.0
     */
    Query<T> getQuery();

    /**
     * Setter for success field.
     *
     * @param  success whether the result succeeded
     * @author jacekpoz
     * @since  0.2.0
     */
    void setSuccess(boolean success);

    /**
     * Getter for success field.
     *
     * @return whether the result succeeded
     * @author jacekpoz
     * @since  0.2.0
     */
    boolean success();

}
