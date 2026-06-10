class Solution {
   public static void recur(int index, int []arr, List<Integer>helper,  List<List<Integer>>ans, int target){
       if(target==0){
           ans.add(new ArrayList<>(helper));
           return;
       }
       if(target<0||index==arr.length) return;
       
       helper.add(arr[index]);
       recur(index,arr, helper, ans, target-arr[index]);
       helper.remove(helper.size()-1);
       recur(index+1,arr, helper, ans, target);
   }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        recur(0, candidates,new ArrayList<>(), ans, target);
        return ans;
    }
}