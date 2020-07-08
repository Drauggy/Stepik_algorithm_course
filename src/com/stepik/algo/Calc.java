import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static int n;
    private static List<List<Integer>> roots = new ArrayList<>();
    private static List<Integer> root = new ArrayList<>();

    static class Tree {
        int val;
        Tree parent;
        Tree left;
        Tree center;
        Tree right;

        Tree(int val, Tree parent) {

            if (val == 0) return;
            this.val = val;
            this.parent = parent;
            if (val == 1) {
                Run(this);

                return;
            }
            if (val % 3 == 0) {
                this.left = new Tree(val / 3, this);
            }
            if (val % 2 == 0) {
                this.center = new Tree(val / 2, this);
            }
            this.right = new Tree(val - 1, this);
        }

        private void Run(Tree tree) {

            root.add(tree.val);
            if (tree.parent == null) {
                roots.add(root);
                root = new ArrayList<>();
                return;
            }

            Run(tree.parent);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());

        }

        new Tree(n, null);
        int min = Integer.MAX_VALUE;
        List<Integer> minList = null;
        for (List<Integer> integers : roots) {
            if (integers.size() < min) {
                min = integers.size();
                minList = integers;
            }
        }
        assert minList != null;
        System.out.println(minList.size() - 1);
        for (Integer root : minList) {

            System.out.print(root + " ");
            if (root == n) return;
        }
    }
}


