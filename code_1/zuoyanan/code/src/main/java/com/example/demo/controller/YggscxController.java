package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.entity.Gygc;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.YggscxService;
import com.example.demo.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/yggscx")
public class YggscxController {
    @Autowired
    private YggscxService yggscxService;

    /**
     * 根据姓名和部门查询
     *
     * @return ResultInfo
     */
    @RequestMapping("/select")
    public ResultInfo select(String qssj, String jzsj, String yuangong,HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Gygc> list =yggscxService.select(qssj, jzsj,yuangong);
            return ResultInfo.success("获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }

    @RequestMapping("/jisuan")
    public ResultInfo jisuan( String qssj, String jzsj,String yuangong,HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Gygc> zgs=yggscxService.jisuan(qssj, jzsj,yuangong);
            return ResultInfo.success("获取成功",zgs);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }


}