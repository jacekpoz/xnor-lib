package com.github.jacekpoz.common.sendables.database.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.EnumResults;
import com.github.jacekpoz.common.sendables.database.queries.user.LoginQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.SQLException;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LoginResult extends UserResult {

    @JsonProperty("result")
    @Getter
    @Setter
    private EnumResults.Login result;

    @JsonProperty("ex")
    @Getter
    @Setter
    private SQLException ex;

    @JsonCreator
    public LoginResult(
            @JsonProperty("query") LoginQuery lq
    ) {
        super(lq);
    }

}
