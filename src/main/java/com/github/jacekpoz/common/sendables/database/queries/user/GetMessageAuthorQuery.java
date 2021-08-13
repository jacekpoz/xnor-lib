package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetMessageAuthorQuery extends GetUserQuery {

    @Getter
    private final long messageID;
    @Getter
    private final long chatID;

    @JsonCreator
    public GetMessageAuthorQuery(
            @JsonProperty("messageID") long messageID,
            @JsonProperty("chatID") long chatID,
            @JsonProperty("authorID") long authorID,
            @JsonProperty("callerID") long callerID
    ) {
        super(authorID, callerID);
        this.messageID = messageID;
        this.chatID = chatID;
    }

}
