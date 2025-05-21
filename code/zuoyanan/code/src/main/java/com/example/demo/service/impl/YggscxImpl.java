package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Gygc;
import com.example.demo.mapper.YggscxMapper;
import com.example.demo.service.YggscxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YggscxImpl extends ServiceImpl<YggscxMapper, Gygc> implements YggscxService {
    @Autowired
    YggscxMapper yggscxMapper;

    @Override
    public List<Gygc> select(String qssj, String jzsj,String yuangong) {
        return yggscxMapper.select(qssj, jzsj,yuangong);
    }

    public  List<Gygc>  jisuan(String qssj, String jzsj,String yuangong){ return  yggscxMapper.jisuan(qssj, jzsj,yuangong);}

}
