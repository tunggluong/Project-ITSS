1. Sử dụng git để clone project về máy local
2. Cài đặt IDE cho việc lập trình Java (ví dụ: Eclipse hoặc Intellij)
3. Mở IDE lập trình lên
4. Import project vừa clone về máy vào trong không gian làm việc trên IDE
5. Cài đặt cơ sở dữ liệu MySQL cho máy local
6. Sau khi cài đặt MySQL, tiến hành cấu hình root user. Hãy ghi nhớ mật khẩu của root user
7. Sử dụng Script của Database của hệ thống ở file `gym_management_system.sql` để chạy trên máy local. (Mục đích là tạo cơ    sở dữ liệu cho hệ thống)
8. Vào file `\src\main\resources\application.yml` tiến hành cấu hình cho việc sử dụng database trên máy local của ứng dụng. Thiết lập bằng cách sửa password cho root ở file giống với password của root user trên máy local
9. Chạy file `/src/main/java/server/GymManagementSystemApplication.java` để chạy ứng dụng (*Với ứng dụng Spring Boot đã được nhúng Tomcat Server rồi, không cần cài đặt Tomcat server trên máy local*)
10. Mở trình duyệt, truy cập `localhost:8080` để xem kết quả