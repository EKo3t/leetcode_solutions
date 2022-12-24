package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class InvalidTransactionsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String[] given, String[] expected) {
        List<String> answer = new InvalidTransactions().invalidTransactions(given);
        Set<String> expectedSet = new HashSet<>(Arrays.asList(expected));
        for (String s : answer) {
            boolean isRemoved = expectedSet.remove(s);
            if (!isRemoved)
                Assertions.fail(s + " haven't found in expected set");

        }
        if (!expectedSet.isEmpty())
            Assertions.fail("Not all invalid transactions found. " + expectedSet);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}, new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}),
            Arguments.of(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"}, new String[]{"bob,50,1200,mtv"}),
            Arguments.of(new String[]{"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"}, new String[]{"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"}),
            Arguments.of(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"}, new String[]{"alice,50,1200,mtv"})
        );
    }
}
