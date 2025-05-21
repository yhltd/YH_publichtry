package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Gygc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YggscxService extends IService<Gygc> {
    /**
     * 查询
     */
    List<Gygc> select(String qssj, String jzsj,String yuangong);
    /**
     * 汇总
     */
    List<Gygc>  jisuan(String qssj, String jzsj,String yuangong);

}