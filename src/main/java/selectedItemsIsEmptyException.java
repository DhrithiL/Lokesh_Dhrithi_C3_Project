public class selectedItemsIsEmptyException extends Throwable{
    public selectedItemsIsEmptyException(String selectedItems)
    {
        super(selectedItems);
    }
}
