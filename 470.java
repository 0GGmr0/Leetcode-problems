class Solution extends SolBase {
    public int rand10() {
       while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) return num % 10 + 1;
        }
    }
}


// 题解在http://www.cnblogs.com/grandyang/p/9727206.html
