package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Shdp;
import com.example.demo.mapper.ShdpMapper;
import com.example.demo.service.ShdpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * @author hui
 * @date 2025/4/10 13:12
 */
@Service
public class ShdpImpl extends ServiceImpl<ShdpMapper, Shdp> implements ShdpService {
    @Autowired
    ShdpMapper shdpMapper;

    //刷新
    @Override
    public List<Shdp> getList() {
        return shdpMapper.getList();
    }
    @Override
    public void add1(String J, String K, String L, String M, String N, String O, String P) {
        shdpMapper.add1(J, K, L, M, N, O, P);
    }
    @Override
    public void add(String C, String D, String E, String F, String G, String H, String I, String Q, String R, String S, String T, String U, String V)
    {shdpMapper.add(C,D,E,F,G,H,I,Q,R,S,T,U,V);}

    @Override
    public void delete() {
        shdpMapper.delete();
    }
    @Override
    public boolean update(String J, String K, String L, String M, String N, String O, String P,Integer id)
    { return shdpMapper.update(J,K,L,M,N,O,P,id);}
    @Override
    public void delete1(Integer id)
    {
        shdpMapper.delete1(id);
    }
//    @Override
//    public String getC(int id) {
//        return shdpMapper.getC(id);
//    }
//
//    @Override
//    public String getD(int id) {
//        return shdpMapper.getD(id);
//    }
//
//    @Override
//    public String getE(int id) {
//        return shdpMapper.getE(id);
//    }
//
//    @Override
//    public String getF(int id) {
//        return shdpMapper.getF(id);
//    }
//
//    @Override
//    public String getG(int id) {
//        return shdpMapper.getG(id);
//    }
//
//    @Override
//    public String getH(int id) {
//        return shdpMapper.getH(id);
//    }
//
//    @Override
//    public String getI(int id) {
//        return shdpMapper.getI(id);
//    }
//    public String getQ(int id) {
//        return shdpMapper.getQ(id);
//    }
//    public String getR(int id) {
//        return shdpMapper.getR(id);
//    }
//    public String getS(int id) {
//        return shdpMapper.getS(id);
//    }
//    public String getT(int id) {
//        return shdpMapper.getT(id);
//    }
//    public String getU(int id) {
//        return shdpMapper.getU(id);
//    }
//    public String getV(int id) {
//        return shdpMapper.getV(id);
//    }
    //   删除


}
    //查询
//    @Override
//    public List<Shdp> queryList(String D, String H, String I) {
//        return shdpMapper.queryList(D, H, I);
//    }
//    public List<Shdp> queryList1(String D) {
//        return shdpMapper.queryList1(D);
//    }
    //    加一行

//    @Override
//    public Shdp add(Shdp gongyi_guicheng) {
//        return save(gongyi_guicheng) ? gongyi_guicheng : null;
//    }
//public void add2(String C, String D, String E, String F, String G, String H, String I, String J, String K ,String L,String M,String N,String O,String P, String Q, String R, String S, String T, String U, String V)
//{shdpMapper.add2(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);}
    //加一行





//
//
