package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.Gygc;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YggscxMapper extends BaseMapper<Gygc> {
    //显示
    @Select("SELECT J,K,L,M,N,O,P FROM gongyi_guicheng WHERE M = #{yuangong} AND N >= convert(date,#{qssj}) and N <= convert(date,#{jzsj})")
    List<Gygc> select(String qssj, String jzsj,String yuangong);

    @Select("SELECT SUM(convert(float,L)) AS L FROM gongyi_guicheng WHERE M = #{yuangong} AND N >= convert(date,#{qssj}) and N <= convert(date,#{jzsj})")
    List<Gygc> jisuan(String qssj, String jzsj,String yuangong);
}