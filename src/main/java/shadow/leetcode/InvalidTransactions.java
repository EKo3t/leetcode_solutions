package shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @see <a href="https://leetcode.com/problems/invalid-transactions/">Task description</a>
 * Difficulty: medium
 */
public class InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> transactions_ = convertToPojo(transactions);
        List<String> invalidTransactions = new ArrayList<>();
        BiPredicate<Transaction, Transaction> isSameSender = (t1, t2) -> t1.sender.equals(t2.sender);
        BiPredicate<Transaction, Transaction> isWithin60Minutes = (t1, t2) -> Math.abs(t1.time - t2.time) <= 60;
        BiPredicate<Transaction, Transaction> isDifferentCity = (t1, t2) -> !t1.city.equals(t2.city);
        Predicate<Integer> isInRange = integer -> integer >= 0 && integer < transactions_.size();

        for (int i = 0; i < transactions_.size(); i++) {
            Transaction transaction = transactions_.get(i);
            if (transaction.amount > 1000) {
                invalidTransactions.add(transaction.toString());
                continue;
            }

            boolean isInvalid = false;
            int currentIndex = i - 1;
            while (isInRange.test(currentIndex)) {
                Transaction toCompare = transactions_.get(currentIndex);
                if (!isSameSender.test(toCompare, transaction) || !isWithin60Minutes.test(toCompare, transaction))
                    break;
                if (isDifferentCity.test(toCompare, transaction)) {
                    invalidTransactions.add(transaction.toString());
                    isInvalid = true;
                    break;
                }
                currentIndex--;
            }
            if (!isInvalid) {
                currentIndex = i + 1;
                while (isInRange.test(currentIndex)) {
                    Transaction toCompare = transactions_.get(currentIndex);
                    if (!isSameSender.test(toCompare, transaction) || !isWithin60Minutes.test(toCompare, transaction))
                        break;
                    if (isDifferentCity.test(toCompare, transaction)) {
                        invalidTransactions.add(transaction.toString());
                        break;
                    }
                    currentIndex++;
                }
            }
        }
        return invalidTransactions;
    }

    private List<Transaction> convertToPojo(String[] transactions) {
        return Arrays
            .stream(transactions)
            .map(transaction -> {
                String[] data = transaction.split(",");
                return new Transaction(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
            })
            .sorted(Comparator.comparing((Transaction o) -> o.sender).thenComparingInt(o -> o.time))
            .toList();
    }

    private static class Transaction {

        private final String sender;
        private final int time;
        private final int amount;
        private final String city;

        public Transaction(String sender, int time, int amount, String city) {
            this.sender = sender;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return sender + ',' + time + ',' + amount + ',' + city;
        }
    }
}
