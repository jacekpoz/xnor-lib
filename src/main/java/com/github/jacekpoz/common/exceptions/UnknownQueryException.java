package com.github.jacekpoz.common.exceptions;

import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query;

public class UnknownQueryException extends UnknownSendableException {

    private static final long serialVersionUID = 6003384360314407592L;

    public UnknownQueryException() {
        super();
    }

    public UnknownQueryException(Query<?> q) {
        super(q);
    }
}
