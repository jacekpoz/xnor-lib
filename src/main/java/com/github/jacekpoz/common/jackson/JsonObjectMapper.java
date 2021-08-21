package com.github.jacekpoz.common.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.jacekpoz.common.sendables.Chat;
import com.github.jacekpoz.common.sendables.Message;
import com.github.jacekpoz.common.sendables.User;
import com.github.jacekpoz.common.sendables.database.queries.chat.*;
import com.github.jacekpoz.common.sendables.database.queries.message.*;
import com.github.jacekpoz.common.sendables.database.queries.user.*;
import com.github.jacekpoz.common.sendables.database.results.*;

public class JsonObjectMapper extends ObjectMapper {

    public JsonObjectMapper() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        registerModule(new JavaTimeModule());
        registerSubtypes0(
                Chat.class,
                Message.class,
                User.class,
                DeleteChatQuery.class,
                GetChatQuery.class,
                GetUsersChatsQuery.class,
                InsertChatQuery.class,
                ModifyChatQuery.class,
                DeleteMessageQuery.class,
                GetMessageQuery.class,
                GetMessagesInChatQuery.class,
                InsertMessageQuery.class,
                ModifyMessageQuery.class,
                AcceptFriendRequestQuery.class,
                DeleteUserQuery.class,
                DenyFriendRequestQuery.class,
                GetAllUsersQuery.class,
                GetFriendRequestsQuery.class,
                GetFriendsQuery.class,
                GetMessageAuthorQuery.class,
                GetUserQuery.class,
                GetUsersInChatQuery.class,
                LoginQuery.class,
                ModifyUserQuery.class,
                RegisterQuery.class,
                RemoveFriendQuery.class,
                SendFriendRequestQuery.class,
                ChatResult.class,
                LoginResult.class,
                MessageResult.class,
                RegisterResult.class,
                UserResult.class
        );
    }

    private void registerSubtypes0(Class<?>... types) {
        for (Class<?> type : types)
            registerSubtypes(new NamedType(type, type.getName()));
    }

}
