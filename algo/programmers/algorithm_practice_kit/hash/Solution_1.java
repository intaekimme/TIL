package programmers.algorithm_practice_kit.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        if (set.size() >= nums.length / 2)
            return nums.length / 2;
        return set.size();
    }
}
