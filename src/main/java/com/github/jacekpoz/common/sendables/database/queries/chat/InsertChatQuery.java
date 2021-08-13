package com.github.jacekpoz.common.sendables.database.queries.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InsertChatQuery extends ChatQuery {

    @Getter
    private final String chatName;
    @Getter
    private final List<Long> memberIDs;

    @JsonCreator
    public InsertChatQuery(
            @JsonProperty("chatName") String chatName,
            @JsonProperty("memberIDs") List<Long> memberIDs,
            @JsonProperty("callerIDs") long callerID
    ) {
        super(-1, callerID);
        this.chatName = chatName;
        this.memberIDs = memberIDs;
    }

}
