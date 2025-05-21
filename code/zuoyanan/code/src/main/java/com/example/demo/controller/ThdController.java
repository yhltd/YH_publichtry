package com.example.demo.controller;

import com.example.demo.entity.Shdp;
import com.example.demo.entity.Thd;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.ThdMapper;
import com.example.demo.service.ThdService;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.ResultInfo;
import com.example.demo.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hui
 * @date 2025/5/9 11:46
 */
@Slf4j
@RestController
@RequestMapping("/thd")
public class ThdController {
    @Autowired
    private ThdService thdService;
   //刷新
   @RequestMapping("/getList")
   public ResultInfo getList(HttpSession session) {
       UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
       try {
           List<Thd> getList = thdService.getList();
           return ResultInfo.success("获取成功", getList);
       } catch (Exception e) {
           e.printStackTrace();
           log.error("获取失败：{}", e.getMessage());
           return ResultInfo.error("错误!");
       }
   }

    //清空
    @RequestMapping("/delete")
    public void delete() {
        thdService.delete();
    }
    //加一行
    @RequestMapping("/add")
    public void add(HttpSession session, String C, String D, String E, String F) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        thdService.add(C, D, E, F);
    }
    //减一行

    @RequestMapping("/delete1")
    public void delete1(HttpSession session, Integer id) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        thdService.delete1(id);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(HttpSession session, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, Integer id) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        thdService.update(G,H,I,J, K, L, M, N, O, P, Q, R, S, id);
    }
}
