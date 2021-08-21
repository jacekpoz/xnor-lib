package com.github.jacekpoz.common.sendables.database.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.EnumResults;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.SQLException;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RegisterResult extends UserResult {
    @Getter
    @Setter
    private EnumResults.Register result;

    @Getter
    @Setter
    private SQLException ex;

    @JsonCreator
    public RegisterResult(
            @JsonProperty("query") UserQuery uq
    ) {
        super(uq);
    }
}
