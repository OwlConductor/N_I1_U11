package h2;

public class H2_main {
    public static int[] fibonacciCache = new int[1000];

    public static void main(String[] args) {
        long bufferTime;
        int number = 40;

        bufferTime = System.nanoTime();
        long a = fibonacci(number);
        System.out.println("Fibonacci normal with " + number);
        System.out.println("time " + (System.nanoTime()-bufferTime) + "ns");
        System.out.println("number " + a);
        System.out.println();

        bufferTime = System.nanoTime();
        long b = fibonacciCached(number);
        System.out.println("Fibonacci cached with " + number);
        System.out.println("time " + (System.nanoTime()-bufferTime) + "ns");
        System.out.println("number " + b);
        System.out.println();

        bufferTime = System.nanoTime();
        long c = fibonacciIterativ(number);
        System.out.println("Fibonacci iterativ with " + number);
        System.out.println("time " + (System.nanoTime()-bufferTime) + "ns");
        System.out.println("number " + c);
        System.out.println();
    }

    public static int fibonacci(int n) {
        if(n<=0)
            return -1;
        
        if (n==1 || n==2)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacciCached(int n) {
        if(n<=0)
            return -1;
        if(n<fibonacciCache.length && fibonacciCache[n]!=0)
            return fibonacciCache[n];
        if (n==1 || n==2)
            return 1;
        else {
            fibonacciCache[n] = fibonacciCached(n-1) + fibonacciCached(n-2);
            return fibonacciCache[n];
        }
    }

    public static int fbonacciIterativ(int iterations) {
        if(iterations<=0)
            return -1;

        if(iterations<2)
            return iterations;

        int fibonacciStep1 = 0;
        int fibonacciStep2 = 1;
        int fibonacciBuffer = 0;

        for (int iteration = 2;iteration<=iterations;iteration++) {
            fibonacciBuffer = fibonacciStep1 + fibonacciStep2;
            fibonacciStep1 = fibonacciStep2;
            fibonacciStep2 = fibonacciBuffer;
        }
        return fibonacciStep2;
    }
}
