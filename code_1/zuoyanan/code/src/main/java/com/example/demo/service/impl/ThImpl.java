package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Th;
import com.example.demo.mapper.ThMapper;
import com.example.demo.service.ThService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 15:16
 */
@Service
public class ThImpl  extends ServiceImpl<ThMapper,Th> implements ThService {
    @Autowired
    ThMapper thMapper;
    @Override
    public List<Th> getList() {
        return thMapper.getList();
    }
    @Override
    public boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V,String W,String X){
    return thMapper.add(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X);}
    @Override
    public List<Th> queryList(String F) {
        return thMapper.queryList(F);
    }

}
