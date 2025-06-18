package server.mapper;

import server.model.Equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EquipmentMapper {

    // Query all devices
    List<Equipment> findAll();

    // delete device by id
    Boolean deleteByEquipmentId(Integer equipmentId);

    // add equipment
    Boolean insertEquipment(Equipment equipment);

    // Modify device information according to id
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    // Query devices by id
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    // Query the total number of devices
    Integer selectTotalCount();

}
