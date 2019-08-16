package DesignMode.structural.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 22:26
 * @Description: 组合模式又叫部分-整体在处理类似树型数据结构的时候，比较好处理
 */
public class CompositeTest {

    public static void main(String[] args) {
        Tree tree = new Tree("树形结构");
        TreeNode treeNode = new TreeNode("一级层次");
        TreeNode treeNode1 = new TreeNode("二级层次");

        tree.getRoot().add(treeNode);
        tree.getRoot().add(treeNode1);
        System.out.println("多个对象组合在一起操作的时候，常用于表示树形结构");
    }

}

class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void add(TreeNode treeNode) {
        children.add(treeNode);
    }

    public void remove(TreeNode treeNode) {
        children.remove(treeNode);
    }

    public Enumeration<TreeNode> getChildren() {
        return children.elements();
    }
}

class Tree {
    private TreeNode root = null;
    private String name;

    public Tree(String name) {
        this.name = name;
        this.root = new TreeNode(name);
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }
}