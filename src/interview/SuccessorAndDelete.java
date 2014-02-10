package interview;

import java.util.Random;

/**
 * Successor and delete. Given a set of N integers S={0,1,...,N−1} and provide 
 * these functions:
 *     Remove some x from S
 *     Find the successor of some x: the smallest y in S such that y≥x.
 * design a data type so that all operations (except construction) should 
 * take CONSTANT time or better.
 * 
 * @author Dongliang Yu
 *
 */
public class SuccessorAndDelete {
	
	private int[] prev;
	private int[] next;
	private int N;
	
	public SuccessorAndDelete(int N) {
		this.N = N;
		prev = new int[N];
		next = new int[N];
		for (int i = 0; i < N; i++) {
			prev[i] = i-1;
			next[i] = i+1;
		}
		prev[0] = N-1;
		next[N-1] = 0;
	}
	
	public void delete(int x) {
		if (x < 0 || x >= N)
			throw new IndexOutOfBoundsException();
		if (next[x] == -1)
			return;
		next[prev[x]] = next[x];
		prev[next[x]] = prev[x];
		prev[x] = -1;
		next[x] = -1;
	}
	
	public int successor(int x) {
		if (x < 0 || x >= N)
			throw new IndexOutOfBoundsException();
		if (next[x] <= x)
			return -1;
		return next[x];
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		StringBuffer prevSB = new StringBuffer();
		StringBuffer nextSB = new StringBuffer();
		for (int i = 0; i < N; i++) {
			prevSB.append(prev[i]);
			nextSB.append(next[i]);
			if (next[i] == -1)
				continue;
			sb.append(i);
		}
		return sb.toString() + "\n" + prevSB.toString() + "\n" + nextSB.toString();
	}
	
	public static void main(String[] args) {
		int N = 5;
		SuccessorAndDelete suc = new SuccessorAndDelete(N);
		for (int i = 0; i < 15; i++) {
			Random random = new Random();
			int x = random.nextInt(N);
			System.out.println("delete " + x);
			suc.delete(x);
			System.out.println(suc);
			System.out.println();
		}
	}

}
