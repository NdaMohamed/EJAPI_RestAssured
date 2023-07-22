package Tests;

public class BookData {

    private int bookId;

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(final int bookId) {
        this.bookId = bookId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    private String customerName;

    public BookData(final int bookId, final String customerName) {
        this.bookId = bookId;
        this.customerName = customerName;
    }
}
