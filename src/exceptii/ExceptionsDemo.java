package exceptii;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        System.out.println("\nInside main ...");
        try {
            share();
            System.out.println("After invoking share ...");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("main: FileNotFoundExceptiuon");
        } finally {
            System.out.println("Inside main's finally ...");
        }
        System.out.println("\nEnd of main ...");
    }

    private static void share() throws FileNotFoundException {
        System.out.println("\nInside share ...");

        try {
            String response = HttpConnect.send(0, "hello", "http://www.goodsnips.com");
            System.out.println("After invoking send ...");
            APIParser.parseSendResponseCode(response, "hello", "http://www.goodsnips.com");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Share: fileNotFoundException ....");
            throw e;
        } catch (IOException e) {
            System.out.println("Connecting to a different server ...");
        } catch (APIFormaChangeException e) {
            //e.printStackTrace();

            e.getCause().printStackTrace();
        }
        finally {
            System.out.println("Inside share's finally ....");
        }

        System.out.println("\nEnd of share");
    }
}
