package algorithm.getMoney.getmoney4.borrowbook;

import java.util.List;

public class User implements Runnable {

    private int tag;
    private Library library;

    public User(int tag, Library library) {
        this.tag = tag;
        this.library = library;
    }

    @Override
    public void run() {
        List<Library.Book> books = library.randomGet();
        for(int i = 0;i<books.size();++i){
            library.borrow(books.get(i),tag);
        }
        System.out.println("thread "+tag+" over===================================================");
    }
}
