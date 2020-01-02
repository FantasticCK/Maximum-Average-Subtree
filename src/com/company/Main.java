package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }
    // res[0] = number of nodes in this tree, res[1] = local avg, res[2] = global avg.
    private double[] helper(TreeNode root) {
        if (root == null)
            return new double[]{0.0, 0.0, 0.0};
        double[] left = helper(root.left), right = helper(root.right);
        double localNodes = left[0] + right[0] + 1.0;
        double localAvg = ((root.val) + left[0] * left[1] + right[0] * right[1]) / localNodes;
        double globalAvg = Math.max(Math.max(left[2], right[2]), localAvg);
        return new double[]{localNodes, localAvg, globalAvg};
    }
}