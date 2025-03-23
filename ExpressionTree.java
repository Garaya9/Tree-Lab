package genericlab;

/**
 * Author: G. Araya
 * Date: March 23, 2025
 * Compiler: Eclipse
 * Lab Number: 6
 * Description: Implements an Expression Tree that supports 
 * Inorder and Postorder traversal, Integer Division, and Floating Point Evaluation.
 */
class ExprNode {
    char value;
    ExprNode left, right;

    ExprNode(char item) {
        value = item;
        left = right = null;
    }
}

public class ExpressionTree {
    ExprNode root;

    void inorder(ExprNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    void postorder(ExprNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    int evaluate(ExprNode node) {
        if (node == null) return 0;
        if (Character.isDigit(node.value)) return node.value - '0';
        int leftVal = evaluate(node.left);
        int rightVal = evaluate(node.right);
        switch (node.value) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/': return leftVal / rightVal;
        }
        return 0;
    }

    double evaluateFloat(ExprNode node) {
        if (node == null) return 0;
        if (Character.isDigit(node.value)) return node.value - '0';
        double leftVal = evaluateFloat(node.left);
        double rightVal = evaluateFloat(node.right);
        switch (node.value) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/': return leftVal / rightVal;
        }
        return 0;
    }

    public static void main(String[] args) {
        ExpressionTree exprTree = new ExpressionTree();
        exprTree.root = new ExprNode('/');
        exprTree.root.left = new ExprNode('*');
        exprTree.root.right = new ExprNode('+');
        exprTree.root.left.left = new ExprNode('4');
        exprTree.root.left.right = new ExprNode('2');
        exprTree.root.right.left = new ExprNode('3');
        exprTree.root.right.right = new ExprNode('1');

        System.out.print("Inorder Expression: ");
        exprTree.inorder(exprTree.root);
        System.out.println();

        System.out.print("Postorder Expression: ");
        exprTree.postorder(exprTree.root);
        System.out.println();

        System.out.println("Integer Division Result: " + exprTree.evaluate(exprTree.root));
        System.out.println("Floating Division Result: " + exprTree.evaluateFloat(exprTree.root));
    }
}
