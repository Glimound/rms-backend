package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.QualityMonitor;
import com.glimound.rmsbackend.vo.QualityMonitorVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QualityMonitorMapper {
    @Select("select quality_monitor_name, address, superintendent_id from quality_monitor")
    List<QualityMonitor> selectAll();

    /**
     * 查询单个质量监测方信息及其负责人、各联系人
     */
    QualityMonitorVo selectByName(String qualityMonitorName);

    @Insert("insert into quality_monitor (quality_monitor_name, address, superintendent_id) values " +
            "(#{qualityMonitorName}, #{address}, #{superintendentId})")
    void insert(QualityMonitor qualityMonitor);

    @Delete("delete from quality_monitor where quality_monitor_name = #{qualityMonitorName}")
    void delete(String qualityMonitorName);

    // 负责人创建之后，绑定的id就不可变动（直到删除）
    @Update("update quality_monitor set quality_monitor_name = #{q.qualityMonitorName}, address = #{q.address} " +
            "where quality_monitor_name = #{oldQualityMonitorName}")
    void update(String oldQualityMonitorName, QualityMonitor q);

    @Select("select superintendent_id from quality_monitor where quality_monitor_name = #{qualityMonitorName}")
    Integer selectSuperintendentIdByName(String qualityMonitorName);

    @Select("select quality_monitor_name, address, superintendent_id from quality_monitor where quality_monitor_name like concat('%',#{str},'%')")
    List<QualityMonitor> getQualityMonitorMatched(String str);
}
