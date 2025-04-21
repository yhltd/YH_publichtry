package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Htjl;
import com.example.demo.mapper.HtjlMapper;
import com.example.demo.service.HtjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtjlImpl extends ServiceImpl<HtjlMapper, Htjl> implements HtjlService {
    @Autowired
    HtjlMapper htjlMapper;

    @Override
    public List<Htjl> getList() {
        return htjlMapper.getList();
    }

    @Override
    public List<Htjl> refresh() {
        return htjlMapper.refresh();
    }

    @Override
    public List<Htjl> month() {
        return htjlMapper.month();
    }

    @Override
    public List<Htjl> queryList(String ywdw, String gygczt) {
        return htjlMapper.queryList(ywdw,gygczt);
    }

    @Override
    public boolean update(Htjl htjl) { return updateById(htjl); }
@Override
public boolean jisuan(){
        return htjlMapper.jisuan();
}
    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }

    @Override
    public Htjl add(Htjl htjl) { return save(htjl) ? htjl : null; }
//    @Override
//    public List<Khzl> hqxlGsm() {return khzlMapper.hqxlGsm();}

}
