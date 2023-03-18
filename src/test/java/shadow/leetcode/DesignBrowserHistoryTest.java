package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DesignBrowserHistoryTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] commandNames, Object[] values, String[] expected) {
        Assertions.assertArrayEquals(expected, execute(commandNames, values));
    }

    private static String[] execute(String[] commandNames, Object[] values) {
        List<String> result = new ArrayList<>();
        DesignBrowserHistory browserHistory = null;
        for (int i = 0; i < commandNames.length; i++) {
            String command = commandNames[i];
            Object value = values[i];
            switch (command) {
                case "BrowserHistory" -> browserHistory = new DesignBrowserHistory((String) value);
                case "visit" -> {
                    assert browserHistory != null;
                    browserHistory.visit((String) value);
                }
                case "back" -> {
                    assert browserHistory != null;
                    result.add(browserHistory.back((int) value));
                }
                case "forward" -> {
                    assert browserHistory != null;
                    result.add(browserHistory.forward((int) value));
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
//            Arguments.of(
//                new String[]{"BrowserHistory", "visit", "visit", "visit", "back", "back", "forward", "visit", "forward", "back", "back"},
//                new Object[]{"leetcode.com", "google.com", "facebook.com", "youtube.com", 1, 1, 1, "linkedin.com", 2, 2, 7},
//                new String[]{"facebook.com", "google.com", "facebook.com", "linkedin.com", "google.com", "leetcode.com"}
//            ),
            Arguments.of(
                new String[]{"BrowserHistory", "visit", "visit", "back", "visit", "forward", "visit", "visit", "forward", "visit", "back", "visit", "visit", "forward"},
                new Object[]{"esgriv.com", "cgrt.com", "tip.com", 9, "kttzxgh.com", 7, "crqje.com", "iybch.com", 5, "uun.com", 10, "hci.com", "whula.com", 10},
                new String[]{"qqq"}
            )
        );
    }
}
