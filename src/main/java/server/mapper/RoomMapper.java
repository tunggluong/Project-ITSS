package server.mapper;

import server.model.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<Room> findAll();

    // delete device by id
    Boolean deleteByRoomId(Integer roomId);

    // add room
    Boolean insertRoom(Room room);

    // Modify device information according to id
    Boolean updateRoomByRoomId(Room room);

    // Query devices by id
    List<Room> selectByRoomId(Integer roomId);

    // Query the total number of devices
    Integer selectTotalCount();
}
