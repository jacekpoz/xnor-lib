package com.github.jacekpoz.common;

public final class Constants {

    private Constants() {
        throw new AssertionError("nah");
    }

    // TODO change this later when I figure out how to load part of the chat and shit
    public static final int DEFAULT_MESSAGES_LIMIT = 999999;

    public static final String DB_NAME = "chatdatabase";
    public static final String USERS_TABLE = "users";
    public static final String FRIENDS_TABLE = "friends";
    public static final String CHATS_TABLE = "chats";
    public static final String MESSAGES_TABLE = "messages";
    public static final String CHATS_MESSAGE_COUNTERS_TABLE = "chats_message_counters";
    public static final String USERS_IN_CHATS_TABLE = "users_in_chats";
    public static final String FRIEND_REQUESTS_TABLE = "friend_requests";
}
