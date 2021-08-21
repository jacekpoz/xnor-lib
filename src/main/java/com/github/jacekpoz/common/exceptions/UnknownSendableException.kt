package com.github.jacekpoz.common.exceptions;

import com.github.jacekpoz.common.sendables.Sendable;

public class UnknownSendableException extends RuntimeException {

    private static final long serialVersionUID = -2232176022034976590L;

    public UnknownSendableException() {
        super();
    }

    public UnknownSendableException(Sendable s) {
        super("Unknown sendable type: " + s.getClass());
    }
}
