package server.controller.admin;

import server.model.Room;
import server.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/selRoom")
    public String selectRoom(Model model) {
        List<Room> roomList = roomService.findAll();
        model.addAttribute("roomList", roomList);
        return "admin/selectRoom";
    }

    @RequestMapping("/delRoom")
    public String deleteRoom(Integer roomId) {
        roomService.deleteByRoomId(roomId);
        return "redirect:selRoom";
    }

    // Jump to modify room page
    @RequestMapping("/toUpdateRoom")
    public String toUpdateRoom(Integer roomId, Model model) {
        List<Room> roomList = roomService.selectByRoomId(roomId);
        model.addAttribute("roomList", roomList);
        return "admin/updateRoom";
    }

    // Modify room
    @RequestMapping("/updateRoom")
    public String updateRoom(Room room) {
        roomService.updateRoomByRoomId(room);
        return "redirect:selRoom";
    }

    // Jump to the new room page
    @RequestMapping("/toAddRoom")
    public String toAddRoom() {
        return "admin/addRoom";
    }

    // Add new room
    @RequestMapping("/addRoom")
    public String addRoom(Room room) {
        roomService.insertRoom(room);
        return "redirect:selRoom";
    }
}
