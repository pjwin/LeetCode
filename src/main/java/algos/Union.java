package algos;

public class Union {
    private int[] root;

    public Union (int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        Union u = new Union(10);
        // 1-2-5-6-7 3-8-9 4
        u.union(1, 2);
        u.union(2, 5);
        u.union(5, 6);
        u.union(6, 7);
        u.union(3, 8);
        u.union(8, 9);
        System.out.println(u.connected(1, 5)); // true
        System.out.println(u.connected(5, 7)); // true
        System.out.println(u.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        u.union(9, 4);
        System.out.println(u.connected(4, 9)); // true
    }
}
