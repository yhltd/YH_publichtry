package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Peizhi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 9:11
 */
@Mapper
@Repository
public interface PeizhiMapper extends BaseMapper<Peizhi> {
    //刷新
    @Select("select *from peizhi")
    List<Peizhi> getList();
//增
    @Insert("insert into peizhi(C,D,E) value (#{C},#{D},#{E})")
    boolean add(String C,String D,String E);
//删
    @Delete("delete from peizhi where id=#{id}")
    boolean delete (int id);
    //改
    @Update("update peizhi set C=#{C} ,D =#{D},E=#{E} where id =#{id}")
    boolean update(String C,String D,String E, int id);
    //查
    @Select("select * from peizhi where C like '%' +#{C}+'%' and D like '%'+#{D}+'%' and E like '%'+#{E}+'%'")
    List<Peizhi> queryList(String C,String D, String E);

}
