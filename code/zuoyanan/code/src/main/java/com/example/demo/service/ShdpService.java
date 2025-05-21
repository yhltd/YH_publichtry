package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Shdp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/4/10 11:17
 */
@Service
public interface ShdpService extends IService<Shdp> {
    //    刷新
    List<Shdp> getList();
    boolean update(String J, String K, String L, String M, String N, String O, String P,Integer id);
    void add1(String J, String K, String L, String M, String N, String O, String P);
    void add(String C, String D, String E, String F, String G, String H, String I,String Q, String R, String S, String T, String U, String V);
    void delete();
//    String getC(int id);
//
//    String getD(int id);
//
//    String getE(int id);
//
//    String getF(int id);
//
//    String getG(int id);
//
//    String getH(int id);
//
//    String getI(int id);
//    String getQ(int id);
//    String getR(int id);
//    String getS(int id);
//    String getT(int id);
//    String getU(int id);
//    String getV(int id);

    //根据合同记录的id号查询
//    List<Shdp> queryList1(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V);
//    List<Shdp> queryList1(@Param("id") Integer id);

//    //    查询
//    List<Shdp> queryList(String D, String H, String I);
//    List<Shdp> queryList1(String D);
    //   加一行
  //    Shdp add(Shdp gongyi_guicheng);
//    void add2(String C, String D, String E, String F, String G, String H, String I, String J,String K,String L,String M,String N,String O,String P,String Q, String R, String S, String T, String U, String V);

    //   保存
   //   删除
    void delete1( Integer id);


//
    }
