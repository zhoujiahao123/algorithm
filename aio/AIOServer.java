package algorithm.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AIOServer {
    private final int port;

    public static void main(String[] args) {
        int port = 8000;
        new AIOServer(port);
    }
    public AIOServer(int port) {
        this.port = port;
        listen();
    }

    private void listen() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(group);
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("�����Ѿ������������˿ڣ�" + port);
            serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    System.out.println("IO�����ɹ�����ʼ��ȡ����");
                    try {
                        buffer.clear();
                        result.read(buffer).get();
                        buffer.flip();
                        result.write(buffer);
                        buffer.flip();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            result.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("IO�������");
                }
                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("IO����ʧ�ܣ�" + exc);
                }
            });
            try {
                TimeUnit.MILLISECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
