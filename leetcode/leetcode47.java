package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode47 {

    public static void main(String[] args) {

        int[] nums = {1,-1,1,2,-1,2,2,-1};
        permuteUnique(nums);
    }

    static List<List<Integer>> arr;
    static int[] temp;
    static boolean[] visited;
    static HashSet<String> hs;

    static public List<List<Integer>> permuteUnique(int[] nums) {

        arr = new ArrayList<>();
        visited = new boolean[nums.length];
        temp = new int[nums.length];
        hs = new HashSet<>();

        Arrays.sort(nums);
        dfs(0, nums);

        return arr;
    }

    private static void dfs(int index, int[] nums) {

        if (index == nums.length) {

            String st = "";
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < temp.length; i++) {
                st = st + temp[i];
                ans.add(temp[i]);
            }
            if (!hs.contains(st)) {
                hs.add(st);
                System.out.println(st);
                arr.add(new ArrayList<>(ans));
                //for (int i = 0; i < ans.size(); i++) {
                //    System.out.print(ans.get(i));
                //}
            }
            //System.out.println();
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[index] = nums[i];
                dfs(index + 1, nums);
                visited[i] = false;
            }
        }
    }
}
/*
package week7;

import java.util.*;

public class leetcode47_1 {

    public static void main(String[] args) {

        int[] nums = {1, -1, 1, 2, -1, 2, 2, -1};
        permuteUnique(nums);
    }

    static Set<List<Integer>> arr;
    static int[] temp;
    static boolean[] visited;
    static HashSet<String> hs;

    static public List<List<Integer>> permuteUnique(int[] nums) {

        arr = new HashSet<List<Integer>>();
        visited = new boolean[nums.length];
        temp = new int[nums.length];
        hs = new HashSet<>();

        Arrays.sort(nums);
        dfs(0, nums);

        List<List<Integer>> targetList = new ArrayList<>(arr);
        return targetList;
    }

    private static void dfs(int index, int[] nums) {

        if (index == nums.length) {


            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < temp.length; i++) {
                ans.add(temp[i]);
            }

            arr.add(ans);

            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[index] = nums[i];
                dfs(index + 1, nums);
                visited[i] = false;
            }
        }
    }
}


*/
