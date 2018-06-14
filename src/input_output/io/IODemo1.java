package input_output.io;

import java.io.*;

public class IODemo1 {

    static String inFileStr = "poza.jpg";
    static String outFileStr = "poza-out.jpg";

    public static void fileCopyNoBuffer() {
        System.out.println("\nInside fileCopyNoBuffer ...");

        long startTime, elapsedTime; // for speed benchmarking

        // Print file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is: " + fileIn.length() + " bytes");

        try (FileInputStream in = new FileInputStream(inFileStr);
             FileOutputStream out = new FileOutputStream(outFileStr)
        ) {
            startTime = System.nanoTime();
            int byteRead;
            // Read a raw byte, returns an int of 0 to 255
            while((byteRead = in.read()) != -1) {
                // Write the least-significat byte of int, drop the upper 3 bytes(24 biti)
                out.write(byteRead);
            }
            // The time that elapsed (total time - start time)
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " mseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Most common way to read byte streams from a file
    public static void fileCopyBufferWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream bIn = new BufferedInputStream(new FileInputStream(inFileStr));
            BufferedOutputStream bOut = new BufferedOutputStream(new FileOutputStream(outFileStr))
        ) {
            byte[] byteBuffer = new byte[4000];
            int numBytesRead;

            // bIn.read(byteBuffer)) -> Reads up to byte.length bytes of data from this input
            // stream into an array of bytes. This method blocks until some input is available.
            //This method simply performs the call read(b, 0, b.length) and returns the result.
            // It is important that it does not do in.read(b) instead; certain subclasses of FilterInputStream
            // depend on the implementation strategy actually used.
            while((numBytesRead = bIn.read(byteBuffer)) != -1) {
                bOut.write(byteBuffer, 0, numBytesRead);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("The Elapsed time is " + (elapsedTime / 1000000.0) + " msec");
    }

    public static void main(String[] args) {
        //fileCopyNoBuffer();
        fileCopyBufferWithBufferAndArray();
    }

}
