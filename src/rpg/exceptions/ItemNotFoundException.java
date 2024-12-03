package rpg.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
        super("Item not found");
    }
}
