class ProductOfNumbers {

    public ArrayList<Integer> pre;

    public ProductOfNumbers() {
        pre = new ArrayList<>();
        pre.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            pre.clear();
            pre.add(1);
        }
        else{
            int n = pre.size();
            pre.add(pre.get(n-1)*num);
        }
    }
    
    public int getProduct(int k) {
        int n = pre.size();
        return k >= n ? 0 : pre.get(n-1)/pre.get(n-1-k);
    }
}

