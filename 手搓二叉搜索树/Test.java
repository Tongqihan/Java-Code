package Map;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(12);
        binarySearchTree.insert(21);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(9);
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        System.out.println("------------------------");
        BinarySearchTree.TreeNode ret = binarySearchTree.find(12);
        System.out.println("找到了: " + ret.val);
    }
}
