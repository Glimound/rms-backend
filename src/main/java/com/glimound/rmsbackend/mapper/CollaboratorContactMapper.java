package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.CollaboratorContact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CollaboratorContactMapper {

    @Insert("insert into collaborator_contact (name, office_phone, mobile_phone, email, collaborator_name) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email}, #{collaboratorName})")
    void insert(CollaboratorContact collaboratorContact);

    @Delete("delete from collaborator_contact where contact_id = #{contactId}")
    void delete(Integer contactId);

    /**
     * 不会修改id
     */
    @Update("update collaborator_contact set name = #{c.name}, office_phone = #{c.officePhone}, mobile_phone = #{c.mobilePhone}, " +
            "email = #{c.email}, collaborator_name = #{c.collaboratorName} where contact_id = #{contactId}")
    void update(Integer contactId, CollaboratorContact c);

    /**
     * 删除特定合作方的联系人
     * @param collaboratorName 指定合作方
     */
    @Delete("delete from collaborator_contact where collaborator_name = #{collaboratorName}")
    void clearCollaboratorContacts(String collaboratorName);
}
