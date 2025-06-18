package server.model;

public class Equipment {

    private Integer equipmentId;
    private String equipmentName;
    private String equipmentStatus;
    private String equipmentMessage;

    private Integer roomId;

    private boolean active;

    public Equipment(Integer equipmentId, String equipmentName, String equipmentStatus, String equipmentMessage, Integer roomId) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentStatus = equipmentStatus;
        this.equipmentMessage = equipmentMessage;
        this.roomId = roomId;
        this.active = true;
    }

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

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentMessage() {
        return equipmentMessage;
    }

    public void setEquipmentMessage(String equipmentMessage) {
        this.equipmentMessage = equipmentMessage;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentStatus='" + equipmentStatus + '\'' +
                ", equipmentMessage='" + equipmentMessage + '\'' +
                ", roomId=" + roomId +
                ", active=" + active +
                '}';
    }
}
