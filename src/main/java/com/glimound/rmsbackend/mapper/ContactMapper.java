package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Contact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ContactMapper {

    @Insert("insert into contact (name, office_phone, mobile_phone, email) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email})")
    void insert(Contact contact);

    @Delete("delete from contact where contact_id = #{contactId}")
    void delete(String contactId);

    @Update("update contact set contact_id = #{c.contactId}, name = #{c.name}, office_phone = #{c.officePhone}, " +
            "mobile_phone = #{c.mobilePhone}, email = #{c.email} where contact_id = #{oldContactId}")
    void update(String oldContactId, Contact c);
}
