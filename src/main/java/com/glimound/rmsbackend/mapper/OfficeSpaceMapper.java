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

    /**
     * 将特定办公场地所属的研究室改为指定的研究室
     * @param labName 指定的研究室
     * @param siteIdList 需修改的办公场地的id
     */
    void updateOfficeSpacesLab(String labName, List<String> siteIdList);

    /**
     * 清除办公场地归属的特定研究室
     * @param labName 指定的研究室
     */
    @Update("update office_space set lab_name = null where lab_name = #{labName}")
    void clearOfficeSpacesLab(String labName);

    @Select("select site_id, space_area, address, lab_name from office_space where site_id like concat('%',#{str},'%')")
    List<OfficeSpace> selectOfficeSpaceMatched(String str);
}
