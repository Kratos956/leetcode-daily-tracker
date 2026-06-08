class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode u = q.poll();

            if (u.left != null) {
                map.put(u.left, u);
                q.add(u.left);
            }

            if (u.right != null) {
                map.put(u.right, u);
                q.add(u.right);
            }
        }

        q.clear();

        TreeNode node = find(root, target.val);

        Set<TreeNode> visited = new HashSet<>();

        q.add(node);
        visited.add(node);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {

            if (k == 0) {
                for (TreeNode curr : q) {
                    res.add(curr.val);
                }
                return res;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode u = q.poll();

                if (u.left != null && !visited.contains(u.left)) {
                    visited.add(u.left);
                    q.add(u.left);
                }

                if (u.right != null && !visited.contains(u.right)) {
                    visited.add(u.right);
                    q.add(u.right);
                }

                TreeNode parent = map.get(u);

                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.add(parent);
                }
            }

            k--;
        }

        return res;
    }

    TreeNode find(TreeNode root, int target) {

        if (root == null || root.val == target) {
            return root;
        }

        TreeNode left = find(root.left, target);

        return left != null ? left : find(root.right, target);
    }
}