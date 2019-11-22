public class NullArrayException extends RuntimeException{
    NullArrayException(){
        super("The given array can't be null.");
    }
}
