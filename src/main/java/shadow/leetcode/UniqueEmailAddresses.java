package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/unique-email-addresses">Task description</a>
 * Difficulty: easy
 */
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        return (int) Arrays.stream(emails)
            .map(email -> {
                String[] nameAndDomain = email.split("@");
                return nameAndDomain[0].split("\\+")[0].replace(".", "") + "@" + nameAndDomain[1];
            })
            .distinct()
            .count();
    }
}
