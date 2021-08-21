package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RegisterQuery extends UserQuery {

    @Getter
    private final String username;
    @Getter
    private final String hash;

    @JsonCreator
    public RegisterQuery(
            @JsonProperty("username") String username,
            @JsonProperty("hash") String hash,
            @JsonProperty("callerID") long callerID
    ) {
        super(-1, callerID);
        this.username = username;
        this.hash = hash;
    }

    @Override
    public long getUserID() {
        return -1;
    }

}
