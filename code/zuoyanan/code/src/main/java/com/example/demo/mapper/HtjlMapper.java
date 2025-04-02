package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.Htjl;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HtjlMapper extends BaseMapper<Htjl> {
    @Select("select * from hetong_jilu")
    List<Htjl> getList();

    @Select("select * from hetong_jilu where C like '%'+#{ywdw}+'%' and F like '%'+#{gygczt}+'%'")
    List<Htjl> queryList(String ywdw, String gygczt);


//    @Delete("delete from hetong_jilu where id=#{id}")
//   boolean delete(int id);

//    @Insert("insert into hetong_jilu(c,d,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,AA,AB,AC,AD,AE,AF,AG,AH,AI,AJ,AK,AL,AM,AN,AO,AP,AQ,AR,AS,AT,hetongZhuangtai,AU,AV,AW)" +  "values (#{C},#{D},#{rwh},#{gygczt},#{gx},#{mc},#{th},#{dw},#{sl},#{cz},#{xhj},#{zl},#{gj},#{djgy},#{hjje},#{xgs},#{xdj},#{cgs},#{cdj},#{qgs},#{qdj},#{zjwwgs},#{zjwwdj},#{wwgs},#{wwdj},#{tgs},#{tdj},#{ggs},#{gdj},#{mgs},#{mdj},#{skxgs},#{skxdj},#{lc},#{lcdj},#{dhh},#{dhhdj},#{zzs},#{zssdj},#{xl},#{skz},#{hcrq},#{ccrq},#{ddyqjh},#{hetong_zhuangtai},#{c},#{djy},#{bz})")
//    boolean add(String C,String D,String rwh,String gygczt,String gx,String mc,String th,String dw,String sl,String cz,String xhj,String zl,String gj,String djgy,String hjje,String xgs,String xdj,String cgs,String cdj,String qgs, String qdj,String zjwwgs,String zjwwdj,String wwgs,String wwdj,String tgs,String tdj,String ggs,String gdj,String mgs,String mdj,String skxgs,String skxdj,String lc,String lcdj,String dhh,String dhhdj,String zzs,String zzsdj,String xl,String skz,String hcrq,String ccrq,String ddyqjh,String hetong_zhuangtai,String c,String djy,String bz);
@Insert("insert into hetong_jilu(C,D) values(#{ywdw},#{hth})")
boolean add(String ywdw,String hth);

//
//    @Insert("insert into hetong_jilu(C,D)  values ('111111','22222')")
//    boolean add(@Param("ywdw")String ywdw,@Param("hth")String hth);


//    @Update("update hetong_jilu set C = #{ywdw},D= #{d},E= #{e},F= #{f},G= #{g},H= #{h},I= #{i},J= #{j},K= #{k},L= #{l},M= #{m},N= #{n},O= #{o},P= #{p},Q= #{q},R= #{r},S= #{s},T= #{t},U= #{u},V= #{v},W= #{w},X= #{x},Y= #{y},Z= #{z},AA= #{aa},AB= #{ab},AC= #{ac},AD= #{ad},AE= #{ae},AF= #{af},AG= #{ag},AH= #{ah},AI= #{ai},AJ= #{aj},AK= #{ak},AL= #{al},AM= #{am},AN= #{an},AO= #{ao},AP= #{ap},AQ= #{aq},AR= #{ar},AS= #{as},AT= #{at},hetong_zhuangtai= #{hetong_zhuangtai},AU= #{au},AV= #{av}")
//    boolean update(String ywdw,String hth,String rwh,String gygczt,String gx,String mc,String th,String dw,String sl,String cz,String xhj,String zl,String gj,String djgy,String hjje,String xgs,String xdj,String cgs,String cdj,String qgs, String qdj,String zjwwgs,String zjwwdj,String wwgs,String wwdj,String tgs,String tdj,String ggs,String gdj,String mgs,String mdj,String skxgs,String skxdj,String lc,String lcdj,String dhh,String dhhdj,String zzs,String zzsdj,String xl,String skz,String hcrq,String ccrq,String ddyqjh,String hetong_zhuangtai,String c,String djy,String bz);

    @Update("update hetong_jilu set C = #{ywdw}  where id = #{id}")
    boolean update(String ywdw,int id);
//
//        @Insert("insert into hetong_jilu(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,AA,AB,AC,AD,AE,AF,AG,AH,AI,AJ,AK,AL,AM,AN,AO,AP,AQ,AR,AS,AT,hetong_zhuangtai,AU,AV),values(#{ywdw},#{hth},#{rwh},#{gygczt}),#{gx},#{mc},#{th},#{dw},#{sl},#{cz},#{xhj},#{zl},#{gj},#{djgy},#{hjje},#{xgs},#{xdj},#{cgs},#{cdj},#{qgs},#{qdj},#{zjwwgs},#{zjwwdj},#{wwgs},#{wwdj},#{tgs},#{tdj},#{ggs},#{gdj},#{mgs},#{mdj},#{skxgs},#{skxdj},#{lc},#{lcdj},#{dhh},#{dhhdj},#{zzs},#{zssdj},#{xl},#{skz},#{hcrq},#{ccrq},#{ddyqjh},#{hetong_zhuangtai},#{c},#{djy},#{bz}")
//    boolean add(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V, String W,String X,String Y,String Z,String AA,String AB,String AC,String AD,String AE,String AF,String AG,String AH,String AI,String AJ,String AK,String AL,String AM,String AN,String AO,String AP,String AQ,String AR,String AS,String AT,String hetong_zhuangtai,String AU,String AV);

    //    @Update("update hetong_jilu set C = #{c},D= #{d},E= #{e},F= #{f},G= #{g},H= #{h},I= #{i},J= #{j},K= #{k},L= #{l},M= #{m},N= #{n},O= #{o},P= #{p},Q= #{q},R= #{r},S= #{s},T= #{t},U= #{u},V= #{v},W= #{w},X= #{x},Y= #{y},Z= #{z},AA= #{aa},AB= #{ab},AC= #{ac},AD= #{ad},AE= #{ae},AF= #{af},AG= #{ag},AH= #{ah},AI= #{ai},AJ= #{aj},AK= #{ak},AL= #{al},AM= #{am},AN= #{an},AO= #{ao},AP= #{ap},AQ= #{aq},AR= #{ar},AS= #{as},AT= #{at},hetong_zhuangtai= #{hetong_zhuangtai},AU= #{au},AV= #{av}")
//    boolean update(String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v, String w,String x,String y,String z,String aa,String ab,String ac,String ad,String ae,String af,String ag,String ah,String ai,String aj,String ak,String al,String am,String an,String ao,String ap,String aq,String ar,String as,String at,String hetong_zhuangtai,String au,String av);
















    //
//    @Insert("insert into kucun(riqi,mc,qcsl,qcdj,rksl,rkdj,rkzje,js,dj,zje,jcsl,jcdj,jczje,qczje) values(#{riqi},#{mc}, #{qcsl}, #{qcdj},#{rksl},#{rkdj},#{rkzje},#{js}, #{dj}, #{zje}, #{jcsl}, #{jcdj},#{jczje},#{qczje})")
//    boolean add1(String riqi,String mc,String qcsl,String qcdj,String rksl,String rkdj,String rkzje,String js,String dj,String zje,String jcsl,String jcdj,String jczje,String qczje);
//    @Select("select rk.riqi,rk.mc,rk.rksl,rk.rkdj,rk.zje,xsd.js,xsd.dj,xsd.je from ruku as rk,xiaoshoudan as xsd where rk.mc=xsd.mc")
//    List<Kc> getList1();
//    @Select("select mx.riqi,qc.qcsl,qc.qcdj,qc.qczje,mx.mc,mx.rksl,mx.rkdj,mx.zje,mx.dj,mx.js,mx.je,sum(cast(qc.qcsl as DECIMAL(10)))+(sum(cast(mx.rksl as DECIMAL(10)))) as jcsl,sum(cast(qc.qczje as DECIMAL(10)))+sum(cast(mx.zje as DECIMAL(10)))-sum(cast(mx.je as DECIMAL(10))) as jczje,cast((sum(cast(qc.qczje as DECIMAL(10)))+sum(cast(mx.zje as DECIMAL(10)))-sum(cast(mx.je as DECIMAL(10))))/(sum(cast(qc.qcsl as DECIMAL(10)))+(sum(cast(mx.rksl as DECIMAL(10)))))as DECIMAL(10,2)) as jcdj from mingxi as mx,qichu as qc where mx.mc=qc.spmc group by mx.riqi,qc.qcsl,qc.qcdj,qc.qczje,mx.mc,mx.rksl,mx.rkdj,mx.zje,mx.dj,mx.js,mx.je")
//    List<Kc> getList2();
}
//    @Insert("INSERT INTO hetong_jilu(ywdw, hth, rwh, gygczt, gx, mc, th, dw, sl, cz, xhj, zl, gj, djgy, hjje, xgs, xdj, cgs, cdj, qgs, qdj, zjwwgs, zjwwdj, wwgs, wwdj, tgs, tdj, ggs, gdj, mgs, mdj, skxgs, skxdj, lc, lcdj, dhh, dhhdj, zzs, zzsdj, xl, skz, hcrq, ccrq, ddyqjh, hetong_zhuangtai, c, djy, bz) " +
//            "VALUES(#{ywdw}, #{hth}, #{rwh}, #{gygczt}, #{gx}, #{mc}, #{th}, #{dw}, #{sl}, #{cz}, #{xhj}, #{zl}, #{gj}, #{djgy}, #{hjje}, #{xgs}, #{xdj}, #{cgs}, #{cdj}, #{qgs}, #{qdj}, #{zjwwgs}, #{zjwwdj}, #{wwgs}, #{wwdj}, #{tgs}, #{tdj}, #{ggs}, #{gdj}, #{mgs}, #{mdj}, #{skxgs}, #{skxdj}, #{lc}, #{lcdj}, #{dhh}, #{dhhdj}, #{zzs}, #{zzsdj}, #{xl}, #{skz}, #{hcrq}, #{ccrq}, #{ddyqjh}, #{hetong_zhuangtai}, #{c}, #{djy}, #{bz})")
//    boolean add(Map<String, Object> addInfo);