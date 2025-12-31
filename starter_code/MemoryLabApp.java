import java.util.ArrayList;
import java.util.List;
public class MemoryLabApp {

    private static final int ONE_MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== JVM Memory Lab ===");
        printMemoryStatus("Initial");
        List<byte[]> memoryBlocks = new ArrayList<>();
        int allocationCount = 0;
        try {
            while (true) {
                memoryBlocks.add(new byte[ONE_MB]);
                allocationCount++;
                printMemoryStatus("After allocation " + allocationCount + " MB");
                Thread.sleep(500);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("\nYou are out of memory.");
            System.err.println("Allocated approximately " + allocationCount + " MB");
            printMemoryStatus("At OOM");
        }
        printMemoryStatus("Final");
    }

    private static void printMemoryStatus(String label) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory() / (1024 * 1024);
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        System.out.printf("[%s] Max: %d MB, Total: %d MB, Used: %d MB, Free: %d MB%n",
                label, maxMemory, totalMemory, usedMemory, freeMemory);
    }
}
