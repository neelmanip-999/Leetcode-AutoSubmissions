class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slot = 1;
        for(String node : nodes){
            slot--;
            if(slot < 0) return false;
            if(!node.equals("#")){
                slot+=2;
            }
        }
        return slot == 0;
    }
}