/**
 * This class represents a library, which hold a collection of books.
 * Patrons can register at the library to be able to check out books,
 * if a copy of the requested book is available.
 */
class Library {

    /** The maximal number of books this library can hold. */
    final int maxBookCapacityVal;


    /** The maximal number of books this library allows
     * a single patron to borrow at the same time.
     */
    final int maxBorrowedBooksVal;

    /** The maximal number of registered patrons this library can handle. */
    final int maxPatronCapacityVal;

    /**Book array. */
    Book[] listOfBooks;

    /** Patron array */
    Patron[] listOfPatrons;





    /*----=  Constructors  =-----*/

    /**
     * Creates a new library with the given parameters.
     * @param maxBookCapacity - The maximal number of books this library can hold.
     * @param maxBorrowedBooks - The maximal number of books this library allows
     * a single patron to borrow at the same time.
     * @param maxPatronCapacity - The maximal number of registered patrons this library can handle.
     */
    Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity) {
        maxBookCapacityVal = maxBookCapacity;
        maxBorrowedBooksVal = maxBorrowedBooks;
        maxPatronCapacityVal = maxPatronCapacity;
        listOfBooks = new Book[maxBookCapacityVal];
        listOfPatrons = new Patron[maxPatronCapacityVal];
    }

    /*----=  Instance Methods  =-----*/

    /**
     * Adds the given book to this library, if there is place available, and it isn't already in the library.
     * @param book - The book to add to this library.
     * @return a non-negative id number for the book if there was a spot and the book was successfully added,
     * or if the book was already in the library; a negative number otherwise.
     */
    int addBookToLibrary(Book book){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (listOfBooks[maxBookCapacityVal-1] != null)
                    return -1; // if the library is full.
            if (listOfBooks[i] == book) // if book is already in the library.
                    return i; //if book is already in the library.
            if (listOfBooks[i] == null){

                listOfBooks[i] = book;
                        return i;}
        }
        return -7; // TODO fix this
    }

    /**
     * Returns true if the given number is an id of some book in the library, false otherwise.
     * @param bookId - The id to check.
     * @return true if the given number is an id of some book in the library, false otherwise.
     */
    boolean isBookIdValid(int bookId){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (getBookId(listOfBooks[i]) == bookId)
                    return true;
            else return false;
        }
        return false;
    }

    /**
     * Returns the non-negative id number of the given book if he is owned by this library, -1 otherwise.
     * @param book - The book for which to find the id number.
     * @return a non-negative id number of the given book if he is owned by this library, -1 otherwise.
     */
    int getBookId (Book book){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (listOfBooks[i] == book)
                    return i;
            else return -1;
        }
    }

    /**
     * Returns true if the book with the given id is available, false otherwise.
     * @param bookId - The id number of the book to check.
     * @return true if the book with the given id is available, false otherwise.
     */
    boolean isBookAvailable(int bookId){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (getBookId(listOfBooks[i]) == bookId && listOfBooks[i].currentBorrowerId == -1);
                    return true;
            return false;
        }
    }

    /**
     * Registers the given Patron to this library, if there is a spot available.
     * @param patron - The patron to register to this library.
     * @return a non-negative id number for the patron if there was a spot
     * and the patron was successfully registered or if the patron was already registered.
     * a negative number otherwise.
     */
    int registerPatronToLibrary(Patron patron){
        if (listOfPatrons[maxPatronCapacityVal-1] != null) //if there is no left place for patrons.
                return -1;
        for (int i=0; i < maxPatronCapacityVal; i++){
            if (listOfPatrons[i] == patron) // patron is already registered.
                    return i;
            else if (listOfPatrons[i] == null)
                    listOfPatrons[i] = patron; // registers patron lto library.
                            return i;
        }

    }

    /**
     * Returns true if the given number is an id of a patron in the library, false otherwise.
     * @param patronId - The id to check.
     * @return true if the given number is an id of a patron in the library, false otherwise.
     */
    boolean isPatronIdValid(int patronId){
        for (int i=0; i < maxPatronCapacityVal; i++){
            if (getPatronId(listOfPatrons[i]) == patronId)
                    return true;
            return false;
        }
    }

    /**
     * Returns the non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     * @param patron - The patron for which to find the id number.
     * @return a non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     */
    int getPatronId(Patron patron){
        for (int i=0; i < maxPatronCapacityVal; i++){
            if (listOfPatrons[i] == patron)
                    return i;
            else return -1;
        }
    }

    /**
     * counts how many books a specific borrower is currently borrowing.
     * @return a number sums up all books that are currently borrowed.
     */
    int currentlyBorrowing (int patronId){
        int counter = 0;
        for (int i=0; i < maxBookCapacityVal; i++){
            if (getPatronId(listOfPatrons[i]) == patronId)
                    counter += 1;
        }
        return counter;
    }

    /**
     * gets a book id and returns the book object.
     * @param bookId
     * @return patron
     */
    Book getBook (int bookId) {
        for (int i = 0; i < maxPatronCapacityVal; i++) {
            if (bookId == getBookId(listOfBooks[i]))
                return listOfBooks[i];
        }
    }

        /**
         * gets a patron id and returns the patron object.
         * @param patronId
         * @return patron
         */
    Patron getPatron (int patronId) {
        for (int i = 0; i < maxPatronCapacityVal; i++) {
            if (patronId == getPatronId(listOfPatrons[i]))
                return listOfPatrons[i];
        }
    }

    /**
     * Marks the book with the given id number as borrowed by the patron with the given patron id,
     * if this book is available, the given patron isn't already borrowing the maximal number of books allowed,
     * and if the patron will enjoy this book.
     * @param bookId - The id number of the book to borrow.
     * @param patronId - The id number of the patron that will borrow the book.
     * @return true if the book was borrowed successfully, false otherwise.
     */
    boolean borrowBook (int bookId, int patronId) {
        if (isBookAvailable(bookId) && listOfBooks[bookId].currentBorrowerId == -1
            && currentlyBorrowing(patronId) < maxPatronCapacityVal
            && listOfPatrons[patronId].willEnjoyBook(listOfBooks[bookId]))
            listOfBooks[bookId].setBorrowerId(patronId);
            return true;
        return false;
        //if (isBookAvailable(bookId) && currentlyBorrowing(patronId) < maxPatronCapacity && getPatron(patronId).willEnjoyBook())
           // getBook(bookId).setBorrowerId();
        //return true;
        //return false;
    }

    /**
     * Return the given book.
     * @param bookId - The id number of the book to return.
     */
    void returnBook(int bookId){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (getBookId(listOfBooks[i]) == bookId)
                listOfBooks[i].returnBook();
        }
    }

    /**
     * Suggest the patron with the given id the book he will enjoy the most,
     * out of all available books he will enjoy, if any such exist.
     * @param patronId - The id number of the patron to suggest the book to.
     * @return The available book the patron with the given ID will enjoy the most.
     * Null if no book is available.
     */
    Book suggestBookToPatron(int patronId){
        for (int i=0; i < maxBookCapacityVal; i++){
            if (listOfPatrons[patronId].getBookScore(listOfBooks[i]) >= listOfPatrons[patronId].getBookScore(listOfBooks[i+1])
                    && listOfPatrons[patronId].getBookScore(listOfBooks[i]) > listOfPatrons[patronId].enjoymentThreshold)
                    return listOfBooks[i];
            return null;
        }
    }
}