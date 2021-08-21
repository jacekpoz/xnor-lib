package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetFriendsQuery extends UserQuery {

    @JsonCreator
    public GetFriendsQuery(
            @JsonProperty("userID") long userID,
            @JsonProperty("callerID") long callerID
    ) {
        super(userID, callerID);
    }

}
