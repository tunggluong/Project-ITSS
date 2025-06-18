package server.model;

public class FeedbackEquipment extends Feedback {

    private Integer equipmentId;

    private String equipmentName;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public String toString() {
        return "FeedbackEquipment{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", memberName='" + memberName + '\'' +
                ", equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                ", active=" + active +
                '}';
    }
}
