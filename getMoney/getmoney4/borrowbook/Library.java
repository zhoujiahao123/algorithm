package algorithm.getMoney.getmoney4.borrowbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Library objects
 */
public class Library {
    private List<Book> books;
    private int stock;

    /**
     * Book objects in Library
     */
    class Book {
        private String title;

        public Book(int num) {
            title = "the " + num + " book";
        }

        @Override
        public String toString() {
            return title;
        }
    }

    /**
     * When initializing the library, generate N book objects
     */
    public Library(int N) {
        books = new ArrayList<Book>();
        for (int i = 1; i <= N; i++) {
            books.add(new Book(i));
        }
        stock = N;
    }

    //To realize random number
    private Random random = new Random(47);

    /**
     * Randomly select three books from the library
     *
     * @return
     */
    public List<Book> randomGet() {
        int a = random.nextInt(stock);
        int b = random.nextInt(stock);
        while (a == b) b = random.nextInt(stock);//You can't borrow the same book
        int c = random.nextInt(stock);
        while (a == c || b == c) c = random.nextInt(stock);
        List<Book> list = new ArrayList<>();
        list.add(books.get(a));
        list.add(books.get(b));
        list.add(books.get(c));
        return list;
    }

    /**
     * People submit requests for books to the library
     * Using synchronized implementation
     */
    public void borrow(Book book, int tag) {
        System.out.println("thread " + tag + " want " + book);
        synchronized (book) {
            System.out.println(" Library lend " + book + " to thread " + tag);
            try {
                TimeUnit.MILLISECONDS.sleep(100);//ƒ£ƒ‚ΩË È“ª∫¡√Î÷”
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread " + tag + " return " + book);
        }
    }

}
