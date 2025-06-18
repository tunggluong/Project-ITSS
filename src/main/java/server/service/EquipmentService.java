package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.mapper.EquipmentMapper;
import server.model.Equipment;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    public Boolean deleteByEquipmentId(Integer equipmentId) {
        return equipmentMapper.deleteByEquipmentId(equipmentId);
    }

    public Boolean insertEquipment(Equipment equipment) {
        return equipmentMapper.insertEquipment(equipment);
    }

    public Boolean updateEquipmentByEquipmentId(Equipment equipment) {
        return equipmentMapper.updateEquipmentByEquipmentId(equipment);
    }

    public List<Equipment> selectByEquipmentId(Integer equipmentId) {
        return equipmentMapper.selectByEquipmentId(equipmentId);
    }

    public Integer selectTotalCount() {
        return equipmentMapper.selectTotalCount();
    }
}