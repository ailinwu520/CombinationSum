import java.util.*;
public class CombinationSum {
    /**
     * Function finds the sum of all possible combinations of the target
     * @param candidates integer array contains unqiue candidates
     * @param target integer that sum up to
     * @return lists of all combinations in a list
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Complete this function
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        backtrackArray(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrackArray(int[] candidates, int start, int target, List<Integer> num, List<List<Integer>> result) {
        if(target < 0)
            return;
        else if(target == 0) {
            result.add(num);
        } else {
            for(int i = start; i < candidates.length; i++) {
                if( i > start && candidates[i] == candidates[i - 1])
                    continue;
                if(target - candidates[i] >= 0) {
                    List<Integer> tempList = new ArrayList<Integer>(num);
                    tempList.add(candidates[i]);
                    backtrackArray(candidates, i, target - candidates[i], tempList, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Modify the main function to test your cases if you need
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(cs.combinationSum(candidates, target));
        //Test case 1 output: [[2,2,3],[7]]
    }
}
