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
//    刷新
    @Select("SELECT * " +
            "FROM hetong_jilu " +
            "LEFT JOIN ( " +
            "    SELECT " +
            "        C AS left_id, " +
            "        CASE " +
            "            WHEN renwu > renyuan THEN '未完成' " +
            "            ELSE '已完成' " +
            "        END AS zhuangtai " +
            "    FROM ( " +
            "        SELECT " +
            "            C, " +
            "            COUNT(CASE WHEN K IS NOT NULL THEN 1 END) AS renwu, " +
            "            COUNT(CASE WHEN M IS NOT NULL THEN 1 END) AS renyuan " +
            "        FROM " +
            "            gongyi_guicheng " +
            "        GROUP BY " +
            "            C " +
            "    ) AS guicheng_inner " +
            ") AS guicheng " +
            "ON hetong_jilu.id = guicheng.left_id " +
            "WHERE hetong_jilu.id IS NOT NULL")
    List<Htjl> refresh();
//     按月刷新
@Select("SELECT * " +
        "FROM hetong_jilu " +
        "LEFT JOIN ( " +
        "    SELECT " +
        "        C AS left_id, " +
        "        CASE " +
        "            WHEN renwu > renyuan THEN '未完成' " +
        "            ELSE '已完成' " +
        "        END AS zhuangtai " +
        "    FROM ( " +
        "        SELECT " +
        "            C, " +
        "            COUNT(CASE WHEN K IS NOT NULL THEN 1 END) AS renwu, " +
        "            COUNT(CASE WHEN M IS NOT NULL THEN 1 END) AS renyuan " +
        "        FROM " +
        "            gongyi_guicheng " +
        "        GROUP BY " +
        "            C " +
        "    ) AS guicheng_inner " +
        ") AS guicheng " +
        "ON hetong_jilu.id = guicheng.left_id " +
        "WHERE hetong_jilu.id IS NOT NULL " +
        "AND SUBSTRING( hetong_jilu.E, " +
        "        CHARINDEX('/', hetong_jilu.E) + 1, " +
        "        CASE " +
        "            WHEN CHARINDEX('/', hetong_jilu.E, CHARINDEX('/', hetong_jilu.E) + 1) > 0 " +
        "            THEN CHARINDEX('/', hetong_jilu.E, CHARINDEX('/', hetong_jilu.E) + 1) - CHARINDEX('/', hetong_jilu.E) - 1 " +
        "            ELSE 0 " +
        "        END) = MONTH(GETDATE())")
    List<Htjl> month();


    @Delete("delete from hetong_jilu where id=#{id}")
   boolean delete(int id);

//    @Insert("insert into hetong_jilu(c,d,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,AA,AB,AC,AD,AE,AF,AG,AH,AI,AJ,AK,AL,AM,AN,AO,AP,AQ,AR,AS,AT,hetongZhuangtai,AU,AV,AW)" +  "values (#{C},#{D},#{rwh},#{gygczt},#{gx},#{mc},#{th},#{dw},#{sl},#{cz},#{xhj},#{zl},#{gj},#{djgy},#{hjje},#{xgs},#{xdj},#{cgs},#{cdj},#{qgs},#{qdj},#{zjwwgs},#{zjwwdj},#{wwgs},#{wwdj},#{tgs},#{tdj},#{ggs},#{gdj},#{mgs},#{mdj},#{skxgs},#{skxdj},#{lc},#{lcdj},#{dhh},#{dhhdj},#{zzs},#{zssdj},#{xl},#{skz},#{hcrq},#{ccrq},#{ddyqjh},#{hetong_zhuangtai},#{c},#{djy},#{bz})")
//    boolean add(String C,String D,String rwh,String gygczt,String gx,String mc,String th,String dw,String sl,String cz,String xhj,String zl,String gj,String djgy,String hjje,String xgs,String xdj,String cgs,String cdj,String qgs, String qdj,String zjwwgs,String zjwwdj,String wwgs,String wwdj,String tgs,String tdj,String ggs,String gdj,String mgs,String mdj,String skxgs,String skxdj,String lc,String lcdj,String dhh,String dhhdj,String zzs,String zzsdj,String xl,String skz,String hcrq,String ccrq,String ddyqjh,String hetong_zhuangtai,String c,String djy,String bz);
//@Insert("insert into hetong_jilu(C,D) values(#{ywdw},#{hth})")
//boolean add(String ywdw,String hth);

//
//    @Insert("insert into hetong_jilu(C,D)  values ('111111','22222')")
//    boolean add(@Param("ywdw")String ywdw,@Param("hth")String hth);


