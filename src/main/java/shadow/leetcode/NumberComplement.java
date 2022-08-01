package shadow.leetcode;

public class NumberComplement {

    public int findComplement(int num) {
        int complement = 0;
        int numCopy = num;
        int gradeOf2 = 1;
        while (numCopy > 0) {
            complement += gradeOf2 * (1 - (numCopy & 1));
            numCopy = numCopy >> 1;

            gradeOf2 *= 2;
        }
        return complement;
    }
}
