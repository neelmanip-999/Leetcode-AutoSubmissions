class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> userLangs = new ArrayList<>();
        for(int[] langs : languages){
            Set<Integer> set = new HashSet<>();
            for(int l : langs) set.add(l);
            userLangs.add(set);
        }
        Set<Integer> problematic = new HashSet<>();
        for(int[] f : friendships){
            int u = f[0]-1;
            int v = f[1]-1;
            Set<Integer> setU = userLangs.get(u);
            Set<Integer> setV = userLangs.get(v);
            boolean canTalk = false;
            for(int lang : setU){
                if(setV.contains(lang)){
                    canTalk = true;
                    break;
                }
            }
            if(!canTalk){
                problematic.add(u);
                problematic.add(v);
            }
        }
        if(problematic.isEmpty()) return 0;
        int[] langCount = new int[n+1];
        for(int user : problematic){
            for(int lang : userLangs.get(user)){
                langCount[lang]++;
            }
        }
        int maxKnown = 0;
        for(int count : langCount){
            maxKnown = Math.max(maxKnown, count);
        }
        return problematic.size()-maxKnown;
    }
}