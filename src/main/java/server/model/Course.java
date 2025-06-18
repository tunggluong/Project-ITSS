package server.model;

public class Course {

    private Integer courseId;
    private String courseName;
    private String courseBegin;
    private String courseTime;

    private Integer coachId;
    private String coachName;

    private Integer price;

    private String courseType;

    private String status;

    private boolean active;

    public Course() {

    }

    public Course(Integer courseId, String courseName, String courseBegin, String courseTime, Integer coachId, String coachName, Integer price, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseBegin = courseBegin;
        this.courseTime = courseTime;
        this.coachId = coachId;
        this.coachName = coachName;
        this.price = price;
        this.courseType = courseType;
        this.status = "waiting";
        this.active = true;
    }

    public Course(Integer courseId, String courseName, String courseBegin, String courseTime, Integer coachId, String coachName, Integer price, String courseType, String status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseBegin = courseBegin;
        this.courseTime = courseTime;
        this.coachId = coachId;
        this.coachName = coachName;
        this.price = price;
        this.courseType = courseType;
        this.status = status;
        this.active = true;
    }

    public Course(Integer courseId, String courseName, String courseBegin, String courseTime, Integer coachId, String coachName, Integer price, String courseType, String status, boolean active) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseBegin = courseBegin;
        this.courseTime = courseTime;
        this.coachId = coachId;
        this.coachName = coachName;
        this.price = price;
        this.courseType = courseType;
        this.status = status;
        this.active = active;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseBegin() {
        return courseBegin;
    }

    public void setCourseBegin(String courseBegin) {
        this.courseBegin = courseBegin;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseBegin='" + courseBegin + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", coachId=" + coachId +
                ", coachName='" + coachName + '\'' +
                ", price=" + price +
                ", courseType='" + courseType + '\'' +
                ", status='" + status + '\'' +
                ", active=" + active +
                '}';
    }
}
