package exceptii;

import java.io.*;

public class TryWithResourcesDemo {

    static String inFileStr = "poza.jpg";
    static String outFileStr = "poza-out.jpg";


    public static void fileCopyWithArm() throws IOException {
        System.out.println("\nInside fileCopyWithArm ...");


        // Test t = new Test(); Test2 t2 = new Test2();
        try(Test t = new Test(); Test2 t2 = new Test2(); BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            byte[] byteBuf = new byte[4000];
            int numBytestRead;
            while((numBytestRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytestRead);
            }

            throw new IOException("Important Exception!!");
        }
    }

    public static void fileCopyWithoutArm() throws IOException {
        System.out.println("\nInside fileCopyWithoutArm ...");

        Test t = null;
        Test2 t2 = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            t = new Test();
            t2 = new Test2();
            in = new BufferedInputStream(new FileInputStream(inFileStr));
            out = new BufferedOutputStream(new FileOutputStream(outFileStr));

            byte[] byteBuf = new byte[4000];
            int numBytestRead;
            while((numBytestRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytestRead);
            }
        throw new IOException("Important Exception!!");
        } finally {
            if (t2 != null)
                t2.close();
            if(t != null)
                t.close();
            if(in != null)
                in.close();
            if(out != null)
                out.close();
        }
    }

    // Handles Exception Masking via Suppression
    public static void fileCopyWithoutArm2() throws IOException {
        System.out.println("\nInside fileCopyWithoutArm ...");

        Test t = null;
        Test2 t2 = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        IOException ioException = null;

        try {
            t = new Test();
            t2 = new Test2();
            in = new BufferedInputStream(new FileInputStream(inFileStr));
            out = new BufferedOutputStream(new FileOutputStream(outFileStr));

            byte[] byteBuf = new byte[4000];
            int numBytestRead;
            while ((numBytestRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytestRead);
            }
            throw new IOException("Important Exception!!");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(ioException != null){
                try{
                    if(t2 != null)
                        t2.close();
                } catch (IOException e) {
                    ioException.addSuppressed(e);
                }
            } else {
                try {
                    if(t != null)
                        t.close();
                } catch (IOException e) {
                    ioException.addSuppressed(e);
                }
            }

            if(ioException != null) {
                try {
                    if(in != null)
                        in.close();
                } catch (IOException e) {
                    ioException.addSuppressed(e);
                }
            } else {
                try {
                    if (out != null)
                        out.close();
                } catch (IOException e) {
                    ioException.addSuppressed(e);
                }
                throw ioException;
            }
        }
    }


    public static void main(String[] args) {
        try {
            fileCopyWithoutArm2();
        } catch (IOException e) {
            e.printStackTrace();


//            Throwable[] throwables = e.getSuppressed();
//            System.out.println(throwables[0].getMessage());
//            System.out.println(throwables[1].getMessage());

        }
    }
}

class Test implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception");
    }
}

class Test2 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception 2");
    }
}
