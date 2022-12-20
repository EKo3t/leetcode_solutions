package shadow.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/keys-and-rooms">Task description</a>
 * Difficulty: medium
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] unlockedRooms = new boolean[rooms.size()];
        Queue<Integer> roomsToVisit = new LinkedList<>();
        int visitedRoomsCount = 0;
        visitedRoomsCount = addUnlockedRoom(0, unlockedRooms, roomsToVisit, visitedRoomsCount);

        while (!roomsToVisit.isEmpty()) {
            Integer roomToVisit = roomsToVisit.poll();
            List<Integer> keys = rooms.get(roomToVisit);
            for (Integer key : keys) {
                if (!unlockedRooms[key])
                    visitedRoomsCount = addUnlockedRoom(key, unlockedRooms, roomsToVisit, visitedRoomsCount);
            }
        }
        return visitedRoomsCount == rooms.size();
    }

    private Integer addUnlockedRoom(int index, boolean[] unlockedRooms, Queue<Integer> roomsToVisit, Integer visitedRoomsCount) {
        unlockedRooms[index] = true;
        roomsToVisit.add(index);
        return visitedRoomsCount + 1;
    }
}
