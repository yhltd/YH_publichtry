package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.Htjl;

import com.example.demo.entity.Thjlcx;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ThjlMapper extends BaseMapper<Thjlcx> {
    @Select("select * from tuihuo")
    List<Thjlcx> getList();

    @Select("select * from tuihuo where G like '%'+#{hth}+'%' AND H like '%'+#{rwh}+'%' AND J like '%'+#{th}+'%' AND Q like '%'+#{thyy}+'%' AND E >= convert(date,#{qssj}) and E <= convert(date,#{jzsj})")
    List<Thjlcx> cx(String qssj, String jzsj, String hth, String rwh, String th, String thyy);

    //    刷新
    @Select("select * from tuihuo")
    List<Thjlcx> refresh();

    @Delete("delete from hetong_jilu where id=#{id}")
    boolean delete(int id);

}

