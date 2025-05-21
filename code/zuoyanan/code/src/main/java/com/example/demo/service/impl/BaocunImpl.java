package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Baocun;

import com.example.demo.mapper.BaocunMapper;
import com.example.demo.service.BaocunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/8 9:08
 */
@Service
public class BaocunImpl extends ServiceImpl<BaocunMapper,Baocun> implements BaocunService {
@Autowired
    BaocunMapper baocunMapper;

    @Override
    public List<Baocun> getList() {
        return baocunMapper.getList();
    }
    @Override
    public boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V){
        return baocunMapper.add(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);
    }
@Override
    public List<Baocun> queryList(String D, String H, String I) {
        return baocunMapper.queryList(D, H, I);
    }
@Override
    public boolean update(Baocun baocun){return updateById(baocun);}
//    @Override
//    public     boolean update1(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V,Integer id){
//        return baocunMapper.update1(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,id);
//    }
    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }
}
