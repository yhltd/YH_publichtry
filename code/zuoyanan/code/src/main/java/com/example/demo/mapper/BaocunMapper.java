package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Baocun;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/8 9:03
 */
@Mapper
@Repository
public interface BaocunMapper extends BaseMapper<Baocun> {
    //用来刷新
    @Select("select * from baocun")
    List<Baocun> getList();
    @Insert("insert into baocun(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V) values(#{C},#{D},#{E},#{F},#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V})")
    boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V);
    //查询
    @Select("select * from baocun where D like '%'+#{D}+'%' and H like '%'+#{H}+'%' and I like '%'+#{I}+'%'")
    List<Baocun> queryList(String D, String H, String I);
    @Update("update baocun set C = #{C},D = #{D},E = #{E},F = #{F} ,G = #{G},H = #{H} ,I = #{I} ,J = #{J} ,K = #{K} ,L = #{L} ,M = #{M} ,N = #{N} ,O = #{O} ,P = #{P} ,Q = #{Q} ,R = #{R} ,S = #{S} ,T = #{T} ,U = #{U} ,V = #{V}   where id = #{id}")//修改名称，账号，密码，职位
    boolean update(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V,int id);
//    @Update("update1 baocun set C = #{C},D = #{D},E = #{E},F = #{F} ,G = #{G},H = #{H} ,I = #{I} ,J = #{J} ,K = #{K} ,L = #{L} ,M = #{M} ,N = #{N} ,O = #{O} ,P = #{P} ,Q = #{Q} ,R = #{R} ,S = #{S} ,T = #{T} ,U = #{U} ,V = #{V}   where id = #{id}")//修改名称，账号，密码，职位
//    boolean update1(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V,Integer id);

    @Delete("delete from baocun where id=#{id}")//删除序列号
    boolean delete(int id);
}
