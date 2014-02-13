package algs;

/**
 * 
 * @author Dongliang Yu
 * 
 */
public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * elapsed time in seconds
     */
    public double elapsedTime() {
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

}
