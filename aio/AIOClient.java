package algorithm.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AIOClient {
    private final AsynchronousSocketChannel client;

    public AIOClient() throws IOException {
        client = AsynchronousSocketChannel.open();
    }

    public static void main(String[] args) throws Exception {
        new AIOClient().connect("localhost",8000);
    }

    public void connect(String host, int port) throws Exception {
        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                try {
                    client.write(ByteBuffer.wrap("这是一条测试数据".getBytes())).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        client.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("IO操作完成" + result);
                System.out.println("获取反馈操作" + new String(byteBuffer.array()));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        TimeUnit.MILLISECONDS.sleep(Integer.MAX_VALUE);
    }
}
