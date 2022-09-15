public class PseudoPalindromicPaths {

    static class Payload {
        boolean[] parity = new boolean[9];

        public Payload() {
        }

        public Payload(Payload prev, int next) {
            System.arraycopy(prev.parity, 0, parity, 0, 9);
            parity[next-1] = !parity[next-1];
        }

        public int applies() {
            int sum = 0;
            for (int i=0;i<parity.length;i++) {
                if (!parity[i]) {
                    ++sum;
                }
            };

            return (sum >= 8) ? 1 : 0;
        }

    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return walkWithPayload(root, new Payload());
    }

    public int walkWithPayload(TreeNode root, Payload trail) {
        if (root == null) {
            return 0;
        }
        Payload p = new Payload(trail, root.val);

        if (root.left == null && root.right == null) {
            return p.applies();
        }
        else {
            return walkWithPayload(root.left, p) + walkWithPayload(root.right, p);
        }
    }

}
