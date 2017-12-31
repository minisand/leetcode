import java.util.*;

public class Leetcode1 {

    //this implementation handles case in which there are duplicated elements
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        HashMap tmp = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> indexArray;
        int[] result = new int[2];
        int complement;
        for (int i=0; i<nums.length; i++) {
            int number = nums[i];
            indexArray = (ArrayList<Integer>)tmp.get(number);
            if (indexArray == null) {
                indexArray = new ArrayList<Integer>();
            }
            indexArray.add(i);
            tmp.put(nums[i], indexArray);

            complement = target - number;
            ArrayList<Integer> complementIndexArray = (ArrayList<Integer>) tmp.get(complement);
            if ((complementIndexArray != null)
                    && ((complement != number) || ((complement == number) && (complementIndexArray.size() > 1)))) {
                result[0] = (i);
                result[1] = (complementIndexArray.get(0));
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2, 3, 2, 2, 3, 1};
        int[] result = twoSum(test, 4);
        System.out.println(result[0] + "  "  + result[1]);
    }
}
