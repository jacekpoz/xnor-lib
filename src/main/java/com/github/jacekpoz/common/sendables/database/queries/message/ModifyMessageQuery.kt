package com.github.jacekpoz.common.sendables.database.queries.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ModifyMessageQuery extends MessageQuery {

    @Getter
    private final String columnToModify;
    @Getter
    private final String newValue;

    @JsonCreator
    public ModifyMessageQuery(
            @JsonProperty("messageID") long messageID,
            @JsonProperty("chatID") long chatID,
            @JsonProperty("columnToModify") String columnToModify,
            @JsonProperty("newValue") String newValue,
            @JsonProperty("callerID") long callerID
    ) {
        super(messageID, chatID, callerID);
        this.columnToModify = columnToModify;
        this.newValue = newValue;
    }

}
