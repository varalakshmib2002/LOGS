# Multithreading Log File Processor – Core Java

This project reads multiple text files from a folder called "logs" and processes them using multiple threads.  
Each file is handled by a separate thread, and the thread counts how many lines are inside that file.

## How it works
1. Create a folder named logs in your project.
2. Add files like file1.txt, file2.txt, file3.txt.
3. Each file is processed in parallel using Threads.
4. The program prints how many lines each file has.

## Example Output
Thread-0 processed file1.txt — Lines: 3
Thread-1 processed file2.txt — Lines: 3
Thread-2 processed file3.txt — Lines: 3

## Technologies Used
- Core Java
- Threads & Runnable
- File Handling (BufferedReader, Files)

