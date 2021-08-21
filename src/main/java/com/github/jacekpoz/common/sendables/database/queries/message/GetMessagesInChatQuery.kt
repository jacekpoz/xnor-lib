package com.github.jacekpoz.common.sendables.database.queries.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.Constants;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetMessagesInChatQuery extends MessageQuery {

    @Getter
    private final long offset;
    @Getter
    private final long limit;

    @JsonCreator
    public GetMessagesInChatQuery(
            @JsonProperty("chatID") long chatID,
            @JsonProperty("offset") long offset,
            @JsonProperty("limit") long limit,
            @JsonProperty("callerID") long callerID
    ) {
        super(-1, chatID, callerID);
        this.offset = offset;
        this.limit = limit;
    }

    public GetMessagesInChatQuery(long chatID, long limit, long callerID) {
        this(chatID, 0, limit, callerID);
    }

    public GetMessagesInChatQuery(long chatID, long callerID) {
        this(chatID, 0, Constants.DEFAULT_MESSAGES_LIMIT, callerID);
    }

}
