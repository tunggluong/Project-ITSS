package server.model;

import java.sql.Timestamp;

public class FeedbackEmployee extends Feedback {

    private Integer employeeId;

    private String employeeName;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "FeedbackEmployee{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", memberName='" + memberName + '\'' +
                ", employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                ", active=" + active +
                '}';
    }
}
