package enums;

import static enums.Book.BookGenre.HORROR;

public abstract class Book {
    public enum BookGenre {
        BIOGRAPHY(12) {
            public boolean isKidFriendly(int age) {
                     return age >= minAgeToRead;
                }
        },
        HORROR(15) {
            public boolean isKidFriendly(int age) {
                return false;
            }
        },
        THRILLER(18) {
            public boolean isKidFriendly(int age) {
                return false;
            }

        }; // end of the constant enumeration


        // abstract method of isKidFriendly()
        public abstract boolean  isKidFriendly(int age);

        // enum can have static methods & instance methods



        protected int minAgeToRead;


        // enums can have private constructors
        // private because enum is not instantiable(public) and is not extendable(protected)
        // if is not specified the access modifier (private in this case) then by default is private!
        BookGenre(int minAgeToRead) {
            this.minAgeToRead = minAgeToRead;
        }

        public int getMinAgeToRead() {
            return minAgeToRead;
        }

        /*public boolean isKidFriendly(int age) {
            switch (this) {
                case BIOGRAPHY: return age >= minAgeToRead;
                case HORROR: return false;
                case THRILLER: return false;
            }

            // otherwise return false
            return false;
        }
*/
    }
    public static void main(String[] args) {

        /* values():
         * Returns an array containing the constants of this enum type, in the order they're declared.
         * This method may be used to iterate over the constants as follows:
         *  for(BookGenre c : BookGenre.values())
         *      System.out.println(c);
         * */
        for (BookGenre book : BookGenre.values()) {
            System.out.println("\nName: " + book); // invokes toString() method

            /*
             *  name():
             *  Returns the name of this enum constant, exactly as declared in its enum declaration.
             *  Most programmers should use the toString method in preference to this one,
             *  as the toString method may return a more user-friendly name.
             * */
            System.out.println(" -name(): " + book.name());

            /*
             * ordinal():
             * Returns the ordinal of this enumeration constant (its position in its enum declaration,
             * where the initial constant is assigned an ordinal of zero).
             * Most programmers will have no use for this method.
             * It is designed for use by sophisticated enum-based data structures, such as java.util.EnumSet and java.util.EnumMap.
             * */
            System.out.println(" -Ordinal: " + book.ordinal());


            /*
             * getDeclaringClass():
             * Returns the Class object corresponding to this enum constant's enum type.
             * Two enum constants e1 and e2 are of the same enum type if and only if e1.getDeclaringClass() == e2.getDeclaringClass().
             * (The value returned by this method may differ from the one returned by the Object.getClass method for enum constants with constant-specific class bodies.)
             * */
            System.out.println(" -Declaring Class: " + book.getDeclaringClass());

            /*
             * compareTo():
             * Compares this enum with the specified object for order.
             * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
             * Enum constants are only comparable to other enum constants of the same enum type.
             * The natural order implemented by this method is the order in which the constants are declared.
             * */
            System.out.println(" -compareTo(HORROR): " + book.compareTo(HORROR));

            /*
             * equals():
             * Returns true if the specified object is equal to this enum constant.
             * */

            System.out.println(" -equals(HORROR): " + book.equals(HORROR));

            // Get the minimum age to read a book
            System.out.println(" -minAgeToRead(): " + book.getMinAgeToRead());

            System.out.println(" -isKidFriendly(): " + book.isKidFriendly(25));

        }
    }
}