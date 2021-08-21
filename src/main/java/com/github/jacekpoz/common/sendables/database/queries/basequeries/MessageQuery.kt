package com.github.jacekpoz.common.sendables.database.queries.basequeries;

import com.github.jacekpoz.common.sendables.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Base query for doing stuff with messages containing fields used in most message queries.
 *
 * @author  jacekpoz
 * @version 0.0.2
 * @since   0.3.0
 */
@ToString
@EqualsAndHashCode
public abstract class MessageQuery implements Query<Message> {

    @Getter
    private final long messageID;
    @Getter
    private final long chatID;
    private final long callerID;

    public MessageQuery(long messageID, long chatID, long callerID) {
        this.messageID = messageID;
        this.chatID = chatID;
        this.callerID = callerID;
    }

    @Override
    public long getCallerID() {
        return callerID;
    }

}
