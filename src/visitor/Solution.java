package visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-vistor-pattern
*/

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //nothing to do with Node
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int divisor = (int) (Math.pow(10, 9) + 7);

    public int getResult() {
        //implement this
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % divisor;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % divisor;
        }
    }
}

class FancyVisitor extends TreeVis {

    private int sumOfNodeValuesAtEvenDept = 0;
    private int sumOfGreenLeafValues = 0;

    public int getResult() {
        //implement this
        return Math.abs(sumOfNodeValuesAtEvenDept - sumOfGreenLeafValues);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            sumOfNodeValuesAtEvenDept += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            sumOfGreenLeafValues += leaf.getValue();
        }
    }
}

public class Solution {

    static int[] values;
    static Color[] colors;
    static HashMap<Integer, HashSet<Integer>> nodeEdges;

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();

        values = new int[numberOfNodes];
        colors = new Color[numberOfNodes];
        nodeEdges = new HashMap<>(numberOfNodes);


        for (int i = 0; i < numberOfNodes; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < numberOfNodes; i++) {
            colors[i] = sc.nextInt() == 1 ? Color.GREEN : Color.RED;
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            nodeEdges.computeIfAbsent(u, mappingFunction -> new HashSet<>());
            nodeEdges.get(u).add(v);

            nodeEdges.computeIfAbsent(v, mappingFunction -> new HashSet<>());
            nodeEdges.get(v).add(u);
        }
        sc.close();

        if (numberOfNodes == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static void addChildren(TreeNode parent, int nodeIdentifierNumber) {
        for (Integer edge : nodeEdges.get(nodeIdentifierNumber)) {
            Tree tree;
            nodeEdges.get(edge).remove(nodeIdentifierNumber);
            if (nodeEdges.get(edge) != null && !nodeEdges.get(edge).isEmpty()) {
                tree = new TreeNode(values[edge - 1], colors[edge - 1], parent.getDepth() + 1);
            } else {
                tree = new TreeLeaf(values[edge - 1], colors[edge - 1], parent.getDepth() + 1);
            }
            parent.addChild(tree);

            if (tree instanceof TreeNode) {
                addChildren((TreeNode) tree, edge);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
