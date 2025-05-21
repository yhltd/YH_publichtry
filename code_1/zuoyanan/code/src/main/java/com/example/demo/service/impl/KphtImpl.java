package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Htjl;
import com.example.demo.mapper.KphtMapper;
import com.example.demo.service.KphtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KphtImpl extends ServiceImpl<KphtMapper, Htjl> implements KphtService {
    @Autowired
    KphtMapper kphtMapper;

    @Override
    public List<Htjl> getList() {
        return kphtMapper.getList();
    }

    @Override
    public List<Htjl> refresh() {
        return kphtMapper.refresh();
    }

    @Override
    public boolean update(Htjl htjl) { return updateById(htjl); }
    @Override
    public boolean szkp(Integer id){
        return kphtMapper.szkp(id);
    }
    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }

    @Override
    public Htjl add(Htjl htjl) { return save(htjl) ? htjl : null; }

}

