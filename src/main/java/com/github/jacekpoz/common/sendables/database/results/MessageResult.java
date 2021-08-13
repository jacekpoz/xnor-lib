package com.github.jacekpoz.common.sendables.database.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.Message;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.MessageQuery;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class MessageResult implements Result<Message> {

    private final MessageQuery query;
    @JsonProperty("messages")
    private final List<Message> messages;
    @JsonProperty("success")
    private boolean success;

    @JsonCreator
    public MessageResult(
            @JsonProperty("query") MessageQuery mq
    ) {
        query = mq;
        messages = new ArrayList<>();
    }

    @JsonGetter("messages")
    @Override
    public List<Message> get() {
        return messages;
    }

    @Override
    public Message get(int index) {
        return messages.get(index);
    }

    @Override
    public void add(Message message) {
        messages.add(message);
    }

    @Override
    public void add(List<Message> messages) {
        this.messages.addAll(messages);
    }

    @Override
    public Query<Message> getQuery() {
        return query;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean success() {
        return success;
    }

}
