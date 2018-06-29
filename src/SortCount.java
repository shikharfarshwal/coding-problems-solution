import java.util.*;

/**
 * Created by Shikhar on 20-06-2018.
 */
public class SortCount {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 6, 3, 5, 3, 4, 1, 10, 3, 5, 8, 7, 6, 9, 2, 5, 5, 3, 3, 4};
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int[] result = new int[map.size()];
        int index = 0;
        while (!map.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int curNumberWithMinOccur = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < curMin) {
                    curMin = entry.getValue();
                    curNumberWithMinOccur = entry.getKey();
                }
            }
            result[index] = curNumberWithMinOccur;
            index++;
            map.remove(curNumberWithMinOccur);

        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}