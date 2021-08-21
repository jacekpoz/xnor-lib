package com.github.jacekpoz.common.sendables.database.queries.basequeries;

import com.github.jacekpoz.common.sendables.Chat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Base query for doing stuff with chats containing fields used in most chat queries.
 *
 * @author  jacekpoz
 * @version 0.0.2
 * @since   0.3.0
 */
@ToString
@EqualsAndHashCode
public abstract class ChatQuery implements Query<Chat> {

    @Getter
    private final long chatID;
    private final long callerID;

    public ChatQuery(long chatID, long callerID) {
        this.chatID = chatID;
        this.callerID = callerID;
    }

    @Override
    public long getCallerID() {
        return callerID;
    }

}
