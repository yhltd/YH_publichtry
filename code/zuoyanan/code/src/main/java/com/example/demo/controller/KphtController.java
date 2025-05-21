package com.example.demo.controller;

import com.example.demo.entity.Htjl;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.HtjlService;
import com.example.demo.service.KphtService;
import com.example.demo.service.YwchtService;
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
@RequestMapping("/kpht")
public class KphtController {
    @Autowired
    private KphtService kphtService;

    /**
     * 查询所有
     *
     * @return ResultInfo
     */
    @RequestMapping("/getList")
    public ResultInfo getList(HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Htjl> getList = kphtService.getList();
            return ResultInfo.success("获取成功", getList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }

    @RequestMapping("/refresh")
    public ResultInfo refresh() {
        try {
            List<Htjl> refresh = kphtService.refresh();
            return ResultInfo.success("获取成功", refresh);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误！");
        }

    }



    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultInfo update(@RequestBody String updateJson, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        Htjl htjl = null;
        try {
            htjl = DecodeUtil.decodeToJson(updateJson, Htjl.class);
            if (kphtService.update(htjl)) {
                return ResultInfo.success("修改成功", htjl);
            } else {
                return ResultInfo.success("修改失败", htjl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改失败：{}", e.getMessage());
            return ResultInfo.error("修改失败");
        }
    }


    /**
     * 添加
     */
    @RequestMapping("/add")
    public ResultInfo add(@RequestBody HashMap map, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        try {
            Htjl htjl = GsonUtil.toEntity(gsonUtil.get("addInfo"), Htjl.class);
            htjl =kphtService.add(htjl);
            if (StringUtils.isNotNull(htjl)) {
                return ResultInfo.success("添加成功", htjl);
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

    //   设置开票
    @RequestMapping("/szkp")
    public ResultInfo szkp(@RequestBody HashMap map, HttpSession session) {
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        Integer id = GsonUtil.toEntity(gsonUtil.get("id"), Integer.class);
        try {
            int id1= id;

            kphtService.szkp(id1);
            return ResultInfo.success("设置开票成功");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("设置失败：{}", e.getMessage());
//            log.error("参数：{}", a);
            return ResultInfo.error("设置失败");
        }
    }

    /**
     * 删除
     *
     * @param map
     * @return ResultInfo
     */
    @RequestMapping("/delete")
    public ResultInfo delete(@RequestBody HashMap map, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
        try {
            for (int i = 0; i < idList.size(); i++) {
                int this_id = idList.get(i);
                kphtService.delete(Collections.singletonList(this_id));
            }
            return ResultInfo.success("删除成功", idList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除失败：{}", e.getMessage());
            log.error("参数：{}", idList);
            return ResultInfo.error("删除失败");
        }
    }
}



