import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private final List<T> stack = new ArrayList<>();

    void push(T item) {
        stack.add(item);
    }

    T pop() {
        if (stack.size() > 0) return stack.remove(stack.size() - 1);
        else throw new EmptyStackException();
    }

    boolean isEmpty() {
        return stack.size() == 0;
    }
}
