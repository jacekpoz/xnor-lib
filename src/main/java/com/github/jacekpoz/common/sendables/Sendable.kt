package com.github.jacekpoz.common.sendables

import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * Marker interface implemented by classes that can be sent between the server and client as JSON.
 *
 * @author  jacekpoz
 * @since   0.5.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
interface Sendable