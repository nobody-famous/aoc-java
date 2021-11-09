package aoc.y2019.day7;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    static void swap(int[] arr, int ndx1, int ndx2) {
        var tmp = arr[ndx1];

        arr[ndx1] = arr[ndx2];
        arr[ndx2] = tmp;
    }

    static void generate(List<int[]> perms, int k, int[] arr) {
        if (k == 1) {
            perms.add(arr.clone());
            return;
        }

        generate(perms, k - 1, arr);

        for (var i = 0; i < k - 1; i += 1) {
            if (k % 2 == 0) {
                swap(arr, i, k - 1);
            } else {
                swap(arr, 0, k - 1);
            }

            generate(perms, k - 1, arr);
        }
    }

    static List<int[]> findPerms(int[] arr) {
        var perms = new ArrayList<int[]>();

        generate(perms, arr.length, arr);

        return perms;
    }
}
