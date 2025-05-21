package com.example.demo.controller;

import com.example.demo.entity.Peizhi;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.PeizhiService;
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

/**
 * @author hui
 * @date 2025/5/9 9:29
 */
@Slf4j
@RestController
@RequestMapping("/peizhi")
public class PeizhiController {
    @Autowired
    private PeizhiService peizhiService;
    //刷新全部
    @RequestMapping("/getList")
    public ResultInfo getList(HttpSession session){
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Peizhi>getList =peizhiService.getList();
            return ResultInfo.success("获取成功",getList);
        } catch (Exception e) {
        e.printStackTrace();
        log.error("获取失败：{}", e.getMessage());
        return ResultInfo.error("错误!");
    }
    }

    //新增
    @RequestMapping("/add")
    public ResultInfo add(@RequestBody HashMap map, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        try {
            Peizhi peizhi = GsonUtil.toEntity(gsonUtil.get("addInfo"), Peizhi.class);
            peizhi = peizhiService.add(peizhi);
            if (StringUtils.isNotNull(peizhi)) {
                return ResultInfo.success("添加成功", peizhi);
            } else {
                return ResultInfo.success("添加失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加失败：{}", e.getMessage());
            log.error("参数：{}", map);
            return ResultInfo.error("添加失败");
        }
    }

    //删除
    @RequestMapping("/delete")
    public ResultInfo delete(@RequestBody HashMap map, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
        try {
            for(int i=0; i<idList.size(); i++){
                int this_id = idList.get(i);
                peizhiService.delete(Collections.singletonList(this_id));
            }
            return ResultInfo.success("删除成功", idList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除失败：{}", e.getMessage());
            log.error("参数：{}", idList);
            return ResultInfo.error("删除失败");
        }
    }
//改
@RequestMapping(value = "/update", method = RequestMethod.POST)
public ResultInfo update(@RequestBody String updateJson, HttpSession session) {
    UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
    Peizhi peizhi = null;
    try {
        peizhi = DecodeUtil.decodeToJson(updateJson, Peizhi.class);
        if (peizhiService.update(peizhi)) {
            return ResultInfo.success("修改成功", peizhi);
        } else {
            return ResultInfo.success("修改失败", peizhi);
        }
    } catch (Exception e) {
        e.printStackTrace();
        log.error("修改失败：{}", e.getMessage());
        return ResultInfo.error("修改失败");
    }
}

//查
@RequestMapping("/queryList")
public ResultInfo queryList(String C,String D,String E, HttpSession session) {
    UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);

    try {
        List<Peizhi> list = peizhiService.queryList(C,D,E);
        return ResultInfo.success("获取成功", list);
    } catch (Exception e) {
        e.printStackTrace();
        log.error("获取失败：{}", e.getMessage());
        return ResultInfo.error("错误!");
    }
}
}
