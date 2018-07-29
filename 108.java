class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sort(nums, 0, nums.length - 1);
    }
    

    static TreeNode sort(int[] s, int l, int r) {
        if(l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode t = new TreeNode(s[mid]);
        t.left = sort(s, l, mid - 1);
        t.right = sort(s, mid + 1, r);
        return t;
    }
    
}