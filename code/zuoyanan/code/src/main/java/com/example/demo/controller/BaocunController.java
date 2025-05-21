package com.example.demo.controller;

import com.example.demo.entity.Baocun;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.BaocunService;
import com.example.demo.util.DecodeUtil;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.ResultInfo;
import com.example.demo.util.SessionUtil;
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
 * @date 2025/5/8 9:11
 */
@Slf4j
@RestController
@RequestMapping("/baocun")
public class BaocunController {
    @Autowired
    private BaocunService baocunService;

    @RequestMapping("/getList")
    public ResultInfo getList(HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Baocun> getList = baocunService.getList();
            return ResultInfo.success("获取成功", getList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }
    @RequestMapping("/add")
    public void add(HttpSession session,String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V){
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        baocunService.add(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);
    }
    //查询
    @RequestMapping("/queryList")
    public ResultInfo queryList(String D, String H, String I, HttpSession session) {
       UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Baocun> list = baocunService.queryList(D, H, I);
            return ResultInfo.success("获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultInfo update(@RequestBody String updateJson, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
       Baocun baocun = null;
        try {
            baocun = DecodeUtil.decodeToJson(updateJson, Baocun.class);
            if (baocunService.update(baocun)) {
                return ResultInfo.success("修改成功", baocun);
            } else {
                return ResultInfo.success("修改失败", baocun);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改失败：{}", e.getMessage());
            return ResultInfo.error("修改失败");
        }
    }
//    @RequestMapping(value = "/update1", method = RequestMethod.POST)
//    public ResultInfo update1(HttpSession session,String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V,Integer id)
//     {
//        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
//        Baocun baocun = null;
//        try {
//           baocunService.update1(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,id);
//            return ResultInfo.success("修改成功",baocun);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("修改失败：{}", e.getMessage());
//            return ResultInfo.error("修改失败");
//        }
//    }
    @RequestMapping("/delete")
    public ResultInfo delete(@RequestBody HashMap map, HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
        try {
            for(int i=0; i<idList.size(); i++){
                int this_id = idList.get(i);
                baocunService.delete(Collections.singletonList(this_id));
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
