package BinaryTree.BinarySearchTree;

public class BTS<Key extends Comparable<Key>, Value> {
    //二叉树根节点
    private Node root;

    private class Node {
        private Key key; //键
        private Value value;//值
        private Node left, right;//左节点和右节点
        private int N;//以该节点为根的子树中的节点总数

        //构造方法
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        //以该节点为根的子树中的节点总数
        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) {
                return 0;
            } else {
                return x.N;
            }
        }

        //查找某个值
        public Value get(Key key) {
            return get(root, key);
        }

        public Value get(Node x, Key key) {
            //如果树为空，则返回null
            if (x == null) {
                return null;
            }
            int cmp = key.compareTo(x.key);
            if(cmp == 0){
                return x.value;
            }else if(cmp<0){
                return get(x.left, key);
            }else{
                return get(x.right, key);
            }
        }

        //插入某个值
        public void put(Key key, Value value) {
            //查找key，找到更新它的值，找不到则插入
            root = put(root, key, value);
        }

        public Node put(Node x, Key key, Value value) {
            if (x == null) {
                return new Node(key, value, 1);
            }
            int cmp = key.compareTo(x.key);
            if(cmp == 0){
                x.value = value;
            }else if(cmp<0){
                x.left = put(x.left, key, value);
            }else{
                x.right = put(x.right, key, value);
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public Key min() {
            return min(root).key;
        }

        public Node min(Node x) {
            if (x.left == null) return x;
            return min(x.left);
        }

        public Key floor(Key key) {
            Node x = floor(root,key);
            if(x == null) return null;
            return x.key;
        }

        public Node floor(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }
    }
}
