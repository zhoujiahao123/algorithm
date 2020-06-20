package algorithm.Queue.PriorityQueue;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char pri, int sec, String item) {
            primary = pri;
            secondary = sec;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return 1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) +
                    +secondary + item;
        }
    }

    public void add(char primary, int secondary, String item) {
        super.add(new ToDoItem(primary, secondary, item));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add('C', 4, "Empty trash");
        toDoList.add('A', 2, "Feed dog");
        toDoList.add('B', 7, "Feed bird");
        toDoList.add('C', 3, "Mow lawn");
        toDoList.add('A', 1, "Water lawn");
        toDoList.add('B', 1, "Feed cat");
        while (toDoList.peek() != null) {
            System.out.println(toDoList.remove());
        }
    }
}
