package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Shdp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringTokenizer;

/**
 * @author hui
 * @date 2025/4/10 9:51
 */
@Mapper
@Repository
public interface ShdpMapper extends BaseMapper<Shdp> {
    //用来刷新
    @Select("select * from gongyi_guicheng")
    List<Shdp> getList();

    @Insert("insert into gongyi_guicheng(J,K,L,M,N,O,P)" +
            " values(#{J},#{K},#{L},#{M},#{N},#{O},#{P})")
    void add1(String J, String K, String L, String M, String N, String O, String P );

    @Delete("delete from gongyi_guicheng")
    void delete();
    @Insert("insert into gongyi_guicheng(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V) values(#{C},#{D},#{E},#{F},#{G},#{H},#{I},NULL,NULL,NULL,NULL,NULL,NULL,NULL,#{Q},#{R},#{S},#{T},#{U},#{V})")
    void add(String C, String D, String E, String F, String G, String H, String I, String Q, String R, String S, String T, String U, String V);
    @Update("update gongyi_guicheng set J = #{J},K = #{K},L = #{L},M = #{M},N = #{N},O = #{O},P = #{P} where id=#{id}")
    boolean update(String J, String K, String L, String M, String N, String O, String P,Integer id);
    //删除
    @Delete("delete from gongyi_guicheng where id=#{id}")
    void delete1(Integer id);


    //    @Select("select C from gongyi_guicheng where id=#{id}")
//    String getC(int id);
//
//    @Select("select D from gongyi_guicheng where id=#{id}")
//    String getD(int id);
//
//    @Select("select E from gongyi_guicheng where id=#{id}")
//    String getE(int id);
//
//    @Select("select F from gongyi_guicheng where id=#{id}")
//    String getF(int id);
//
//    @Select("select G from gongyi_guicheng where id=#{id}")
//    String getG(int id);
//
//    @Select("select H from gongyi_guicheng where id=#{id}")
//    String getH(int id);
//
//    @Select("select I from gongyi_guicheng where id=#{id}")
//    String getI(int id);
//    @Select("select Q from gongyi_guicheng where id=#{id}")
//    String getQ(int id);
//
//    @Select("select R from gongyi_guicheng where id=#{id}")
//    String getR(int id);
//
//    @Select("select S from gongyi_guicheng where id=#{id}")
//    String getS(int id);
//
//    @Select("select T from gongyi_guicheng where id=#{id}")
//    String getT(int id);
//
//    @Select("select U from gongyi_guicheng where id=#{id}")
//    String getU(int id);
//    @Select("select V from gongyi_guicheng where id=#{id}")
//    String getV(int id);


    //保存
//    @Insert("insert into gongyi_guicheng(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V) values(#{C},#{D},#{E},#{F},#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V})")
//    void add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V);

  //    @Insert("insert into gongyi_guicheng(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V) values(#{C},#{D},#{E},#{F},#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V})")
//    void add2(String C, String D, String E, String F, String G, String H, String I, String J,String K,String L,String M,String N,String O,String P,String Q, String R, String S, String T, String U, String V);

//    //查询
//    @Select("select * from gongyi_guicheng where D like '%'+#{D}+'%' and H like '%'+#{H}+'%' and I like '%'+#{I}+'%'")
////查名字
//    List<Shdp> queryList(String D, String H, String I);


//    @Select("SELECT * FROM gongyi_guicheng where D like '%'+#{D}+'%'")
////查号和公司名
//    List<Shdp> queryList1(String D);
//加一行

//




//    //根据合同记录的id号查询
//    @Select("select C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V from gongyi_guicheng where id =#{id}")
//    List<Shdp> queryList1(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V);
////    List<Shdp> queryList1(@Param("id") Integer id);
}