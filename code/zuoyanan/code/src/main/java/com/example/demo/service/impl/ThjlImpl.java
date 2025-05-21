package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Thjlcx;
import com.example.demo.mapper.ThjlMapper;
import com.example.demo.service.ThjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThjlImpl extends ServiceImpl<ThjlMapper, Thjlcx> implements ThjlService {
    @Autowired
    ThjlMapper thjlMapper;

    @Override
    public List<Thjlcx> getList() {
        return thjlMapper.getList();
    }

    @Override
    public List<Thjlcx> refresh() {
        return thjlMapper.refresh();
    }

    @Override
    public List<Thjlcx> cx(String qssj, String jzsj, String hth, String rwh, String th, String thyy) {
        return thjlMapper.cx(qssj, jzsj,hth,rwh,th,thyy);
    }

    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }
}
