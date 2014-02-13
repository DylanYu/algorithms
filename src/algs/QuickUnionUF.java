package algs;

/**
 * Union Find (Quick Union) data structure.
 * <p>
 * When not balancing the tree, the performance is roughly same as QuickFind.
 * The performance improves significantly with balance.
 * <p>union(): O(lgN); connected(): O(lgN).
 * <p>Apply N = 100000, call union() and connected() randomly for 100000 times.
 * Running time: QuickFind is 8.5s, UnbalancedQuickUnion is 5s, and 
 * BalancedQuickUnion is 0.04s.
 * <p>When N is 10000000, with path compression, the running time is 2.8s, while
 * without path compression it is 3s.
 *
 * @author Dongliang Yu
 */
public class QuickUnionUF {
	private int[] id;
	private int[] size;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]]; // path compression, not necessary but why not.
			p = id[p];
		}
		return p;
		
//		recurse will be slightly slow when not balancing the tree (10% 
//		roughly), it's reasonable and easy to use iteration above rather 
//		then recurse below.
//		if (id[p] == p)
//			return p;
//		else
//			return root(id[p]);
	}
	
	/**
	 * Balancing the tree with size comparison is the key improvement.
	 * 
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j)
			return;
		if (size[i] > size[j]) {
			id[j] = id[i];
			size[i] += size[j];
		} else {
			id[i] = id[j];
			size[j] += size[i];
		}
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < id.length; i++)
			sb.append(id[i] + " ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int N = 10;
		QuickUnionUF uf = new QuickUnionUF(N);
		java.util.Random random = new java.util.Random();
		System.out.println(uf);
		for (int count = 0; count < N; count++) {
			int i = random.nextInt(N);
			int j = random.nextInt(N);
			System.out.printf("Union %d and %d:\n", i, j);
			uf.union(i, j);
			System.out.printf("%d and %d is connected: %b\n", i, j, uf.connected(i, j));
			System.out.println(uf);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(uf.connected(i, j) ? 1 : 0);
			System.out.println();
		}
//		int N = 100000;
//		QuickUnionUF uf = new QuickUnionUF(N);
//		java.util.Random random = new java.util.Random();
//		Stopwatch stopwatch = new Stopwatch();
//		for (int count = 0; count < N; count++) {
//			int i = random.nextInt(N);
//			int j = random.nextInt(N);
//			uf.union(i, j);
//			uf.connected(i, j);
//		}
//		System.out.println(stopwatch.elapsedTime());
	}
}
