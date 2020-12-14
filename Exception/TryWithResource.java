package algorithm.Exception;

public class TryWithResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("close");
    }
}
