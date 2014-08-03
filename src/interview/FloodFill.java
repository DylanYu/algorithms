package interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://en.wikipedia.org/wiki/Flood_fill
 * 
 * @author Dongliang Yu
 *
 */
public class FloodFill {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {this.x = x; this.y = y;}
    }
    
    public static void floodFillNonRecursion(int x, int y, int color, int[][] pic) {
        if (pic == null) return;
        if (!inbound(x, y, pic)) return; // not necessary but a good habit
        int color0 = pic[x][y];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        while (queue.size() > 0) {
            Point cur = queue.poll(); // pop
            int curX = cur.x;
            int curY = cur.y;
            if (!inbound(curX, curY, pic)) continue;
            if (pic[curX][curY] != color0) continue;
            pic[curX][curY] = color;
            queue.offer(new Point(curX-1, curY)); // add
            queue.offer(new Point(curX+1, curY));
            queue.offer(new Point(curX, curY-1));
            queue.offer(new Point(curX, curY+1));
        }
    }
    
    private static boolean inbound(int x, int y, int[][] pic) {
        return x >= 0 && x < pic.length && y >= 0 && y < pic[0].length;
    }
    
    public static void floodFill(int x, int y, int replaceColor, int[][] picture) {
        int targetColor = picture[x][y];
        fill(x, y, targetColor, replaceColor, picture);
    }
    
    // try to replace color0 with color1
    // delete the commented to allow oblique fill (which is not use in real life case)
    private static void fill(int x, int y, int color0, int color1, int[][] pic) {
        if (x < 0 || x > pic.length-1 || y < 0 || y > pic[0].length-1) return;
        if (pic[x][y] != color0) return;
        pic[x][y] = color1;
        //fill(x-1, y-1, color0, color1, pic);
        fill(x-1, y, color0, color1, pic);
        //fill(x-1, y+1, color0, color1, pic);
        fill(x, y-1, color0, color1, pic);
        fill(x, y+1, color0, color1, pic);
        //fill(x+1, y-1, color0, color1, pic);
        fill(x+1, y, color0, color1, pic);
        //fill(x+1, y+1, color0, color1, pic);
    }
    
    private static void show(int[][] pic) {
        for (int[] row : pic) {
            for (int e : row)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] pic = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };
        show(pic);
        System.out.println();
        //floodFill(2, 2, 3, pic);
        //floodFill(6, 6, 3, pic);
        floodFillNonRecursion(6, 6, 3, pic);
        show(pic);
    }
}
