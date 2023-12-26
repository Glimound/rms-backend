package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ClientContact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClientContactMapper {

    @Insert("insert into client_contact (name, office_phone, mobile_phone, email, client_name) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email}, #{clientName})")
    void insert(ClientContact clientContact);

    @Delete("delete from client_contact where contact_id = #{contactId}")
    void delete(Integer contactId);

    /**
     * 不会修改id
     */
    @Update("update client_contact set name = #{c.name}, office_phone = #{c.officePhone}, " +
            "mobile_phone = #{c.mobilePhone}, email = #{c.email}, client_name = #{c.clientName} where contact_id = #{contactId}")
    void update(Integer contactId, ClientContact c);

    /**
     * 删除特定委托方的联系人
     * @param clientName 指定委托方
     */
    @Delete("delete from client_contact where client_name = #{clientName}")
    void clearClientContacts(String clientName);
}
