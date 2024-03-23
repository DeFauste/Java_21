package ex03;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloaderThreads {
    int curNF = 0;
    private String[] urls = null;
    private int cThread = 0;

    DownloaderThreads(String[] urls, int cThread) {
        this.urls = urls;
        this.cThread = cThread;
    }

    private synchronized int getIndexUrls() {
        return curNF++;
    }

    public void StartDownload() {
        for (int i = 0; i < cThread; i++) {
            Thread thread = new Thread(new Loader(i));
            thread.start();
        }

    }

    public void Download(String fileName) {
        String localName = fileName.substring(fileName.lastIndexOf("/")+1);
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileName.trim()).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(localName)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Loader implements Runnable {
        int nTh = 0;
        Loader(int nTh) {
            this.nTh = nTh;
        }
        @Override
        public void run() {
            while (urls.length != curNF) {
                String fileNumber = urls[getIndexUrls()];
                String[] element = fileNumber.split(" ",2);
                if (fileNumber != null) {
                    System.out.printf("Thread-%d start download file number %s\n", nTh, element[0]);
                    Download(element[1]);
                    System.out.printf("Thread-%d finish download file number %s\n", nTh, element[0]);

                }
            }
        }
    }
}
