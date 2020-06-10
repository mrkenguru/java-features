package threadlocal;

public class RequestContextHolder
{
    private static final ThreadLocal<RequestContext> threadLocal = ThreadLocal.withInitial(
            () -> new RequestContext("requestId#" + Thread.currentThread().getName()));

    public static RequestContext getContext()
    {
        return threadLocal.get();
    }
}
