package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Baocun;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/8 9:05
 */
@Service
public interface BaocunService extends IService<Baocun> {
    List<Baocun> getList();
    boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V);

    List<Baocun> queryList(String D, String H, String I);
//    boolean update1(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V,Integer id);
    boolean update(Baocun baocun);
    boolean delete(List<Integer> idList);
}
