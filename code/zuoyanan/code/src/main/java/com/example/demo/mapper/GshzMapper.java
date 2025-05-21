package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.Gygc;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GshzMapper extends BaseMapper<Gygc> {
    //显示
    @Select("SELECT M,SUM(L) AS l FROM gongyi_guicheng WHERE N >= convert(date,#{qssj}) and N <= convert(date,#{jzsj}) group by M")
    List<Gygc> select(String qssj, String jzsj);

}
