package util;

import ds.ListNode;
import ds.TreeNode;

import java.util.Arrays;
import java.util.List;

/** 打印/构造工具，方便本地调试。 */
public final class Prints {

    private Prints() {
    }

    public static String str(int[] a) {
        return Arrays.toString(a);
    }

    public static String str(int[][] a) {
        return Arrays.deepToString(a);
    }

    /** 由数组构造链表，例如 list(1,2,3) -> 1->2->3 */
    public static ListNode list(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    /** 链表转字符串，例如 1->2->3 */
    public static String str(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append("->");
            }
            head = head.next;
        }
        return sb.toString();
    }

    /** 由层序遍历数组构造二叉树（null 表示空节点），例如 tree(1,null,2,3) */
    public static TreeNode tree(Integer... vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            TreeNode node = q.poll();
            if (i < vals.length && vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                q.offer(node.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    /** 二叉树层序遍历输出，例如 [1,2,3,null,null,4] */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new java.util.ArrayList<>();
        if (root == null) {
            return res;
        }
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add(null);
                continue;
            }
            res.add(node.val);
            if (node.left != null || node.right != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        while (!res.isEmpty() && res.get(res.size() - 1) == null) {
            res.remove(res.size() - 1);
        }
        return res;
    }
}
