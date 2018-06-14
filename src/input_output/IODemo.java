package input_output;

import java.io.*;
import java.util.Arrays;

public class IODemo {

    // By convention, static nested classes should be placed before static methods
    public static class SerializableDemo implements Serializable {
        private static final long serialVersionUID = -7352950466881431372L;

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private transient int id = 4;

        public int getId() {
            return id;
        }

        private String gender;

    }

    // for deserialization we use ObjectOutputStream, BufferedOutputStream, FileOutputStream
    private void doSerialization() {
        System.out.println("\nInside doSerialization() ...");

        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.setName("Java");
        System.out.println("name (before serialization): " + serializableDemo.getName());
        System.out.println("id (before serialization): " + serializableDemo.getId());

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serial.ser")))) {
            out.writeObject(serializableDemo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for deserialization we use ObjectInputStream, BufferedInputStream, FileInputStream
    private void doDeserialization() {
        System.out.println("\nInside doDeserialization() ...");

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial.ser")))) {
            SerializableDemo serializableObj = (SerializableDemo) in.readObject();
            System.out.println("name (after serialization): " + serializableObj.getName());
            System.out.println("id (after serialization): " + serializableObj.getId());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void applyEncoding() {
        System.out.println("\nInside applyEncoding ...");
        System.out.println("Default character encoding: " + System.getProperty("file.english"));

        printEncodingDetails("a");
        printEncodingDetails("€");
        printEncodingDetails("\u1F602"); // Non-BMP Unicode Code point (emoji smile face)
    }

    private static void printEncodingDetails(String symbol) {
        System.out.println("\nSymbol: " + symbol);
        try {
            System.out.println("ASCII: " + Arrays.toString(symbol.getBytes("US-ASCII")));
            System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes("ISO-8859-1")));
            System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes("UTF-8")));
            System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes("UTF-16")));
            System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes("UTF-16BE")));
            System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes("UTF-16LE")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void encodingSync() {
//        try(BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream("encoding"), "UTF-8")))) {
////            System.out.println(br.readLine());
////        } catch (UnsupportedEncodingException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }

        try {
            //System.out.println(new String("€".getBytes("UTF-8"), "UTF-8"));
            System.out.println(new String("a".getBytes("US-ASCII"), "UTF-16BE"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        //applyEncoding();

        // Serialization
//        if(args.length > 0 && args[0].equals("true")) {
//            new IODemo().doSerialization();
//        }
//
//        new IODemo().doDeserialization();

        encodingSync();
    }
}
