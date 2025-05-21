package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Htjl;
import com.example.demo.entity.Thjlcx;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThjlService extends IService<Thjlcx> {
    /**
     * 查询所有
     */
    List<Thjlcx> getList();
    //    刷新
    List<Thjlcx> refresh();
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
    List<Thjlcx> cx(String qssj, String jzsj, String hth, String rwh, String th, String thyy);
}
