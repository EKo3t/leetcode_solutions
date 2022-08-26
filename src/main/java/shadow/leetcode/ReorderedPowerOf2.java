package shadow.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ReorderedPowerOf2 {

    private static final Set<DigitsCountInNumber> DIGITS_COUNT_IN_NUMBERS = new HashSet<>();

    static {
        int currentPowerOf2 = 1;
        while (true) {
            DIGITS_COUNT_IN_NUMBERS.add(calculateDigitsData(currentPowerOf2));

            if (Integer.MAX_VALUE / currentPowerOf2 < 2) {
                break;
            }
            currentPowerOf2 <<= 1;
        }
    }

    public boolean reorderedPowerOf2(int n) {
        DigitsCountInNumber digitsCountInNumber = calculateDigitsData(n);
        return DIGITS_COUNT_IN_NUMBERS.contains(digitsCountInNumber);
    }

    private static DigitsCountInNumber calculateDigitsData(int number) {
        Byte[] digitsCount = new Byte[10];
        while (number > 0) {
            byte currentDigit = (byte) (number % 10);
            if (digitsCount[currentDigit] == null) digitsCount[currentDigit] = 0;
            digitsCount[currentDigit]++;
            number /= 10;
        }
        return new DigitsCountInNumber(
            digitsCount[0], digitsCount[1], digitsCount[2], digitsCount[3], digitsCount[4],
            digitsCount[5], digitsCount[6], digitsCount[7], digitsCount[8], digitsCount[9]
        );
    }

    private static final class DigitsCountInNumber {
        private final Byte numberOf0;
        private final Byte numberOf1;
        private final Byte numberOf2;
        private final Byte numberOf3;
        private final Byte numberOf4;
        private final Byte numberOf5;
        private final Byte numberOf6;
        private final Byte numberOf7;
        private final Byte numberOf8;
        private final Byte numberOf9;

        public DigitsCountInNumber(Byte numberOf0, Byte numberOf1, Byte numberOf2, Byte numberOf3, Byte numberOf4, Byte numberOf5, Byte numberOf6, Byte numberOf7, Byte numberOf8, Byte numberOf9) {
            this.numberOf0 = numberOf0;
            this.numberOf1 = numberOf1;
            this.numberOf2 = numberOf2;
            this.numberOf3 = numberOf3;
            this.numberOf4 = numberOf4;
            this.numberOf5 = numberOf5;
            this.numberOf6 = numberOf6;
            this.numberOf7 = numberOf7;
            this.numberOf8 = numberOf8;
            this.numberOf9 = numberOf9;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DigitsCountInNumber that = (DigitsCountInNumber) o;
            return Objects.equals(numberOf0, that.numberOf0) && Objects.equals(numberOf1, that.numberOf1) && Objects.equals(numberOf2, that.numberOf2) && Objects.equals(numberOf3, that.numberOf3) && Objects.equals(numberOf4, that.numberOf4) && Objects.equals(numberOf5, that.numberOf5) && Objects.equals(numberOf6, that.numberOf6) && Objects.equals(numberOf7, that.numberOf7) && Objects.equals(numberOf8, that.numberOf8) && Objects.equals(numberOf9, that.numberOf9);
        }

        @Override
        public int hashCode() {
            return Objects.hash(numberOf0, numberOf1, numberOf2, numberOf3, numberOf4, numberOf5, numberOf6, numberOf7, numberOf8, numberOf9);
        }
    }
}
