package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Htjl;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KphtService extends IService<Htjl> {
    /**
     * 查询所有
     */
    List<Htjl> getList();
    //    刷新
    List<Htjl> refresh();
    //    /**
//     * 修改
//     */
    boolean update(Htjl Htjl);
//    //设置对账
//    boolean szdz(Integer id);
    //设置开票
    boolean szkp(Integer id);
    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(List<Integer> idList);

    /**
     * 添加
     */
    Htjl add(Htjl Htjl);
}