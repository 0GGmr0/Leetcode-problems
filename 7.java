//-2147483648...2147483647

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            int x = input.nextInt();
            Solution test = new Solution();
            System.out.println(test.reverse(x));
        }

    }

    public int reverse(int x) {
        int MIN_VALUE = 0x80000000; //最小   -2147483648
        int MAX_VALUE = 0x7fffffff; //最大    2147483647
        long res = 0;
        //int res = 0;
        int temp = x;
        int len = 1;
        for(;temp != 0;) {
            temp = temp/10;
            if(temp != 0) {
                len++;
            }
        }
        //System.out.println(len);
        for(int i = 0; i < len; i++) {
            res = 10 * res + x%10;
            x /= 10 ;
        }
        System.out.println(res);
        if( (res < 0 && res>MIN_VALUE) ||
                (res > 0 && res < MAX_VALUE) ){
//            for(int i = 0; i < len; i++){
//                res = 10 * res + res0%10;
//                res0 /= 10;
//            }
//            System.out.println(res);
            return (int)res;
        }
        else
            return 0;
    }
}

