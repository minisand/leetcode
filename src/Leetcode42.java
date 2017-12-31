import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by weiyao on 11/5/17.
 */
public class Leetcode42 {
    //this implementation handles case in which there are duplicated elements
    public static int trapRain(int[] nums) {
        int length = nums.length;
        if (length <=1)
            return 0;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int[] max = new int[length];

        leftMax[0] = 0;
        rightMax[length-1] = 0;
        for (int i=1; i<length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }
        for (int i=length - 2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }
        for (int i=0; i<length; i++) {
            max[i] = Math.min(leftMax[i], rightMax[i]);
        }
        int water = 0;
        for (int i=0; i<length; i++) {
            if (max[i] > nums[i]) {
                water = water + max[i] - nums[i];
            }
        }
        return water;
    }

    public static void main(String[] args) {
//        int[] test = {1, 0, 1, 3, 0, 2, 2};
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapRain(test));
    }
}
