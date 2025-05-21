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

    @Select("select * from hetong_jilu where  C like '%'+#{ywdw}+'%' and F like '%'+#{gygczt}+'%'")
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

            "</script>"
    })
    boolean jisuan();

}
