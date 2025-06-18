package server.controller.admin;

import server.model.Equipment;
import server.model.Room;
import server.service.EquipmentService;
import server.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private RoomService roomService;

    // Query equipment
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model) {
        List<Equipment> equipmentList = equipmentService.findAll();
        model.addAttribute("equipmentList", equipmentList);
        return "admin/selectEquipment";
    }

    // Delete device
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    // Jump to modify equipment page
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);

        List<Room> roomList = roomService.findAll();
        model.addAttribute("roomList", roomList);
        return "admin/updateEquipment";
    }

    // Modify equipment
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    // Jump to the new equipment page
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment(Model model) {
        List<Room> roomList = roomService.findAll();
        model.addAttribute("roomList", roomList);

        return "admin/addEquipment";
    }

    // Add new equipment
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        equipmentService.insertEquipment(equipment);
        return "redirect:selEquipment";
    }

}
