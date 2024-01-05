package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.OfficeSpaceDto;
import com.glimound.rmsbackend.pojo.OfficeSpace;
import com.glimound.rmsbackend.vo.OfficeSpaceListVo;

import java.util.List;

public interface OfficeSpaceService {
    /**
     * 分页查询所有办公场地的信息
     */
    OfficeSpaceListVo listOfficeSpace(Integer page, Integer pageSize);

    /**
     * 查询办公场地的信息及其所属的研究室
     */
    OfficeSpace getOfficeSpaceFullInfo(String siteId);

    /**
     * 新增办公场地信息及其所属的研究室
     */
    void addOfficeSpaceFullInfo(OfficeSpaceDto officeSpaceDto);

    /**
     * 更新办公场地信息及其所属的研究室
     */
    void updateOfficeSpaceFullInfo(String oldSiteId, OfficeSpaceDto officeSpaceDto);

    /**
     * 删除办公场地信息
     */
    void deleteOfficeSpaceFullInfo(String siteId);

    /**
     * 关键字搜索：返回所有OfficeSpace
     */
    List<OfficeSpace> getOfficeSpaceMatched(String str);
}
