package algorithm.getMoney.getmoney4.borrowbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 图书馆对象
 */
public class Library {
    private List<Book> books;
    private int stock;

    /**
     * 图书馆中的书对象
     */
    class Book {
        private String title;

        public Book(int num) {
            title = "第" + num + "本书";
        }

        @Override
        public String toString() {
            return title;
        }
    }

    /**
     * 初始化图书馆的时候，生成N本书对象
     */
    public Library(int N) {
        books = new ArrayList<Book>();
        for (int i = 1; i <= N; i++) {
            books.add(new Book(i));
        }
        stock = N;
    }

    //用以实现随机数
    private Random random = new Random(47);

    /**
     * 随机从图书馆中选取三本书
     *
     * @return
     */
    public List<Book> randomGet() {
        int a = random.nextInt(stock);
        int b = random.nextInt(stock);
        while (a == b) b = random.nextInt(stock);//借的书不能是同一本
        int c = random.nextInt(stock);
        while (a == c || b == c) c = random.nextInt(stock);
        List<Book> list = new ArrayList<>();
        list.add(books.get(a));
        list.add(books.get(b));
        list.add(books.get(c));
        return list;
    }

    /**
     * 人们向图书馆提交借书请求
     * 使用synchronized实现
     */
    public void borrow(Book book, int tag) {
        System.out.println("线程" + tag + "想要" + book);
        synchronized (book) {
            System.out.println("图书馆把" + book + "借给了线程" + tag);
            try {
                TimeUnit.MILLISECONDS.sleep(100);//模拟借书一毫秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + tag + "归还了" + book);
        }
    }

}
