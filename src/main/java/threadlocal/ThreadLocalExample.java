package threadlocal;

import java.util.stream.IntStream;

public class ThreadLocalExample
{
    public static void main(String[] args)
    {
        IntStream.rangeClosed(1, 10)
                 .parallel()
                 .forEach(x -> System.out.println(x + " --> " + RequestContextHolder.getContext().requestId()));
    }
}
