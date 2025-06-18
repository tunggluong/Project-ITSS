package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.RoomMapper;
import server.model.Room;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public List<Room> findAll() {
        return roomMapper.findAll();
    }

    public Boolean deleteByRoomId(Integer roomId) {
        return roomMapper.deleteByRoomId(roomId);
    }

    public Boolean insertRoom(Room room) {
        return roomMapper.insertRoom(room);
    }

    public Boolean updateRoomByRoomId(Room room) {
        return roomMapper.updateRoomByRoomId(room);
    }

    public List<Room> selectByRoomId(Integer roomId) {
        return roomMapper.selectByRoomId(roomId);
    }

    public Integer selectTotalCount() {
        return roomMapper.selectTotalCount();
    }
}