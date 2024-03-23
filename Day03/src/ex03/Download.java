package ex03;

import java.io.File;

public class Download {
    Download() {
        File file = new File("src/ex03/files_urls.txt");
        ReadUrlString readUrlString = new ReadUrlString(file);
        String[] urls = readUrlString.GetStringArrUrl();
        DownloaderThreads downloaderThreads = new DownloaderThreads(urls,3);
        downloaderThreads.StartDownload();
    }
}
