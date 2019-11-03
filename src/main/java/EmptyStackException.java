class EmptyStackException extends RuntimeException {
    EmptyStackException() {
        super("The stack is empty.");
    }
}