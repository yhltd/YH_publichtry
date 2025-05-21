package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from userInfo")//用来刷新
    List<UserInfo> getList();

    @Select("select * from userinfo where C like '%'+#{C}+'%'")//查名字
    List<UserInfo> queryList(String C);

    @Update("update userinfo set C = #{C},D = #{D},E = #{E},F = #{F} where id = #{id}")//修改名称，账号，密码，职位
    boolean update(String C,String D,String E,String F,int id);

    @Delete("delete from userinfo where id=#{id}")//删除序列号
    boolean delete(int id);

    @Insert("insert into userinfo(C,D,E,F) values(#{C},#{D},#{E},#{F})")//新增数据 名称，账号，密码，职位
    boolean add(String C,String D,String E,String F);

}
