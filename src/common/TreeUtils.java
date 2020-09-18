package common;

public class TreeUtils {
    public static String dumpTree(TreeNode root) {
        return dumpTree("", root);
    }

    private static String dumpTree(String indent, TreeNode root) {
        if (root == null) { return ""; }
        if (root.left == null && root.right == null) {
            // return indent + "(" + root.val + ")" + System.lineSeparator();
            return indent + root.val + System.lineSeparator();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dumpTree(indent + "/--", root.right));
        // sb.append(indent + "(" + root.val + ")" + System.lineSeparator());
        sb.append(indent + root.val + System.lineSeparator());
        sb.append(dumpTree(indent + "\\--", root.left));
        return sb.toString();
    }
}
