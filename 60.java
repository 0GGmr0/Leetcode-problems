class Solution {
   public String getPermutation(int n, int k) {
        List<Integer> samples = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            samples.add(i);
        }
        return helper(samples,k);
    }
    public String helper(List<Integer> samples, int k){
        if(samples.size()==0){
            return "";
        }
        int size = samples.size();
        int product = 1;
        int i = 1;
        while(i<size){
            product = product * i;
            i++;
        }
        int index = (k - 1) / product;
        int remain = k - index * product;
        return samples.remove(index) + ""+  helper(samples,remain);
    }
}