package com.github.jacekpoz.common.sendables.database.queries.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InsertMessageQuery extends MessageQuery {

    @Getter
    private final long authorID;
    @Getter
    private final String content;

    @JsonCreator
    public InsertMessageQuery(
            @JsonProperty("messageID") long messageID,
            @JsonProperty("chatID") long chatID,
            @JsonProperty("authorID") long authorID,
            @JsonProperty("content") String content,
            @JsonProperty("callerID") long callerID
    ) {
        super(messageID, chatID, callerID);
        this.authorID = authorID;
        this.content = content;
    }

}
