package algorithm.getMoney.getmoney4.borrowbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * ͼ��ݶ���
 */
public class Library {
    private List<Book> books;
    private int stock;

    /**
     * ͼ����е������
     */
    class Book {
        private String title;

        public Book(int num) {
            title = "��" + num + "����";
        }

        @Override
        public String toString() {
            return title;
        }
    }

    /**
     * ��ʼ��ͼ��ݵ�ʱ������N�������
     */
    public Library(int N) {
        books = new ArrayList<Book>();
        for (int i = 1; i <= N; i++) {
            books.add(new Book(i));
        }
        stock = N;
    }

    //����ʵ�������
    private Random random = new Random(47);

    /**
     * �����ͼ�����ѡȡ������
     *
     * @return
     */
    public List<Book> randomGet() {
        int a = random.nextInt(stock);
        int b = random.nextInt(stock);
        while (a == b) b = random.nextInt(stock);//����鲻����ͬһ��
        int c = random.nextInt(stock);
        while (a == c || b == c) c = random.nextInt(stock);
        List<Book> list = new ArrayList<>();
        list.add(books.get(a));
        list.add(books.get(b));
        list.add(books.get(c));
        return list;
    }

    /**
     * ������ͼ����ύ��������
     * ʹ��synchronizedʵ��
     */
    public void borrow(Book book, int tag) {
        System.out.println("�߳�" + tag + "��Ҫ" + book);
        synchronized (book) {
            System.out.println("ͼ��ݰ�" + book + "������߳�" + tag);
            try {
                TimeUnit.MILLISECONDS.sleep(100);//ģ�����һ������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("�߳�" + tag + "�黹��" + book);
        }
    }

}
