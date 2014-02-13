package algs;

/**
 * Union Find (Quick Find) data structure.
 * <p>
 * union(): O(n); connected(): O(1).
 * 
 * @author Dongliang Yu
 * 
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        if (id[p] == id[q])
            return;
        int pid = id[p];
        int qid = id[q];
        for (int k = 0; k < id.length; k++) {
            if (id[k] == qid)
                id[k] = pid;
        }
    }

    public boolean connected(int i, int j) {
        return id[i] == id[j];
    }

    public int find(int p) {
        return id[p];
    }

    public int count() {
        return id.length;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < id.length; i++)
            sb.append(id[i] + " ");
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = 10;
        QuickFindUF uf = new QuickFindUF(N);
        java.util.Random random = new java.util.Random();
        System.out.println(uf);
        for (int count = 0; count < N; count++) {
            int i = random.nextInt(N);
            int j = random.nextInt(N);
            System.out.printf("Union %d and %d:\n", i, j);
            uf.union(i, j);
            System.out.println(uf);
        }
        // int N = 100000;
        // QuickFindUF uf = new QuickFindUF(N);
        // java.util.Random random = new java.util.Random();
        // Stopwatch stopwatch = new Stopwatch();
        // for (int count = 0; count < N; count++) {
        // int i = random.nextInt(N);
        // int j = random.nextInt(N);
        // uf.union(i, j);
        // uf.connected(i, j);
        // }
        // java.util.Date end = new java.util.Date();
        // System.out.println(stopwatch.elapsedTime());
    }

}
