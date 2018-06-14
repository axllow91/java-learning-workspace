package character;

// Char
public class CharacterClass {
    public static void main(String[] args) {

        char charA = 'A';
        System.out.println(charA);

        // compiling - no error
        char charInt = 65;
        System.out.println(charInt);

        // compiling - no error
        char charUniCode1 = '\u0041';
        System.out.println(charUniCode1);

        // compiling - no error
        char charUnicode2 = 0x41;
        System.out.println(charUnicode2);

        // compiling - no error
        char charBinary = 0b01000001;
        System.out.println(charBinary);


    }
}
