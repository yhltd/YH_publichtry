package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Htjl;
import com.example.demo.mapper.YwchtMapper;
import com.example.demo.service.YwchtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YwchtImpl extends ServiceImpl<YwchtMapper, Htjl> implements YwchtService {
    @Autowired
    YwchtMapper ywchtMapper;

    @Override
    public List<Htjl> getList() {
        return ywchtMapper.getList();
    }

    @Override
    public List<Htjl> refresh() {
        return ywchtMapper.refresh();
    }

    @Override
    public boolean update(Htjl htjl) { return updateById(htjl); }
    @Override
    public boolean szdz(Integer id){

        return ywchtMapper.szdz(id);
    }
    @Override
    public boolean szkp(Integer id){
        return ywchtMapper.szkp(id);
    }
    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }

    @Override
    public Htjl add(Htjl htjl) { return save(htjl) ? htjl : null; }

}
