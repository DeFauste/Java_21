package ex00;

public class Program {
    public static void main(String[] args) {
        String fileKey = "src/ex00/signatures.txt";
        String fileWrite = "result.txt";
        ReaderTypeFile readerTypeFile = new ReaderTypeFile(fileKey,fileWrite);
        System.out.println(readerTypeFile.keyMap);
    }
}
