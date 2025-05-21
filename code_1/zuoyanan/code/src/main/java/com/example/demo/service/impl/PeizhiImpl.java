package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Peizhi;
import com.example.demo.mapper.PeizhiMapper;
import com.example.demo.service.PeizhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 9:24
 */
@Service
public class PeizhiImpl extends ServiceImpl<PeizhiMapper, Peizhi>implements PeizhiService {
@Autowired
    PeizhiMapper peizhiMapper;
    @Override
    public List<Peizhi> getList(){return peizhiMapper.getList();}
    @Override
    public  boolean delete(List<Integer> idList){return removeByIds(idList);}
    @Override
    public  Peizhi add(Peizhi peizhi){return save(peizhi)? peizhi:null;}
    //查
    @Override
    public List<Peizhi>queryList(String C,String D,String E){return  peizhiMapper.queryList(C,D,E);}
//改
    @Override
    public boolean update(Peizhi peizhi){return  updateById(peizhi);}
}
