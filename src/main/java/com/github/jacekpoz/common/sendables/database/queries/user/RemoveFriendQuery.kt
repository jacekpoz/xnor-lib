package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RemoveFriendQuery extends UserQuery {

    @Getter
    private final long friendID;

    @JsonCreator
    public RemoveFriendQuery(
            @JsonProperty("userID") long userID,
            @JsonProperty("friendID") long friendID,
            @JsonProperty("callerID") long callerID
    ) {
        super(userID, callerID);
        this.friendID = friendID;
    }

}
