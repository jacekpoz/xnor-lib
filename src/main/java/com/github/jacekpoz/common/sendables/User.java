package com.github.jacekpoz.common.sendables;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Yup.
 *
 * @author  jacekpoz
 * @version 0.0.4
 * @since   0.1.0
 */
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Sendable {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Getter
    private final long id;
    @ToString.Include
    @Getter
    @Setter
    private String nickname;
    @Getter
    @Setter
    private String hashedPassword;
    @Getter
    private final List<Long> friendsIDs;
    @Getter
    private final LocalDateTime dateJoined;

    @JsonCreator
    public User(
            @JsonProperty("userID") long userID,
            @JsonProperty("username") String userNickname,
            @JsonProperty("hashedPassword") String userHashedPassword,
            @JsonProperty("dateJoined") LocalDateTime date
    ) {
        id = userID;
        nickname = userNickname;
        hashedPassword = userHashedPassword;
        friendsIDs = new ArrayList<>();
        dateJoined = date;
    }

    public void addFriend(User u) {
        if (!friendsIDs.contains(u.id)) friendsIDs.add(u.id);
    }

    public void addFriend(long id) {
        if (!friendsIDs.contains(id)) friendsIDs.add(id);
    }

    public void removeFriend(User u) {
        friendsIDs.remove(u.id);
    }

    public void removeFriend(long id) {
        friendsIDs.remove(id);
    }

}
