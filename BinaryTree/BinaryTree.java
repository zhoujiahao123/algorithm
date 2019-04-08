package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个简单的二叉树
 */
public class BinaryTree {
    private BinaryTree lChild;
    private BinaryTree rChild;
    private BinaryTree root;
    private Object data;
    private List<BinaryTree> datas;

    public BinaryTree(BinaryTree lChild, BinaryTree rChild, Object data) {
        this.rChild = rChild;
        this.lChild = lChild;
        this.data = data;
    }

    public BinaryTree(Object data) {
        this(null, null, data);
    }

    public BinaryTree() {
        super();
    }

    //创建树
    public void createTree(Object[] objects) {
        datas = new ArrayList<BinaryTree>();
        for (Object o : objects) {
            datas.add(new BinaryTree(o));
        }
        root = datas.get(0);
        for (int i = 0; i < objects.length / 2; i++) {
            datas.get(i).lChild = datas.get(2 * i + 1);
            if (2 * i + 2 < datas.size()) {
                datas.get(i).rChild = datas.get(2 * i + 2);
            }
        }
    }

    public void visit(Object o) {
        System.out.print(o + " ");
    }

    public Object getData() {
        return data;
    }

    //先序遍历
    public void preorder(BinaryTree root) {
        if (root != null) {
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }
    }

    //中序遍历
    public void inorder(BinaryTree root) {
        if (root != null) {
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }
    }
    //后序遍历
    public void afterorder(BinaryTree root){
        if(root != null){
            afterorder(root.lChild);
            afterorder(root.rChild);
            visit(root.getData());
        }
    }
    public BinaryTree getRoot(){
        return root;
    }
}
class Test{
    public static void main(String []args){
        BinaryTree binaryTree = new BinaryTree();
        Object []objects = {0,1,2,3,4,5,6,7};
        binaryTree.createTree(objects);
        BinaryTree root = binaryTree.getRoot();
        System.out.println("先序遍历");
        binaryTree.preorder(root);
        System.out.println("中序遍历");
        binaryTree.inorder(root);
        System.out.println("后序遍历");
        binaryTree.afterorder(root);
    }
}