package com.github.jacekpoz.common.sendables.database.queries.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUsersChatsQuery extends GetChatQuery {

    private final long userID;

    @JsonCreator
    public GetUsersChatsQuery(
            @JsonProperty("userID") long userID,
            @JsonProperty("callerID") long callerID
    ) {
        super(-1, callerID);
        this.userID = userID;
    }

    public long getUserID() {
        return userID;
    }

}
