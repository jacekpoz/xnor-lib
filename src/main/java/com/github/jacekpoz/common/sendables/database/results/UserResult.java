package com.github.jacekpoz.common.sendables.database.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jacekpoz.common.sendables.User;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.Query;
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class UserResult implements Result<User> {

    private final UserQuery query;
    @JsonProperty("users")
    private final List<User> users;
    @JsonProperty("success")
    private boolean success;

    @JsonCreator
    public UserResult(
            @JsonProperty("query") UserQuery uq
    ) {
        query = uq;
        users = new ArrayList<>();
    }

    @JsonGetter("users")
    @Override
    public List<User> get() {
        return users;
    }

    @Override
    public User get(int index) {
        return users.get(index);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void add(List<User> users) {
        this.users.addAll(users);
    }

    @Override
    public Query<User> getQuery() {
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
