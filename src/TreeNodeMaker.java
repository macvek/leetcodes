public class TreeNodeMaker {

    public static TreeNode makeNode(Integer[] input) {
        return makeNode(input, 0);
    }

    public static TreeNode makeNode(Integer[] input, int pos) {
        if (pos >= input.length || input[pos] == null) {
            return null;
        }
        else {
            return new TreeNode(input[pos], makeNode(input, 2*pos+1), makeNode(input, 2*pos+2));
        }
    }

}

