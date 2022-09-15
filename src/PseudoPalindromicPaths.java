import java.util.*;

public class PseudoPalindromicPaths {

    static class Payload {
        Payload prev;
        Integer value;

        public Payload(Payload prev, Integer value) {
            this.prev = prev;
            this.value = value;
        }

    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return walkWithPayload(root, new Payload(null, null));
    }

    public int walkWithPayload(TreeNode root, Payload trail) {
        if (root == null) {
            return 0;
        }
        Payload p = new Payload(trail, root.val);

        if (root.left == null && root.right == null) {
            return applies(p);
        }
        else {
            return walkWithPayload(root.left, p) + walkWithPayload(root.right, p);
        }
    }

    public int applies(Payload p) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        Payload next = p;
        while(next != null && next.value != null) {
            var each = next.value;
            counts.putIfAbsent(each, 0);
            counts.put(each, counts.get(each)+1);
            next = next.prev;
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
