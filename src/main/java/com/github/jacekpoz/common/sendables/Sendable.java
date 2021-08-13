package com.github.jacekpoz.common.sendables;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Marker interface implemented by classes that can be sent between the server and client as JSON.
 *
 * @author  jacekpoz
 * @version 0.0.1
 * @since   0.2.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
public interface Sendable {}
