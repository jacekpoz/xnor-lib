package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LoginQuery extends GetUserQuery {

    @Getter
    private final byte[] password;

    @JsonCreator
    public LoginQuery(
            @JsonProperty("username") String username,
            @JsonProperty("password") byte[] password,
            @JsonProperty("callerID") long callerID
    ) {
        super(username, callerID);
        this.password = password;
    }

}
