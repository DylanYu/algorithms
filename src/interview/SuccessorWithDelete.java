package interview;

/**
 * Successor with delete. Given a set of N integers S={0,1,...,N−1} and 
 * a sequence of requests of the following form:
 *     Remove x from S
 *     Find the successor of x: the smallest y in S such that y≥x.
 * design a data type so that all operations (except construction) should 
 * take logarithmic time or better.
 * 
 * Solution:
 * Use weighted union find data structure (by height rather then size), add 
 * another array max[] to represent the largest element in a connected 
 * component for that root.
 * Each time we call successorWithDelete(x), connect x and x+1 (N-1 is the 
 * special case), and returns the largest element in the component which 
 * contains x.
 * 
 * @author Dongliang Yu
 * 
 */
public class SuccessorWithDelete {
	
	private int[] id;
	private int[] ht;
	private int[] max;
	private int count;
	
	public SuccessorWithDelete(int N) {
		id = new int[N];
		ht = new int[N];
		max = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			ht[i] = 0;
			max[i] = i;
		}
	}
	
	public int find(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (ht[i] == ht[j]) {
			id[j] = i;
			ht[i] += 1;
			if (max[i] < max[j])
				max[i] = max[j];
		}
		else if (ht[i] > ht[j]) {
			id[j] = i;
			if (max[i] < max[j])
				max[i] = max[j];
		}
		else {
			id[i] = j;
			if (max[j] < max[i])
				max[j] = max[i];
		}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int count() {
		return count;
	}
	
	public int successorWithDelete(int x) {
		if (x == id.length-1)
			return x;
		union(x, x+1);
		return max[find(x)];
	}
	
	public void show() {
		StringBuffer idStr = new StringBuffer();
		StringBuffer htStr = new StringBuffer();
		StringBuffer maxStr = new StringBuffer();
		for (int i = 0; i < id.length; i++) {
			idStr.append(id[i] + " ");
			htStr.append(ht[i] + " ");
			maxStr.append(max[find(i)] + " ");
		}
		System.out.println(idStr.toString() + "\n" + htStr.toString() 
				+ "\n" + maxStr.toString() + "\n");
	}
	
	public static void main(String[] args) {
		SuccessorWithDelete suc = new SuccessorWithDelete(10);
//		suc.union(2, 4);
//		suc.show();
//		suc.union(6, 8);
//		suc.show();
//		suc.union(1, 4);
//		suc.show();
//		suc.union(3, 9);
//		suc.show();
//		suc.union(2, 8);
//		suc.show();
		System.out.println(suc.successorWithDelete(0));
		System.out.println(suc.successorWithDelete(2));
		System.out.println(suc.successorWithDelete(2));
		System.out.println(suc.successorWithDelete(4));
		System.out.println(suc.successorWithDelete(5));
		System.out.println(suc.successorWithDelete(3));
		System.out.println(suc.successorWithDelete(2));
		System.out.println(suc.successorWithDelete(8));
		System.out.println(suc.successorWithDelete(9));
	}

}
