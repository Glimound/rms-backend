package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.QualityMonitorContact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface QualityMonitorContactMapper {

    @Insert("insert into quality_monitor_contact (name, office_phone, mobile_phone, email, quality_monitor_name) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email}, #{qualityMonitorName})")
    void insert(QualityMonitorContact qualityMonitorContact);

    @Delete("delete from quality_monitor_contact where contact_id = #{contactId}")
    void delete(Integer contactId);

    @Update("update quality_monitor_contact set name = #{q.name}, office_phone = #{q.officePhone}, mobile_phone = #{q.mobilePhone}, " +
            "email = #{q.email}, quality_monitor_name = #{q.qualityMonitorName} where contact_id = #{contactId}")
    void update(Integer contactId, QualityMonitorContact q);

    /**
     * 删除特定质量监测方的联系人
     * @param qualityMonitorName 指定质量监测方
     */
    @Delete("delete from quality_monitor_contact where quality_monitor_name = #{qualityMonitorName}")
    void clearQualityMonitorContacts(String qualityMonitorName);
}
