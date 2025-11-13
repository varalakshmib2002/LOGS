package logs;
import java.io.*;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Simple Multithreading Project...");

        // folder path
        Path folder = Paths.get("logs");

        // create 3 threads (one for each file)
        Thread t1 = new Thread(() -> processFile(folder.resolve("file1.txt")));
        Thread t2 = new Thread(() -> processFile(folder.resolve("file2.txt")));
        Thread t3 = new Thread(() -> processFile(folder.resolve("file3.txt")));

        // start threads
        t1.start();
        t2.start();
        t3.start();

        try {
            // wait for all threads to finish
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll files processed successfully!");
    }

    private static void processFile(Path path) {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while (br.readLine() != null) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() +
                    " processed " + path.getFileName() + " — Lines: " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + path.getFileName());
        }
    }
}
