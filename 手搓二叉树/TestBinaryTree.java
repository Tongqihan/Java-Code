package Tree;

import sun.reflect.generics.tree.Tree;

import javax.print.DocFlavor;
import javax.xml.bind.annotation.XmlType;
import java.util.*;

public class TestBinaryTree {
    static class TreeNode {
        public int val;  // 数据域
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;  // 代表二叉树的根节点
    public int nodeSize;  // 节点个数
    public int leafSize;  // 叶子节点个数
    public TreeNode createTree() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

//    前序遍历
    public void preOrder(TreeNode root) {
//        递归出口
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

//    中序遍历
    public void inOrder(TreeNode root) {
//        递归出口
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

//    后序遍历
    public void postOrder(TreeNode root) {
//        递归出口
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

//    层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                count--;
            }
            ret.add(list);
        }
        return ret;
    }

//    获取二叉树中节点的个数
//    时间复杂度 O(N)
//    空间复杂度 O(logN) ~ O(N) 坏的情况下是一棵单分支的树
//    在递归右边时，左边已经递归完了
    public int size(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    public void size2(TreeNode root) {
        if (root == null) return;
        nodeSize++;
        size2(root.left);
        size2(root.right);
    }

//    获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = getLeafNodeCount(root.left);
        int right = getLeafNodeCount(root.right);
        return left + right;
    }

    public void getLeafNodeCount2(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);
    }

//    获取第 k 层节点个数
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) return 0;
        if (k == 1) return 1;
        int left = getKLevelNodeCount(root.left, k - 1);
        int right = getKLevelNodeCount(root.right, k - 1);
        return left + right;
    }

//    获取二叉树的高度
//    时间复杂度 O(N)
//    空间复杂度 树的高度
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        return left > right ? left : right;
    }

//    检测值为 value 的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode leftTree = find(root.left, val);
        if (leftTree != null) return leftTree;

        TreeNode rightTree = find(root.right, val);
        if (rightTree != null) return rightTree;
        return null;
    }

//    判断二叉树是否为完全二叉树
//    利用队列
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;  // 空树是一棵完全二叉树
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                return false;
            }
        }
        return true;
    }

//    前序遍历 - 非递归
    public void preOrderNor(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

//    中序遍历 - 非递归
    public void inOrderNor(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

//    后序遍历 - 非递归
    public void postOrderNor(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }
}
