class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> ans = new ArrayList<>();
        int sum = digits[n-1] + 1;
        int carry = sum/10;
        ans.add(sum%10);
        for(int i = n-2; i>=0; i--){
            sum = digits[i] + carry;
            carry = sum/10;
            ans.add(sum%10);
            sum = 0;
        }
        if(carry!=0) ans.add(carry);
        int size = ans.size();
        int[] f = new int[size];
        int p = size-1;
        for(int i = 0; i<size; i++){
            f[p--] = ans.get(i);
        }
        return f;
    }
}