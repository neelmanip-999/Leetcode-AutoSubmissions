class Solution {
    public int findComplement(int num) {
        String binStr = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(char ch : binStr.toCharArray()){
            if(ch == '0') sb.append('1');
            else sb.append('0');
        }
        int number = Integer.parseInt(sb.toString(), 2);
        return number;
    }
}