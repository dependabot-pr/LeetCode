class Pair {
    int v;
    int idx;
    Pair(int v, int idx) {
        this.v = v;
        this.idx = idx;
    }
}
class Solution {
    private Integer[] ans;
    public List<Integer> countSmaller(int[] nums) {
        ans = new Integer[nums.length];
        Arrays.fill(ans, 0);
        Pair[] pairs = convertToPairs(nums);
        mergeSort(pairs, new Pair[nums.length], 0, nums.length - 1);
        return Arrays.asList(ans);
    }
    private Pair[] convertToPairs(int[] nums) {
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        return pairs;
    }
    private void mergeSort(Pair[] pairs, Pair[] aux, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(pairs, aux, left, mid);
            mergeSort(pairs, aux, mid + 1, right);
            for(int i = left; i <= right; i++) {
                aux[i] = pairs[i];
            }
            int j = left, k = mid + 1;
            for(int i = left; i <= right; i++) {
                if(j <= mid && k <= right) {
                    if(aux[j].v <= aux[k].v) {
                        pairs[i] = aux[j];
                        ans[aux[j].idx] += (k - mid - 1);
                        j++;
                    }
                    else {
                        pairs[i] = aux[k];
                        k++;
                    }
                }
                else if(j <= mid) {
                    pairs[i] = aux[j];
                    ans[aux[j].idx] += (k - mid - 1);
                    j++;
                }
                else {
                    pairs[i] = aux[k];
                    k++;
                }
            }
        }
    }
}