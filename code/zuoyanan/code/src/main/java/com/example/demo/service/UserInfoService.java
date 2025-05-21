package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface UserInfoService extends IService<UserInfo> {
    /**
     * 登陆
     *
     * @param D 用户名
     * @param E 密码
     * @return 转Json后的用户信息
     */
    Map<String, Object> login(String D , String E);

    /**
     * 查询所有
     */
    List<UserInfo> getList();

    /**
     * 根据姓名查询
     */
    List<UserInfo> queryList(String C);

    /**
     * 修改
     */
    boolean update(UserInfo userInfo);

    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(List<Integer> idList);

    /**
     * 添加
     */
    UserInfo add(UserInfo userInfo);

}
