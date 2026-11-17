# Thí nghiệm Tìm Giá Trị CUTOFF Tối Ưu Cho Mergesort
* **Họ và tên:** Nguyễn Hoàng Linh
* **Mã SV:** 25021845

Đây là repository chứa mã nguồn, dữ liệu và báo cáo cho project thí nghiệm giữa kỳ môn **Cấu trúc dữ liệu và giải thuật**. Mục tiêu của project là cài đặt thuật toán Mergesort bám sát nội dung bài giảng và thực nghiệm đo đạc thời gian chạy để tìm ra ngưỡng `CUTOFF` (chuyển sang Insertion Sort) tối ưu nhất cho cấu hình máy tính hiện tại.

## 📂 Cấu trúc Repository

Dưới đây là danh sách và mô tả chi tiết các file có trong kho lưu trữ này:

### 📑 Báo cáo và Trực quan hóa
* **`Báo Cáo Kết Quả.pdf`**: **(File trình bày chính)** Báo cáo tổng hợp quá trình thí nghiệm, phương pháp thực hiện, kết quả đo đạc và phân tích tổng kết. File này được xuất trực tiếp từ Jupyter Notebook.
* **`cutoff_analysis.png`**: Biểu đồ trực quan hóa kết quả đo thời gian chạy của Mergesort theo các giá trị `CUTOFF` và kích thước mảng $N$ khác nhau.
* **`LogChatAI.pdf`**: Nhật ký (log) thảo luận với AI hỗ trợ trong quá trình viết script chạy thí nghiệm và phân tích lỗi, đáp ứng yêu cầu của đề bài.

### 💻 Mã nguồn và Phân tích (Notebook)
* **`result.ipynb`**: File Jupyter Notebook chứa toàn bộ mã nguồn Python cài đặt Mergesort (dịch chuẩn từ mã giả Java trong bài giảng), hàm sinh dữ liệu test, script đo đạc thời gian và logic vẽ biểu đồ.
* **`result.html`**: Phiên bản xuất ra HTML của file `result.ipynb`, giúp người xem có thể đọc trực tiếp code và kết quả hiển thị trên trình duyệt mà không cần cài đặt môi trường Jupyter.
* **`src/`**: Thư mục chứa các mã nguồn phụ trợ, bao gồm 
  - Insertion.java: Mã nguồn thuật toán sắp xếp Insertion Sort.
  - InsertionCutoff.java: Mã nguồn thuật toán sắp xếp Insertion Sort cho mảng con khi sử dụng với giá trị CUTOFF nhất định.
  - Merge.java: Mã nguồn thuật toán sắp xếp Merge Sort.
  - MergeCutoff.java: Mã nguồn thuật toán sắp xếp Merge Sort với tham số CUTOFF động
  - Experiment.java: Mã nguồn bộ sinh dữ liệu và Script chạy thí nghiệm

### 📊 Dữ liệu Thí nghiệm
* **`datasets.txt`**: Tập dữ liệu (bộ test) chứa các mảng số nguyên ngẫu nhiên với các kích thước $N$ khác nhau, được sử dụng làm đầu vào thống nhất để đảm bảo tính công bằng khi so sánh hiệu năng giữa các cấu hình `CUTOFF`.
* **`results.csv`**: File dữ liệu đầu ra dạng bảng (CSV), lưu trữ chi tiết kết quả đo thời gian chạy (tính bằng mili-giây) tương ứng với từng kích thước đầu vào $N$ và giá trị `CUTOFF`.
