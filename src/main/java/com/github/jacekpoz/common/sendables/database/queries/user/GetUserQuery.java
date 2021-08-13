package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserQuery extends UserQuery {

    @Getter
    private final String username;

    @JsonCreator
    private GetUserQuery(
            @JsonProperty("userID") long userID,
            @JsonProperty("username") String username,
            @JsonProperty("callerID") long callerID
    ) {
        super(userID, callerID);
        this.username = username;
    }

    public GetUserQuery(long userID, long callerID) {
        this(userID, null, callerID);
    }

    public GetUserQuery(String username, long callerID) {
        this(-1, username, callerID);
    }

}
