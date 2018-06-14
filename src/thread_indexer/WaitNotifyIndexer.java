package thread_indexer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

public class WaitNotifyIndexer {

    private Deque<Weblink> queue = new ArrayDeque<>();

    public static void main(String[] args) {

        WaitNotifyIndexer waitNotifyIndexer = new WaitNotifyIndexer();

        waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2000, "Taming Tiger, Part 2",
                "https://www.twitch.tv/dotatv247", "https://www.twitch.tv"));
        waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?",
                "https://www.youtube.com/results?search_query=true+sight+ti6+final", "https://www.youtube.com"));
        waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2002, "Interface vs Abstract Class",
                "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
        waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
        waitNotifyIndexer.go();
    }

    private void go() {
        while (queue.size() > 0) {
            Weblink weblink = queue.remove();
            Thread downloaderThread = new Thread(new Downloader(weblink));
            Thread indexerThread = new Thread(new Indexer(weblink));

            downloaderThread.start();
            indexerThread.start();
        }
    }

    public void add(Weblink link) {
        queue.add(link);
    }

    public Weblink createWeblink(long id, String title, String url, String host) {
        Weblink weblink = new Weblink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }

    private static class Weblink {
        private long id;
        private String title;
        private String url;
        private String host;

        private volatile String htmlPage;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    private static class Downloader implements Runnable {
        private Weblink weblink;

        public Downloader(Weblink weblink) {
            this.weblink = weblink;
        }

        public void run() {
            try {
                synchronized (weblink) {
                    String htmlPage = HttpConnect.download(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);

                    /* public final void notify():
                     * Wakes up a single thread that is waiting on this object's monitor.
                     * If any threads are waiting on this object, one of them is chosen to be awakened.
                     * The choice is arbitrary and occurs at the discretion of the implementation.
                     * A thread waits on an object's monitor by calling one of the wait methods.
                     *
                     * ##########################################################################
                     *
                     * public final void notifyAll():
                     * Wakes up all threads that are waiting on this object's monitor.
                     * A thread waits on an object's monitor by calling one of the wait methods.
                     *
                     * */
                    weblink.notifyAll(); // notifying
                }
                // lock released once whe are out of the synchronized block

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Indexer implements Runnable {
        private Weblink weblink;

        private Indexer(Weblink weblink) {
            this.weblink = weblink;
        }

        public void run() {


            synchronized (weblink) {
                String htmlPage = weblink.getHtmlPage();
                while (htmlPage == null) {
                    try {
                        /*
                        * Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.
                        * In other words, this method behaves exactly as if it simply performs the call wait(0).
                        * */
                        System.out.println(weblink.getId() + " not yet downloaded!");
                        weblink.wait(); // Waiting for the other thread - this thread is suspended
                        System.out.println(weblink.getId() + " awakened");
                        htmlPage = weblink.getHtmlPage();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                index(htmlPage);
            }

        }

        private void index(String text) {
            if (text != null) {
                System.out.println("\nIndexed: " + weblink.getId() + "\n");
            }
        }
    }
}

