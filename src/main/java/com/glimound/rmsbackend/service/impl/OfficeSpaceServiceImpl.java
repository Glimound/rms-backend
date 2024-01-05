package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.OfficeSpaceDto;
import com.glimound.rmsbackend.mapper.OfficeSpaceMapper;
import com.glimound.rmsbackend.pojo.OfficeSpace;
import com.glimound.rmsbackend.service.OfficeSpaceService;
import com.glimound.rmsbackend.vo.OfficeSpaceListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeSpaceServiceImpl implements OfficeSpaceService {

    @Autowired
    private OfficeSpaceMapper officeSpaceMapper;

    /**
     * 分页查询所有办公场地的信息
     */
    @Override
    public OfficeSpaceListVo listOfficeSpace(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OfficeSpace> officeSpaceList = officeSpaceMapper.selectAll();
        Page<OfficeSpace> p = (Page<OfficeSpace>) officeSpaceList;
        return new OfficeSpaceListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询办公场地的信息及其所属的研究室
     */
    @Override
    public OfficeSpace getOfficeSpaceFullInfo(String siteId) {
        return officeSpaceMapper.selectById(siteId);
    }

    /**
     * 新增办公场地信息及其所属的研究室
     */
    @Override
    public void addOfficeSpaceFullInfo(OfficeSpaceDto officeSpaceDto) {
        officeSpaceMapper.insert(officeSpaceDto.getOfficeSpace());
    }

    /**
     * 更新办公场地信息及其所属的研究室
     */
    @Override
    public void updateOfficeSpaceFullInfo(String oldSiteId, OfficeSpaceDto officeSpaceDto) {
        officeSpaceMapper.update(oldSiteId, officeSpaceDto.getOfficeSpace());
    }

    /**
     * 删除办公场地信息
     */
    @Override
    public void deleteOfficeSpaceFullInfo(String siteId) {
        officeSpaceMapper.delete(siteId);
    }

    /**
     * 关键字搜索：返回所有OfficeSpace
     */
    @Override
    public List<OfficeSpace> getOfficeSpaceMatched(String str) {
        return officeSpaceMapper.selectOfficeSpaceMatched(str);
    }
}
