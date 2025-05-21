package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Thd;
import com.example.demo.mapper.ThdMapper;
import com.example.demo.service.ThdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 11:33
 */
@Service
public class ThdImpl extends ServiceImpl<ThdMapper, Thd> implements  ThdService {
    @Autowired
    ThdMapper thdMapper;
    //刷新
    @Override
    public List<Thd> getList() {
        return thdMapper.getList();
    }
    //清空-生成新单
    @Override
    public void delete() { thdMapper.delete(); }
    //加一行
    @Override
    public void add(String C, String D, String E, String F)
    {thdMapper.add(C,D,E,F);}

    //减一行
    @Override
    public void delete1(Integer id)
    {
        thdMapper.delete1(id);
    }

    //修改
    @Override
    public boolean update(String G,String H,String I,String J, String K, String L, String M, String N, String O, String P,String Q,String R,String S,Integer id)
    { return thdMapper.update(G,H,I,J,K,L,M,N,O,P,Q,R,S,id);}

}
