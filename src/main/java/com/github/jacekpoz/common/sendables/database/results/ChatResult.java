package com.github.jacekpoz.common.sendables.database.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.Chat;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.ChatQuery;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class ChatResult implements Result<Chat> {

    private final ChatQuery query;
    @JsonProperty("chats")
    private final List<Chat> chats;
    @JsonProperty("success")
    private boolean success;

    @JsonCreator
    public ChatResult(
            @JsonProperty("query") ChatQuery cq
    ) {
        query = cq;
        chats = new ArrayList<>();
    }

    @JsonGetter("chats")
    @Override
    public List<Chat> get() {
        return chats;
    }

    @Override
    public Chat get(int index) {
        return chats.get(index);
    }

    @Override
    public void add(Chat chat) {
        chats.add(chat);
    }

    @Override
    public void add(List<Chat> chats) {
        this.chats.addAll(chats);
    }

    @Override
    public Query<Chat> getQuery() {
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
