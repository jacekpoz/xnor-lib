package com.github.jacekpoz.common;

import com.github.jacekpoz.common.sendables.User;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A bunch of useful static methods.
 *
 * @author  jacekpoz
 * @version 0.0.5
 * @since   0.0.1
 */
public final class Util {

    /**
     * Nope.
     *
     * @author  jacekpoz
     * @since 0.0.1
     */
    private Util() {
        throw new AssertionError("nope");
    }

    /**
     * Turns a {@code LocalDateTime} into a {@code String} mainly for message tooltips.
     *
     * @param  date date to be turned into {@code String}
     * @return {@code String} made from the date
     * @author jacekpoz
     * @since  0.0.2
     */
    public static String localDateTimeToString(LocalDateTime date) {
        return String.format("<html> %02d:%02d:%02d<br>%02d-%02d-%04d</html>",
                date.getHour(), date.getMinute(), date.getSecond(),
                date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    /**
     * Takes the users' usernames and turns them into a {@code String} mainly used for chat tooltips.
     *
     * @param  users username sources
     * @return condensed usernames
     * @author jacekpoz
     * @since  0.0.2
     */
    public static String userListToString(List<User> users) {
        List<String> nicknames = users.stream()
                .map(User::getNickname)
                .collect(Collectors.toList());
        return usernamesToString(nicknames);
    }

    /**
     * Turns a list of usernames into a tooltip for a chat.
     * For a chat with 4 or fewer members it will look like this:
     * <pre>
     *     kupsko
     *     gówno
     *     dupa
     *     siki
     * </pre>
     * and for a chat with 5 or more members it will look like this:
     * <pre>
     *     dupka
     *     gówno
     *     siki
     *     kupa
     *     ...+n
     * </pre>
     * with n being the remaining amount of users in that chat.
     *
     * @param  usernames what do you expect this to be
     * @return if you don't know what this is you should go see a doctor
     * @author jacekpoz
     * @since  0.0.3
     */
    public static String usernamesToString(List<String> usernames) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        int i;
        for (i = 0; i < usernames.size(); i++) {
            if (i < 5) sb.append(usernames.get(i));
            else break;
            if (i < 4) sb.append("<br>");
        }
        if (i < usernames.size() - 1) sb.append("... +").append(usernames.size() - i);
        sb.append("</html>");
        return sb.toString();
    }

    /**
     * Compares {@code inputUsername} with each username from {@code users} using the Damerau-Levenshtein distance algorithm.
     * I don't know shit about this algorithm or actually most algorithms so I just went off of trial and error and found that > 0.5 is fine.
     *
     * @param  inputUsername username given by the user
     * @param  users         users that will be filtered out by their username
     * @return filtered list of users with similar usernames to {@code inputUsername}
     * @author jacekpoz
     * @since  0.0.3
     * @see    <a href="https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance">Damerau-Levenshtein distance</a>
     */
    public static List<User> compareUsernames(String inputUsername, List<User> users) {
        StringMetric metric = StringMetrics.damerauLevenshtein();

        List<User> similarUsernames = new ArrayList<>();
        for (User ui : users) {
            float result = metric.compare(inputUsername, ui.getNickname());
            if (result > 0.5 || ui.getNickname().startsWith(inputUsername))
                similarUsernames.add(ui);
        }

        return similarUsernames;
    }
}
