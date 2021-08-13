package com.github.jacekpoz.common.sendables.database.queries.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ModifyChatQuery extends ChatQuery {

    @Getter
    private final String columnToModify;
    @Getter
    private final String newValue;

    @JsonCreator
    public ModifyChatQuery(
            @JsonProperty("chatID") long chatID,
            @JsonProperty("columnToModify") String columnToModify,
            @JsonProperty("newValue") String newValue,
            @JsonProperty("callerID") long callerID
    ) {
        super(chatID, callerID);
        this.columnToModify = columnToModify;
        this.newValue = newValue;
    }

}
