package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Gygc;
import com.example.demo.mapper.GshzMapper;
import com.example.demo.service.GshzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GshzImpl extends ServiceImpl<GshzMapper, Gygc> implements GshzService {
    @Autowired
    GshzMapper gshzMapper;

    @Override
    public List<Gygc> select(String qssj, String jzsj) {
        return gshzMapper.select(qssj, jzsj);
    }

}