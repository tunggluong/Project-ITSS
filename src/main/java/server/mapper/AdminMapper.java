package server.mapper;

import server.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin selectByAccountAndPassword(Admin admin);

}
