package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Thd;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 11:27
 */
@Service
public interface ThdService extends IService<Thd> {
    //刷新
    List<Thd> getList();
    //加一行
    void add(String C, String D, String E, String F);
    //清空数据-生成新单
    void delete();
    //减一行
    void delete1( Integer id);
//修改
    boolean update(String G,String H,String I,String J, String K, String L, String M, String N, String O, String P,String Q,String R,String S,Integer id);

}
