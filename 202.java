class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        if(n == 1) return true;
        set.add(n);
        Integer num = mul(n);
//        System.out.println(num);
        while(!(num == 0 || set.contains(num))) {
            set.add(num);
            if(num == 1) return true;
            num = mul(num);
//            System.out.println(num);
        }
        return false;
    }
    
    public Integer mul(int n) {
        Integer res = 0;
        while(n != 0) {
            Integer m = n % 10;
            res += m * m;
            n /= 10;
        }
        return res;
    }
}