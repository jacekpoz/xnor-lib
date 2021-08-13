package com.github.jacekpoz.common.sendables.database.queries.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ModifyUserQuery extends UserQuery {

    @Getter
    private final String columnToModify;
    @Getter
    private final String newValue;

    @JsonCreator
    public ModifyUserQuery(
            @JsonProperty("userID") long userID,
            @JsonProperty("columnToModify") String columnToModify,
            @JsonProperty("newValue") String newValue,
            @JsonProperty("callerID") long callerID
    ) {
        super(userID, callerID);
        this.columnToModify = columnToModify;
        this.newValue = newValue;
    }

}
