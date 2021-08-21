package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DenyFriendRequestQuery extends UserQuery {

    @Getter
    private final long friendID;

    @JsonCreator
    public DenyFriendRequestQuery(
            @JsonProperty("senderID") long senderID,
            @JsonProperty("friendID") long friendID,
            @JsonProperty("callerID") long callerID
    ) {
        super(senderID, callerID);
        this.friendID = friendID;
    }

}
