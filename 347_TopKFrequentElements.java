//Runtime 8ms, Memory 41.4 MB

class Num {
    int value;
    int frequency;
    
    public Num(int value) {
        this.value = value;
        frequency = 1;
    }
    
    public void add() {
        frequency++;
    }
}

class NumComparator implements Comparator<Num> {
    public int compare(Num n1, Num n2) {
        if(n1.frequency < n2.frequency) {
            return 1;
        }
        else if(n1.frequency == n2.frequency) {
            return 0;
        }
        return -1;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == 0 || nums.length == 0) {
            return new int[0];
        }
        if(nums.length == 1) {
            return new int[] {nums[0]};
        }
        Map<Integer, Num> numMap = new HashMap<Integer, Num>();
        List<Num> numList = new ArrayList<Num>();
        
        for(int num : nums) {
            if(numMap.containsKey(num)) {
                numMap.get(num).add();
            }
            else {
                numMap.put(num, new Num(num));
                numList.add(numMap.get(num));
            }
        }
        numList.sort(new NumComparator());
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = numList.get(i).value;
        }
        return ret;
    }
}