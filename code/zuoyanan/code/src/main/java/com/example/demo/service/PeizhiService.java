package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Peizhi;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 9:20
 */
@Service
public interface PeizhiService extends IService<Peizhi> {
  //查询所有，刷新
    List<Peizhi> getList();
    //删除
    boolean delete(List<Integer> idList);
    //添加
    Peizhi add (Peizhi peizhi);
    //查询
    List<Peizhi> queryList(String C,String D, String E);
    //改
    boolean update(Peizhi peizhi);
}
