package nestedclasses;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.StringWriter;

// translate from one format to another format
public class DataTranslator {

    public static String getBookAsXml(int id, String title, double rating, int fbLikes, int tweetCount) {

        class Book {
            private int id;
            private String title;
            private double rating;
            private int fbLikesCount;
            private int tweetCount;

            public Book(int id, String title, double rating, int fbLikesCount, int tweetCount) {
                this.id = id;
                this.title = title;
                this.rating = rating;
                this.fbLikesCount = fbLikesCount;
                this.tweetCount = tweetCount;
            }
        }


        Book book = new Book(id, title, rating, fbLikes, tweetCount);

        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("book", Book.class);
        StringWriter writer = new StringWriter();
        xstream.marshal(book, new PrettyPrintWriter(writer));

        return writer.toString();
        //return xstream.toXML(writer);
    }

    public static void main(String[] args) {
        System.out.println(DataTranslator.getBookAsXml(2002, "Interface vs Abstract Class", 3.0, 500, 6));
    }
}