//    @Update("update hetong_jilu set C = #{ywdw},D= #{d},E= #{e},F= #{f},G= #{g},H= #{h},I= #{i},J= #{j},K= #{k},L= #{l},M= #{m},N= #{n},O= #{o},P= #{p},Q= #{q},R= #{r},S= #{s},T= #{t},U= #{u},V= #{v},W= #{w},X= #{x},Y= #{y},Z= #{z},AA= #{aa},AB= #{ab},AC= #{ac},AD= #{ad},AE= #{ae},AF= #{af},AG= #{ag},AH= #{ah},AI= #{ai},AJ= #{aj},AK= #{ak},AL= #{al},AM= #{am},AN= #{an},AO= #{ao},AP= #{ap},AQ= #{aq},AR= #{ar},AS= #{as},AT= #{at},hetong_zhuangtai= #{hetong_zhuangtai},AU= #{au},AV= #{av}")
//    boolean update(String ywdw,String hth,String rwh,String gygczt,String gx,String mc,String th,String dw,String sl,String cz,String xhj,String zl,String gj,String djgy,String hjje,String xgs,String xdj,String cgs,String cdj,String qgs, String qdj,String zjwwgs,String zjwwdj,String wwgs,String wwdj,String tgs,String tdj,String ggs,String gdj,String mgs,String mdj,String skxgs,String skxdj,String lc,String lcdj,String dhh,String dhhdj,String zzs,String zzsdj,String xl,String skz,String hcrq,String ccrq,String ddyqjh,String hetong_zhuangtai,String c,String djy,String bz);

//    @Update("update hetong_jilu set c = #{C}  where id = #{id}")
//    boolean update(String C,int id);

        @Insert("insert into hetong_jilu(c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak,al,am,an,ao,ap,aq,ar,ass,at,hetongZhuangtai,au,av,aw),values(#{C},#{D},#{E},#{F}),#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V},#{W},#{X},#{Y},#{Z},#{aa},#{ab},#{ac},#{ad},#{ae},#{af},#{ag},#{ah},#{ai},#{aj},#{ak},#{al},#{am},#{an},#{ao},#{ap},#{aq},#{ar},#{ass},#{at},#{hetongZhuangtai},#{au},#{av},#{aw}")
    boolean add(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V, String W,String X,String Y,String Z,String aa,String ab,String ac,String ad,String ae,String af,String ag,String ah,String ai,String aj,String ak,String al,String am,String an,String ao,String ap,String aq,String ar,String ass,String at,String hetongZhuangtai,String au,String av,String aw);

        @Update("update hetong_jilu set c = #{C},d= #{D},e= #{E},f= #{F},g= #{G},h= #{H},i= #{I},j= #{J},k= #{K},l= #{L},m= #{M},n= #{N},o= #{O},p= #{P},q= #{Q},r= #{R},s= #{S},t= #{T},u= #{U},v= #{V},w= #{W},x= #{X},y= #{Y},z= #{Z},aa= #{aa},ab= #{ab},ac= #{ac},ad= #{ad},ae= #{ae},af= #{af},ag= #{ag},ah= #{ah},ai= #{ai},aj= #{aj},ak= #{ak},al= #{al},am= #{am},an= #{an},ao= #{ao},ap= #{ap},aq= #{aq},ar= #{ar},ass= #{ass},at= #{at},hetongZhuangtai= #{hetongZhuangtai},au= #{au},av= #{av},aw=#{aw}")
    boolean update(String C,String D,String E,String F,String G,String H,String I,String J,String K,String L,String M,String N,String O,String P,String Q,String R,String S,String T,String U,String V, String W,String X,String Y,String Z,String aa,String ab,String ac,String ad,String ae,String af,String ag,String ah,String ai,String aj,String ak,String al,String am,String an,String ao,String ap,String aq,String ar,String ass,String at,String hetongZhuangtai,String au,String av,String aw);

    @Update({
            "<script>",
            "UPDATE hetong_jilu",
            "SET T = CASE",
            "    WHEN S IS NULL OR S = 0 THEN S * 40",
            "    ELSE T",
            "END,",
            "V = CASE",
            "    WHEN U IS NULL OR U = 0 THEN U * 34",
            "    ELSE V",
            "END",
//            "X = CASE",
//            "    WHEN W <0  THEN W * 0",
//            "    ELSE X",
//            "END",
//            "Z = CASE",
//            "    WHEN Y <0  THEN Y * 34",
//            "    ELSE Z",
//            "END,",
//            "AB = CASE",
//            "    WHEN AA <0  THEN AA * 34",
//            "    ELSE AB",
//            "END,",
//            "AD = CASE",
//            "    WHEN AC <0 THEN AC * 34",
//            "    ELSE AD",
//            "END,",
//            "AF = CASE",
//            "    WHEN AE <0  THEN AE * 34",
//            "    ELSE AF",
//            "END,",
//            "AH = CASE",
//            "    WHEN AG <0  THEN AG * 34",
//            "    ELSE AH",
//            "END,",
//            "AJ = CASE",
//            "    WHEN AI <0  THEN AI * 34",
//            "    ELSE AJ",
//            "END,",
//            "AL = CASE",
//            "    WHEN AK <0  THEN AK * 34",
//            "    ELSE AL",
//            "END,",
//            "AN = CASE",
//            "    WHEN AM <0  THEN AM * 34",
//            "    ELSE AN",
//            "END,",
//            "AP = CASE",
//            "    WHEN AO <0  THEN AO * 34",
//            "    ELSE AP",
//            "END",
            "</script>"
    })
    boolean jisuan();














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