package BasicStruct;

import java.util.*;

public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

        public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 层序遍历
     * 本质是广度优先遍历(breadth-first traversal)
     */
    List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    /**
     * 前序遍历
     * 本质是深度遍历，下同(depth-first traversal)
     * 访问优先级：根节点 -> 左子树 -> 右子树
     */
    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 中序遍历
     * 访问优先级：左子树 -> 根节点 -> 右子树
     */
    void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * 后序遍历
     * 访问优先级：左子树 -> 右子树 -> 根节点
     */
    void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    /**
     * 查找节点
     */
    TreeNode search(TreeNode root, int num) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val < num) {
                cur = cur.right;
            } else if (cur.val > num) {
                cur = cur.left;
            } else break;
        }
        return cur;
    }

    /**
     * 插入节点
     */
    void insert(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null) {
            if (cur.val == num) return;

            pre = cur;
            if (num < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        TreeNode node = new TreeNode(num);
        if (pre.val < num) pre.right = node;
        else pre.left = node;
    }

    /**
     * 删除节点
     */
    void remove(TreeNode root, int num) {
        if (root == null) return;

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null) {
            if (cur.val == num) break;

            pre = cur;

            if (cur.val < num) cur = cur.right;
            else cur = cur.left;
        }

        if (cur == null) return;

        if (cur.left == null || cur.right == null) {
            TreeNode child = cur.left == null ? cur.right : cur.left;

            if (cur != root) {
                if (pre.left == cur) pre.left = child;
                else pre.right = child;
            } else {
                root = child;
            }
        } else {
            TreeNode temp = cur.right;
            while(temp.left != null){
                temp = temp.left;
            }
            remove(root, temp.val);
            cur.val = temp.val;
        }
    }
}
