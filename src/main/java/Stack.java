import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.size() > 0) return stack.remove(stack.size() - 1);
        else throw new EmptyStackException();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
