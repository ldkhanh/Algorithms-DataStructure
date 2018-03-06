class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, ArrayList<Integer>> mp = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ " ");
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
            } else {
                ArrayList<Integer> l = mp.get(nums[i]);
                l.add(i);
                mp.put(nums[i], l);
            }
        }
        System.out.println("\n"+mp);
        Set<List<Integer>> ans = new TreeSet<>((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++){
                int cmp = o1.get(i) - o2.get(i);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return o1.size() - o2.size();
        });
        for (int k = 0; k < nums.length-2; k++) {
            // remove current nums[k] with k in mp
            ArrayList<Integer> l = mp.get(nums[k]);
            l.remove(l.indexOf(k));
            if (l.size() == 0) 
                mp.remove(nums[k]);
            else 
                mp.put(nums[k],l);
            
            System.out.println(mp);
            for (int i = k+1; i < nums.length; i++) {
                int com = -nums[k] - nums[i];
                if (mp.containsKey(com)) {
                    ArrayList<Integer> lk = mp.get(com);
                    for (int li = 0; li < lk.size(); li++) {
                        if (i < lk.get(li) )
                            ans.add(Arrays.asList(nums[k], nums[i], nums[lk.get(li)]));
                    }
                }
            }
        }
        List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
        ans2.addAll(ans);
        return ans2;
    }
}