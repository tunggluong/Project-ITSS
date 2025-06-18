package server.model;

public class Room {
    private Integer roomId;

    private String roomName;

    private boolean active;

    public Room(Integer roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.active = true;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", active=" + active +
                '}';
    }
}
