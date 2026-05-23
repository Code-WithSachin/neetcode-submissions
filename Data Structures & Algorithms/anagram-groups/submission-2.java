class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedString = Arrays.toString(charArray);

            List<String> list;
            if(map.containsKey(sortedString)){
                list = map.get(sortedString);
                list.add(str);
            }else{
                list = new ArrayList<>();
                list.add(str);
            }

            map.put(sortedString, list);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String str: map.keySet()){
            ans.add(map.get(str));
        }

        return ans;
    }
}
