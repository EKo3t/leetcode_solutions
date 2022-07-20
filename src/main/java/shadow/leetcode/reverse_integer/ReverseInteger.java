package shadow.leetcode.reverse_integer;

class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        int positiveX = x < 0 ? x * -1 : x;

        // should be 0 if out of range [-2^31, 2^31-1]
        int reverse = 0;

        while (positiveX > 0) {
            int digitToAdd = positiveX % 10;
            if (reverse != 0) {
                // Integer.MIN_VALUE / -1 gives Integer.MIN_VALUE so reverse must be > 1
                if (isNegative && reverse > 1 && ((Integer.MIN_VALUE + digitToAdd) / -reverse < 10) ) {
                    return 0;
                }
                if (!isNegative && ((Integer.MAX_VALUE - digitToAdd) / reverse < 10) ) {
                    return 0;
                }
            }
            reverse = reverse * 10 + digitToAdd;
            positiveX /= 10;
        }
        return isNegative ? -reverse : reverse;
    }
}
