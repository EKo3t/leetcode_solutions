package shadow.leetcode;

public class GuessNumberHigherOrLower {

    private final int number;

    public GuessNumberHigherOrLower(int number) {
        this.number = number;
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int middle = l / 2 + r / 2 + (l % 2 == 1 && r % 2 == 1 ? 1 : 0);
            int guessResult = guess(middle);
            if (guessResult == -1)
                r = middle - 1;
            if (guessResult == 1)
                l = middle + 1;
            if (guessResult == 0)
                return middle;
        }
        return l;
    }

    private int guess(int num) {
        return Integer.compare(number, num);
    }
}
