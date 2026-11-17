
import java.util.Random;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class Experiment {

    // Sinh mảng dữ liệu Double ngẫu nhiên
    public static Integer[] generateRandomArray(int n) {
        Integer[] a = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(1000000);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] N_VALUES = {10000, 50000, 100000, 500000};
        int[] CUTOFFS = new int[21];
        for (int i = 0; i < CUTOFFS.length; i++) CUTOFFS[i] = i;
        int TRIALS = 5; // Số mảng ngẫu nhiên khác nhau cho mỗi N
        String csvFile = "results.csv";
        String dataFile = "datasets.txt";

        try (FileWriter csvWriter = new FileWriter(csvFile);
             FileWriter dataWriter = new FileWriter(dataFile)) {

            csvWriter.append("N,CUTOFF,Time_ms\n");

            for (int n : N_VALUES) {
                // Khởi tạo mảng 2 chiều lưu trữ TRIALS mảng dữ liệu khác nhau
                Integer[][] testSets = new Integer[TRIALS][n];

                dataWriter.append("--- N = " + n + " ---\n");

                for (int t = 0; t < TRIALS; t++) {
                    testSets[t] = generateRandomArray(n);

                    // Ghi mảng của trial hiện tại vào file chung
                    dataWriter.append("- Trial " + (t + 1) + " -\n");
                    dataWriter.append(n + "\n");
                    for (Integer val : testSets[t]) {
                        dataWriter.append(val.toString() + "\n");
                    }
                }
                //System.out.println("Đã ghi " + TRIALS + " bộ dữ liệu N=" + n + " vào file " + dataFile);

                // Chạy thử nghiệm các CUTOFF trên cùng một tập testSets
                for (int cutoff : CUTOFFS) {
                    long totalTime = 0;

                    for (int t = 0; t < TRIALS; t++) {
                        // Clone mảng từ bộ test tương ứng để tránh làm hỏng dữ liệu gốc
                        Integer[] dataToSort = Arrays.copyOf(testSets[t], n);

                        long startTime = System.nanoTime();
                        MergeCutoff.sort(dataToSort, cutoff);
                        long endTime = System.nanoTime();

                        totalTime += (endTime - startTime);
                    }

                    double avgTimeMs = (totalTime / (double) TRIALS) / 1_000_000.0;
                    csvWriter.append(String.format("%d,%d,%.3f\n", n, cutoff, avgTimeMs));
                    //System.out.printf("Processed N=%d, CUTOFF=%d: %.3f ms\n", n, cutoff, avgTimeMs);
                }
            }
            //System.out.println("Hoàn tất! Kết quả đo thời gian lưu tại: " + csvFile);
            //System.out.println("Toàn bộ dữ liệu test lưu tại: " + dataFile);
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi file: " + e.getMessage());
        }
    }
}