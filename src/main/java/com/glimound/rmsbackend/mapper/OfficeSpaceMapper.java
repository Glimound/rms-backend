package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.OfficeSpace;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OfficeSpaceMapper {

    @Select("select site_id, space_area, address, lab_name from office_space")
    List<OfficeSpace> selectAll();

    @Select("select site_id, space_area, address, lab_name from office_space where site_id = #{siteId}")
    OfficeSpace selectById(String siteId);

    @Insert("insert into office_space (site_id, space_area, address, lab_name) values " +
            "(#{siteId}, #{spaceArea}, #{address}, #{labName})")
    void insert(OfficeSpace officeSpace);

    @Delete("delete from office_space where site_id = #{siteId}")
    void delete(String siteId);

    @Update("update office_space set site_id = #{os.siteId}, space_area = #{os.spaceArea}, address = #{os.address}, " +
            "lab_name = #{os.labName} where site_id = #{oldSiteId}")
    void update(String oldSiteId, OfficeSpace os);
}
