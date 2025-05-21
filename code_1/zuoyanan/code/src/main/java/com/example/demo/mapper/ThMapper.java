package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Th;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 15:02
 */
@Mapper
@Repository
public interface ThMapper extends BaseMapper<Th> {
    @Select("select * from tuihuo")
    List<Th> getList();
    @Insert("insert into tuihuo(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X) values(#{C},#{D},#{E},#{F},#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V},#{W},#{X})")
    boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V,String W,String X);
    @Select("select *from tuihuo where F like '%'+#{F}+'%'")
    List<Th>queryList(String F);

}
