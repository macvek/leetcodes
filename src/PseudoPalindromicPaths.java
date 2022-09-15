import java.util.*;

public class PseudoPalindromicPaths {


    public int pseudoPalindromicPaths (TreeNode root) {
        return walkWithPayload(root, new ArrayList<>());
    }

    public int walkWithPayload(TreeNode root, List<Integer> trail) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> copied = new ArrayList<>(trail);
        copied.add(root.val);

        if (root.left == null && root.right == null) {
            return applies(copied);
        }
        else {
            return walkWithPayload(root.left, copied) + walkWithPayload(root.right, copied);
        }
    }

    public int applies(List<Integer> trail) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Integer each : trail) {
            counts.putIfAbsent(each, 0);
            counts.put(each, counts.get(each)+1);
        }

        int passed = 0;
        for (Integer count : counts.values()) {
            if (count % 2 == 0) {
                ++passed;
            }
        }

        return counts.values().size() - passed <= 1 ? 1 : 0;
    }


}
