package com.github.jacekpoz.common.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.jacekpoz.common.sendables.*;
import com.github.jacekpoz.common.sendables.database.queries.*;
import com.github.jacekpoz.common.sendables.database.results.*;

public class JsonObjectMapper extends ObjectMapper {

    public JsonObjectMapper() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        registerModule(new JavaTimeModule());
        registerSubtypes0(
                Attachment.class,
                Chat.class,
                FriendRequest.class,
                Message.class,
                User.class,
                ChatQuery.class,
                FriendRequestQuery.class,
                MessageQuery.class,
                Query.class,
                UserQuery.class,
                ChatResult.class,
                LoginResult.class,
                MessageResult.class,
                RegisterResult.class,
                Result.class,
                UserResult.class
        );
    }

    private void registerSubtypes0(Class<?>... types) {
        for (Class<?> type : types)
            registerSubtypes(new NamedType(type, type.getName()));
    }

}
