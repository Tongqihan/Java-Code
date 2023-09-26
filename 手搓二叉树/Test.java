package Tree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = testBinaryTree.createTree();
        int size = testBinaryTree.size(root);
        System.out.println("nodeSize: " + size);
        testBinaryTree.size2(root);
        System.out.println("nodeSize2: " + testBinaryTree.nodeSize);
        System.out.println("------------------------------------------");
        System.out.println("leafSize: " + testBinaryTree.getLeafNodeCount(root));
        System.out.print("leafSize2: ");
        testBinaryTree.getLeafNodeCount2(root);
        System.out.println(testBinaryTree.leafSize);
        System.out.println("------------------------------------------");
        System.out.println("第 3 层节点个数: " + testBinaryTree.getKLevelNodeCount(root, 3));
        System.out.println("------------------------------------------");
        System.out.println("二叉树的高度为: " + testBinaryTree.getHeight(root));
        System.out.println("------------------------------------------");
        System.out.println(testBinaryTree.find(root, 1).val);
        System.out.println(testBinaryTree.find(root, 2).val);
        System.out.println(testBinaryTree.find(root, 3).val);
        System.out.println("------------------------------------------");
        System.out.println("层序遍历: ");
        testBinaryTree.levelOrder(root);
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("层序遍历2: ");
        List<List<Integer>> ret = testBinaryTree.levelOrder2(root);
        System.out.println(ret);
        System.out.println("------------------------------------------");
    }
    public static void main2(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = testBinaryTree.createTree();
        testBinaryTree.preOrder(root);
        System.out.println();
        System.out.println("--------------------");
        testBinaryTree.inOrder(root);
        System.out.println();
        System.out.println("--------------------");
        testBinaryTree.postOrder(root);
        System.out.println();
        System.out.println("--------------------");
    }
    public static void main1(String[] args) {
//        Deque 既可以当作栈来使用，也可以当作队列来使用，还可以当作双端队列来使用
        Queue<Integer> queue = new LinkedList<>();  // 只能当作队列来使用
        Deque<Integer> stack1 = new ArrayDeque<>();  // 数组实现栈
        Deque<Integer> stack2 = new LinkedList<>();  // 链表实现栈
        Deque<Integer> queue1 = new ArrayDeque<>();  // 数组实现队列
        Deque<Integer> queue2 = new LinkedList<>();  // 双向链表实现
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }
}
