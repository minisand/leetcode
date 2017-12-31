import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weiyao on 11/5/17.
 */

public class Leetcode102 {
    public static ArrayList<ArrayList<Integer>> levelOrder(ArrayList<Integer> input) {
        int numberPerLevel = 1;
        int scannedSoFar = 0;
        int length = input.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        while (scannedSoFar < length) {
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < numberPerLevel; i++) {
                Integer element = input.get(i+ scannedSoFar);
                if (element != null) {
                    System.out.println(element);
                    level.add(element);
                } else {
                    System.out.println("null");
                }
            }
            scannedSoFar = scannedSoFar + numberPerLevel;
            numberPerLevel = numberPerLevel * 2;
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(3,1,3,7,8,9,10,null,15, null, null, 11, null, null, null));
        ArrayList<ArrayList<Integer>> result = levelOrder(input);
        for (int i= 0; i < result.size(); i++) {
            ArrayList<Integer> level = result.get(i);
            for (int j = 0; j < level.size() ; j++) {
                System.out.print(level.get(j) + ",");
            }
            System.out.println();
        }
    }
}
