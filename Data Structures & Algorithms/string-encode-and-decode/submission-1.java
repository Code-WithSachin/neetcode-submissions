class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
              .append("#")
              .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        // 5#Hello5#World

        int right  = 0, left = 0;

        while(left < str.length()){
            right = left;
            while(str.charAt(right) != '#'){
                right++;
            }

            int stringLength = Integer.parseInt(str.substring(left, right));

            right++;

            String currString = str.substring(right, right+stringLength);
            list.add(currString);

            left = right+stringLength;
        }
        return list;
    }
}
