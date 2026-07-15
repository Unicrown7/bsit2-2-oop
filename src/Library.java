import java.util.ArrayList;


public class Library {

    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();
    }


    public void addBook(Book book) {

        books.add(book);

        System.out.println(">> Book added successfully.");
    }



    public void listBooks() {

        System.out.println("\n--- Library Catalog ---");


        if (books.isEmpty()) {

            System.out.println("No books available.");

            return;
        }


        int number = 1;


        for (Book book : books) {

            System.out.println(number + ". " + book.describe());

            number++;
        }
    }



    public void borrowBook(String title) {


        for (Book book : books) {


            if (book.getTitle().equalsIgnoreCase(title)) {


                if (book.isBorrowed()) {

                    System.out.println(">> Book is already borrowed.");

                } else {

                    book.borrow();

                    System.out.println(
                            ">> You borrowed '" + title + "'."
                    );
                }


                return;
            }
        }


        System.out.println(">> Book not found.");
    }




    public void returnBook(String title) {


        for (Book book : books) {


            if (book.getTitle().equalsIgnoreCase(title)) {


                if (book.isBorrowed()) {

                    book.returnBook();

                    System.out.println(
                            ">> You returned '" + title + "'."
                    );

                } else {

                    System.out.println(">> Book is already available.");
                }


                return;
            }
        }


        System.out.println(">> Book not found.");
    }




    public void searchBook(String title) {


        for (Book book : books) {


            if (book.getTitle().equalsIgnoreCase(title)) {


                System.out.println(">> Book found.");
                System.out.println(book.describe());

                return;
            }
        }


        System.out.println(">> Book does not exist.");
    }
}