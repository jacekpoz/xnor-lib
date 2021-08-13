package com.github.jacekpoz.common.sendables;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Do I really have to describe this class?
 *
 * @author  jacekpoz
 * @version 0.0.4
 * @since   0.1.0
 */
@ToString
@EqualsAndHashCode
public class Message implements Sendable {

    @Getter
    private final long messageID;
    @Getter
    private final long chatID;
    @Getter
    private final long authorID;
    @Getter @Setter
    private String content;
    @EqualsAndHashCode.Exclude
    @Getter
    private final LocalDateTime dateSent;

    @JsonCreator
    public Message(
            @JsonProperty("messageID") long mID,
            @JsonProperty("chatID") long cID,
            @JsonProperty("authorID") long aID,
            @JsonProperty("content") String text,
            @JsonProperty("dateSent") LocalDateTime send
    ) {
        messageID = mID;
        chatID = cID;
        authorID = aID;
        content = text;
        dateSent = send;
    }

    public Message(String text) {
        this(-1, -1, -1, text, LocalDateTime.MIN);
    }

}
