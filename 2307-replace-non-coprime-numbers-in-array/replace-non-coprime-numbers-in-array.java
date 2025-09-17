class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for(int num : nums){
            while(!ll.isEmpty()){
                int top = ll.get(ll.size()-1);
                int g = gcd(top, num);
                if(g > 1){
                    num = lcm(top, num);
                    ll.remove(ll.size()-1);
                }
                else{
                    break;
                }
            }
            ll.add(num);
        }
        return ll;
    }

    public int gcd(int a, int b){
        return b == 0 ? a:gcd(b, a%b);
    }

    public int lcm(int a, int b){
        return (int)( (long) a*b/gcd(a,b));
    }
}