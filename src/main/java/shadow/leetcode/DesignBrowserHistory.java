package shadow.leetcode;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/design-browser-history">Task description</a>
 * Difficulty: medium
 */
public class DesignBrowserHistory {

    private final ArrayList<String> urls;
    private int actualSize;
    private int currentIndex;

    public DesignBrowserHistory(String homepage) {
        urls = new ArrayList<>();
        actualSize = 1;
        urls.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        if (currentIndex == actualSize - 1) {
            if (actualSize == urls.size())
                urls.add(url);
            else
                urls.set(actualSize, url);
            actualSize++;
        } else {
            actualSize = currentIndex + 2;
            urls.set(currentIndex + 1, url);
        }
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex = Integer.max(0, currentIndex - steps);
        return urls.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Integer.min(actualSize - 1, currentIndex + steps);
        return urls.get(currentIndex);
    }
}
