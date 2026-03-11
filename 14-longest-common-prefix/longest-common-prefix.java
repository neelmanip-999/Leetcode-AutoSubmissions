class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // String prefix = strs[0];
        // for (int i = 1; i < strs.length; i++) {
        //     while (!strs[i].startsWith(prefix)) {
        //         // prefix = prefix.substring(0, prefix.length() - 1);
        //         if (prefix.isEmpty()) return "";
        //     }
        // }
        // return prefix;
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Math.min(strs[0].length(), strs[strs.length-1].length()); i++){
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }
            else break;
        }
        return sb.toString();
    }
}