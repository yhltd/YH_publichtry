package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Thd;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 11:17
 */
@Mapper
@Repository
public interface ThdMapper extends BaseMapper<Thd> {

    //刷新
    @Select("select *from tuihuodan")
    List<Thd> getList();
    //生成新单--删除全部清空数据库
    @Delete("delete from tuihuodan")
    void  delete();
    //加一行
    @Insert("insert into tuihuodan (C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S) values(#{C},#{D},#{E},#{F},NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)")
    void add(String C, String D, String E, String F);
    //减一行
    @Delete("delete from tuihuodan where id=#{id}")//删除序列号
    void delete1(Integer id);

    //修改  改text表格上文本
    @Update("update tuihuodan set  G = #{G},H = #{H},I = #{I},J = #{J},K = #{K},L = #{L},M = #{M},N = #{N},O = #{O},P = #{P},Q = #{Q},R = #{R},S = #{S} where id=#{id}")
    boolean update(String G,String H,String I,String J, String K, String L, String M, String N, String O, String P,String Q,String R,String S,Integer id);

}