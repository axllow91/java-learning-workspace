package strings;

public class StringManipulation {

    static void stringExamples() {
        System.out.println("\nInside stringExamples...");

        String s = "Hello world!";
        System.out.println("s: " + s);

        System.out.println("\ns.lenght(): " + s.length()); // 12
        System.out.println("s.isEmpty(): " + s.isEmpty()); // false

        // COMPARATIE
        // Compares this string to the specified object. The result is true if and only
        // if the argument is not null and is a String object that represents the same
        // sequence of characters as this object.
        System.out.println("\ns.equals(\"Hello World\"): + " + s.equals("Hello world!"));

        // Compares this String to another String, ignoring case considerations.
        // Two strings are considered equal ignoring case if they are of the same length
        // and corresponding characters in the two strings are equal ignoring case.
        System.out.println("s.equalsIngnoreCase(\"Hello World!\"): " + s.equalsIgnoreCase("HELLO WORLD!"));

        // Compares two strings lexicographically.
        // The comparison is based on the Unicode value of each character in the strings.
        // The character sequence represented by this String object is compared lexicographically
        // to the character sequence represented by the argument string. The result is a negative integer
        // if this String object lexicographically precedes the argument string.
        // The result is a positive integer if this String object lexicographically follows the argument string.
        // The result is zero if the strings are equal; compareTo returns 0 exactly when
        // the equals(Object) method would return true.
        System.out.println("s.compareTo(): " + s.compareTo("zELLO WORLD!"));


        // CAUTARE
        // Returns true if and only if this string contains the specified sequence of char values.
        System.out.println("\ns.contains(): " + s.contains("HELLO WORLD!")); // false - for true "Hello World!"
        System.out.println("s.contains(): " + s.contains("World!")); // false - for true "Hello World!"

        // Tests if this string starts with the specified suffix.
        System.out.println("s.startWith(): " + s.startsWith("Hello")); // true

        // Tests if this string ends with the specified suffix.
        System.out.println("s.endWith(): " + s.endsWith("!")); // true

        // Returns the index within this string of the first occurrence of the specified substring.
        System.out.println("s.indexOf(): " + s.indexOf("ld")); // 9 pos

        // Returns the index within this string of the last occurrence of the specified character.
        System.out.println("s.lastIndexOf(): " + s.lastIndexOf('o')); // 7 pos


        // Examining individual characters
        // Returns the char value at the specified index. An index ranges from 0 to length() - 1.
        // The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
        System.out.println("\ns.charAt(4): " + s.charAt(4));


        // EXTRACTING SUBSTRINGS
        System.out.println("s.substring(4): " + s.substring(4)); // "o world!"
        System.out.println("s.subtring(4, 9): " + s.substring(4, 9)); // starts at and ends at o wor

        // Converts all of the characters in this String to upper case using the rules of the default locale
        System.out.println("s.toUpperCase(): " + s.toUpperCase());

        // Converst all of the characters in this String to lower case using the rules of the default locale
        System.out.println("s.toLowerCase(): " + s.toLowerCase());

        // Returns a string whose value is this string, with any leading and trailing whitespace removed.
        // adica daca la inceputul sau la sfarsitul stringului exista spatii albe acestea vor fi eliminate
        //
        System.out.println("s.trim(): " + s.trim()); // "Helloworld!"

        // Replace
        System.out.println("s.replaceAll(): " + s.replaceAll("l", "o")); // Heooo worod
        System.out.println("s.replaceAll(): " + s.replaceAll("l", "ooooo")); // Heooooooo woroooood

        // SPLIT
        // Splits this string around matches of the given regular expression.
        System.out.println("s.split(): ");
        String[] sa = s.split("o"); //
        for(String temp : sa) {
            System.out.println(temp);
        }

        // Static method
        // Returns the string representation of the int/double argument
        System.out.println("String.valueOf(): " + String.valueOf(22));

    }

    static void stringPool() {
        System.out.println("\nInside stringPool...");

        String s1 = "hello!";
        String s2 = "hello!";
        String s3 = "hello"; // - double interning "hello" is already an intern
        String s4 = new String("hello!");
        final String s5 = "lo!";

        System.out.println("s1 == s2: " + (s1 == s2)); // true
        System.out.println("s1 == s3: " + (s1 == s3)); // false
        System.out.println("s1 == s4: " + (s1 == s4)); // false
        System.out.println("s1 == s4.intern(): " + (s1 == s4.intern())); // true
        System.out.println("s1 == \"hel\" \"lo!\": " + (s1 == "hel" + "lo!")); // true
        System.out.println("s1 == s5: " + (s1 == "hel" + s5)); // false - s5 is already an object in string pool
        // s5 is not recognize until the compile time will not be considered as a literal
        // but if we make s5 as a constant variable it will be considered as a literal

        String s6 = "lo!";
        System.out.println(s5 == s6); // true

        String s8 = new String("abcd");
        s8 = new String("1234");

        System.out.println(s8);

    }

    static void stringBuilder() {

        System.out.println("\nInside stringBuilder()...");

        // Constructs a string builder with no characters in it and an initial capacity of 16 characters.
        StringBuilder sb = new StringBuilder();

        String ss = sb.append("Good").append("morning").toString();
        System.out.println(ss);
        System.out.println(sb.length());
        System.out.println(sb.toString());

        System.out.println(sb.delete(1, 5)); // start deleting from 1 to 5 that means 2,4,5 deleted
        System.out.println(sb.insert(1, "oodm")); // add from 1 to where last the seq of this

    }

    public static void main(String[] args) {
        stringExamples();
        stringPool();
        stringBuilder();
    }
}
