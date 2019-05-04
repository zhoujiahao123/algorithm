package BinaryTree.BinarySearchTree;


import sun.misc.Queue;

import java.util.Arrays;

public class BTS<Key extends Comparable<Key>, Value extends Comparable<Value>> {
    //二叉树根节点
    public Node root;

    public class Node {
        private Key key; //键
        private Value value;//值
        private Node left, right;//左节点和右节点
        private int N;//以该节点为根的子树中的节点总数

        public Node() {

        }

        //构造方法
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    int count;

    //判断是否有等值的键
    public boolean hasNoDuplicates(Node node) {
        count = 0;
        hasNoDuplicates(root, node.value);
        return count != 0;
    }

    private void hasNoDuplicates(Node x, Value val) {
        if (x == null) return;
        int cmp = val.compareTo(x.value);
        if (cmp == 0) {
            count++;
        }
        hasNoDuplicates(x.left, val);
        hasNoDuplicates(x.right, val);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    //线序遍历
    public void preOrder() {
        preOrder(root);
    }

    //线序遍历
    private void preOrder(Node x) {
        if (x == null) return;
        System.out.print(x.key);
        preOrder(x.left);
        preOrder(x.right);
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

    private Value get(Node x, Key key) {
        //如果树为空，则返回null
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.value;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    //插入某个值
    public void put(Key key, Value value) {
        //查找key，找到更新它的值，找不到则插入
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
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
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        } else {
            //当找到小于key的键，要判断其右子树是否存在小于等于key的键，若有则返回那个节点，没有则返回当前节点
            Node t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);

    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Queue<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }
}

