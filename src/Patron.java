/**
 * This class represents a library patron that has a name
 * and assigns values to different literary aspects of books.
 */
class Patron {

    /** Patron's first name. */
    final String firstName;

    /** Patron's last name. */
    final String lastName;

    /** The comic tendency of the patron. */
    int comicTendencyVal;

    /** The dramatic tendency of the patron. */
    int dramaticTendencyVal;

    /** The educational tendency of the patron. */
    int educationalTendencyVal;

    /** The parameter of enjoyment threshold. */
    int enjoymentThreshold;


    /*----= Constructiors =-----*/

    /**
     * Creates a new patron with the given characteristic.
     * @param patronFirstName first name of patron.
     * @param patronLastName last name of patron.
     * @param comicTendency patron's comic tendency.
     * @param dramaticTendency patron's dramatic tendency.
     * @param educationalTendency patron's educational tendency.
     * @param patronEnjoymentThreshold a parameter of enjoyment of the patron from a book.
     */
     Patron(String patronFirstName, String patronLastName, int comicTendency, int dramaticTendency,
            int educationalTendency, int patronEnjoymentThreshold){
         firstName = patronFirstName;
         lastName = patronLastName;
         comicTendencyVal = comicTendency;
         dramaticTendencyVal = dramaticTendency;
         educationalTendencyVal = educationalTendency;
         enjoymentThreshold = patronEnjoymentThreshold;
     }


    /*----=  Instance Methods  =-----*/

    /** Returns a string representation of the patron,
     * which is a sequence of its first and last name, separated by a single white space.
     * For example, if the patron's first name is "Ricky" and his last name is "Bobby",
     * this method will return the String "Ricky Bobby".
     * @return the String representation of this patron.
     */
    String stringRepresentation(){
        return firstName+" "+lastName;
    }


        /**
         * Returns the literary value this patron assigns to the given book.
         * @param book - The book to asses.
         * @return the literary value this patron assigns to the given book.
         */
    int getBookScore(Book book){
        int literaryValue = (book.comicValue * comicTendencyVal
                + book.dramaticValue * dramaticTendencyVal
                + book.educationalValue * educationalTendencyVal);
                return  literaryValue;
    }

    /**
     * Returns true of this patron will enjoy the given book, false otherwise.
     * @param book - The book to asses.
     * @return true of this patron will enjoy the given book, false otherwise.
     */
    boolean willEnjoyBook(Book book){
        if (getBookScore(book) > enjoymentThreshold)
            return true;
        return false;
    }}



