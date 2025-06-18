package server.model;

public class FeedbackRoom extends Feedback {

    private Integer roomId;

    private String roomName;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "FeedbackRoom{" +
                "feedbackId=" + feedbackId +
                ", memberAccount='" + memberAccount + '\'' +
                ", memberName='" + memberName + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                ", active=" + active +
                '}';
    }
}
