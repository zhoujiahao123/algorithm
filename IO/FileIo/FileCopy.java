package algorithm.IO.FileIo;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void main(String[] args) {
        String source = "C:/Users/Jacob/Desktop/source.txt";
        String target = "C:/Users/Jacob/Desktop/target.txt";
        copyFileByStream(source, target);
        copyFileByChannel(source,target);
    }
    //基于流实现BIO
    public static void copyFileByStream(String pathSource, String pathTarget) {
        try (InputStream is = new FileInputStream(pathSource);
             OutputStream os = new FileOutputStream(pathTarget)
        ) {
            byte[] buffer = new byte[128];
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //基于通道实现NIO
    public static void copyFileByChannel(String pathSource, String targetSource) {
        try (FileChannel inputChannel = new FileInputStream(pathSource).getChannel();
             FileChannel outputChannel = new FileOutputStream(targetSource).getChannel()
        ) {
            for (long count = inputChannel.size(); count > 0; ) {
                long transferred = inputChannel.transferTo(inputChannel.position(),count,outputChannel);
                count -= transferred;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
