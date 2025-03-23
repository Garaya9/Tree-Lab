package genericlab;

/**
 * Author: G. Araya
 * Date: March 23, 2025
 * Compiler: Eclipse
 * Lab Number: 6
 * Description: Implements Binary Tree operations including 
 * traversal (Inorder, Preorder, Postorder), height calculation, 
 * and storing/reconstructing the tree using an array.
 */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    // 1a: Inorder Traversal (Left, Root, Right)
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // 1b: Preorder Traversal (Root, Left, Right)
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // 1c: Postorder Traversal (Left, Right, Root)
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // 1d: Compute Tree Height
    int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 1d: Print Nodes at a Given Level
    void printLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1) System.out.print(node.data + " ");
        else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    // 3b: Store Tree in an Array (Using 2i+1 / 2i+2 Rule)
    void storeInArray(Node node, Integer[] arr, int i) {
        if (i >= arr.length) return;
        if (node == null) {
            arr[i] = null;
            return;
        }
        arr[i] = node.data;
        storeInArray(node.left, arr, 2 * i + 1);
        storeInArray(node.right, arr, 2 * i + 2);
    }

    // 4: Convert an Array into a Binary Tree
    Node arrayToTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) return null;
        Node node = new Node(arr[i]);
        node.left = arrayToTree(arr, 2 * i + 1);
        node.right = arrayToTree(arr, 2 * i + 2);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(35);
        tree.root.left = new Node(20);
        tree.root.right = new Node(71);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(52);
        tree.root.right.left = new Node(63);
        tree.root.right.right = null;
        tree.root.left.left.left = new Node(17);
        tree.root.left.left.right = new Node(25);
        tree.root.left.right.right = new Node(7);
        tree.root.right.left.right = new Node(45);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Height: " + tree.height(tree.root));

        System.out.print("Nodes at Level 2: ");
        tree.printLevel(tree.root, 2);
        System.out.println();

        Integer[] arr = new Integer[15];
        tree.storeInArray(tree.root, arr, 0);

        System.out.println("Array Representation (with nulls): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + " -> " + (arr[i] == null ? "null" : arr[i]));
        }

        Node newTree = tree.arrayToTree(arr, 0);
        System.out.print("Inorder of new tree: ");
        tree.inorder(newTree);
        System.out.println();
    }
}
