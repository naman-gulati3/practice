class SumOfPrefixScore {
    class Tri {
        TreeNode root;

        public Tri() {
            root = new TreeNode();
        }
    } 


    class TreeNode {
        int count = 0;
        TreeNode[] children;

        public TreeNode() {
            this.children = new TreeNode[26];
        }

        public TreeNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public void setChild(TreeNode node, char ch) {
            children[ch - 'a'] = node;
        }

        public void inc(char ch) {
            children[ch - 'a'].count++;
        }

        public int getCount(char ch) {
            return children[ch - 'a'].count;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Tri tri = new Tri();
        for(String s : words) {
            insert(s, tri.root);
        }

        int[] result = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            result[i] = search(words[i], tri.root);
        }

        return result;
    }

    public void insert(String s, TreeNode root) {
        TreeNode current = root;

        for(char ch : s.toCharArray()) {
            TreeNode child = current.getChild(ch);

            if(child == null) {
                child = new TreeNode();
                current.setChild(child, ch);
            }
            current.inc(ch);
            current = child;
        }
    }

    public int search(String prefix, TreeNode root) {
        TreeNode current = root;
        int count = 0;

        for(char ch : prefix.toCharArray()) {
            TreeNode child = current.getChild(ch);
            if(child == null) {
                return count;
            }
            count += current.getCount(ch);
            current = child;
        }

        return count;
    }
}