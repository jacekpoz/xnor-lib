package com.github.jacekpoz.common;

public class EnumResults {

    public enum Login {
        LOGGED_IN,
        ACCOUNT_DOESNT_EXIST,
        WRONG_PASSWORD,
        SQL_EXCEPTION,
        DEFAULT
    }

    public enum Register {
        ACCOUNT_CREATED,
        USERNAME_TAKEN,
        SQL_EXCEPTION,
        DEFAULT
    }

    public enum AddFriend {
        ADDED_FRIEND,
        ALREADY_FRIEND,
        SAME_USER,
        SQL_EXCEPTION,
    }

    public enum RemoveFriend {
        REMOVED_FRIEND,
        SAME_USER,
        SQL_EXCEPTION,
    }

    public enum SendFriendRequest {
        SENT_SUCCESSFULLY,
        ALREADY_SENT,
        ALREADY_FRIENDS,
        SAME_USER,
        SQL_EXCEPTION,
    }
}
