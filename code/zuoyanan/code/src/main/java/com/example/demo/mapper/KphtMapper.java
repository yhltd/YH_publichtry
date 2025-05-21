package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.Htjl;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KphtMapper extends BaseMapper<Htjl> {
    //显示全部
    @Select("SELECT * FROM hetong_jilu WHERE F IN ('未开票', '已开票')")
    List<Htjl> getList();

    //    刷新
    @Update({
            "<script>",
            "UPDATE hetong_jilu",
            "SET T = CASE",
            "    WHEN T IS NULL OR T = 0 THEN S + 4* 40",
            "    ELSE T",
            "END,",
            "V = CASE",
            "    WHEN V IS NULL OR V = 0 THEN U + 4* 40",
            "    ELSE V",
            "END",
            "X = CASE",
            "    WHEN X IS NULL OR X = 0 THEN  W+4* 40",
            "    ELSE X",
            "END",
            "Z = CASE",
            "    WHEN Z IS NULL OR Z = 0 THEN Y+4 * 57.6",
            "    ELSE Z",
            "END,",
            "AB = CASE",
            "    WHEN AB IS NULL OR AB = 0 THEN AA * 48",
            "    ELSE AB",
            "END,",
            "AD = CASE",
            "    WHEN AD IS NULL OR AD = 0 THEN AC * 73",
            "    ELSE AD",
            "END,",
            "AF = CASE",
            "    WHEN AF IS NULL OR AF = 0 THEN AE * 24",
            "    ELSE AF",
            "END,",
            "AH = CASE",
            "    WHEN AH IS NULL OR AH = 0 THEN AG * 42",
            "    ELSE AH",
            "END,",
            "AJ = CASE",
            "    WHEN AJ IS NULL OR AJ = 0 THEN AI * 69",
            "    ELSE AJ",
            "END,",
            "AL = CASE",
            "   WHEN AL IS NULL OR AL = 0 THEN AK * 71",
            "    ELSE AL",
            "END,",
            "AN = CASE",
            "    WHEN AN IS NULL OR AN = 0 THEN AM * 42",
            "    ELSE AN",
            "END,",
            "AP = CASE",
            "   WHEN AP IS NULL OR AP = 0 THEN AO * 38",
            "    ELSE AP",
            "END",
            " P = T+V+X+Z+AB+AD+AF+AH+AJ+AL+AN+AP",
            " Q = K * P",
            " hetong_zhuangtai = K * R",
            " AU = T * K",
            "</script>"})
    List<Htjl> refresh();

    //删除
    @Delete("delete from hetong_jilu where id=#{id}")
    boolean delete(int id);

    //添加
    @Insert("insert into hetong_jilu(c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak,al,am,an,ao,ap,aq,ar,ass,at,hetongZhuangtai,au,av,aw),values(#{C},#{D},#{E},#{F}),#{G},#{H},#{I},#{J},#{K},#{L},#{M},#{N},#{O},#{P},#{Q},#{R},#{S},#{T},#{U},#{V},#{W},#{X},#{Y},#{Z},#{aa},#{ab},#{ac},#{ad},#{ae},#{af},#{ag},#{ah},#{ai},#{aj},#{ak},#{al},#{am},#{an},#{ao},#{ap},#{aq},#{ar},#{ass},#{at},#{hetongZhuangtai},#{au},#{av},#{aw}")
    boolean add(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V, String W, String X, String Y, String Z, String aa, String ab, String ac, String ad, String ae, String af, String ag, String ah, String ai, String aj, String ak, String al, String am, String an, String ao, String ap, String aq, String ar, String ass, String at, String hetongZhuangtai, String au, String av, String aw);

    //修改
    @Update("update hetong_jilu set c = #{C},d= #{D},e= #{E},f= #{F},g= #{G},h= #{H},i= #{I},j= #{J},k= #{K},l= #{L},m= #{M},n= #{N},o= #{O},p= #{P},q= #{Q},r= #{R},s= #{S},t= #{T},u= #{U},v= #{V},w= #{W},x= #{X},y= #{Y},z= #{Z},aa= #{aa},ab= #{ab},ac= #{ac},ad= #{ad},ae= #{ae},af= #{af},ag= #{ag},ah= #{ah},ai= #{ai},aj= #{aj},ak= #{ak},al= #{al},am= #{am},an= #{an},ao= #{ao},ap= #{ap},aq= #{aq},ar= #{ar},ass= #{ass},at= #{at},hetongZhuangtai= #{hetongZhuangtai},au= #{au},av= #{av},aw=#{aw}")
    boolean update(String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V, String W, String X, String Y, String Z, String aa, String ab, String ac, String ad, String ae, String af, String ag, String ah, String ai, String aj, String ak, String al, String am, String an, String ao, String ap, String aq, String ar, String ass, String at, String hetongZhuangtai, String au, String av, String aw);

    //设置开票
    @Update({"UPDATE hetong_jilu set f = '已开票' where id=#{id} "})
    boolean szkp(int id);
}
