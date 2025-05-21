package com.example.demo.controller;




import com.example.demo.entity.Shdp;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.BaocunMapper;
import com.example.demo.service.BaocunService;
import com.example.demo.service.ShdpService;
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
 * @date 2025/4/10 13:30
 */
@Slf4j
@RestController
@RequestMapping("/shdp")
public class ShdpController {
    @Autowired
    private ShdpService shdpService;
    private BaocunService baocunService;

    //刷新
    @RequestMapping("/getList")
    public ResultInfo getList(HttpSession session) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        try {
            List<Shdp> getList = shdpService.getList();
            return ResultInfo.success("获取成功", getList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }

    //保存
    @RequestMapping("/add")
    public void add(HttpSession session, String C, String D, String E, String F, String G, String H, String I, String Q, String R, String S, String T, String U, String V) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        shdpService.add(C, D, E, F, G, H, I, Q, R, S, T, U, V);
    }

    @RequestMapping("/add1")
    public void add1(HttpSession session, String J, String K, String L, String M, String N, String O, String P) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        shdpService.add1(J, K, L, M, N, O, P);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(HttpSession session, String C, String D, String E, String F, String G, String H, String I, String J, String K, String L, String M, String N, String O, String P, String Q, String R, String S, String T, String U, String V, Integer id) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
//        C = shdpService.getC(id);
//        D = shdpService.getD(id);
//        E = shdpService.getE(id);
//        F = shdpService.getF(id);
//        G = shdpService.getG(id);
//        H = shdpService.getH(id);
//        I = shdpService.getI(id);
//        Q = shdpService.getQ(id);
//        R = shdpService.getR(id);
//        S = shdpService.getS(id);
//        T = shdpService.getT(id);
//        U = shdpService.getU(id);
//        V = shdpService.getV(id);
        shdpService.update(J, K, L, M, N, O, P, id);
        //baocunService.add(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);
    }
    //    //    删除
    @RequestMapping("/delete1")
    public void delete1(HttpSession session, Integer id) {
        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
        shdpService.delete1(id);
    }
    @RequestMapping("/delete")
    public void delete() {
        shdpService.delete();
    }

    //添加
//    @RequestMapping("/add")
//    public ResultInfo add(@RequestBody HashMap map, HttpSession session) {
//        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
//        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
//        try {
//            Shdp Shdp = GsonUtil.toEntity(gsonUtil.get("addInfo"), Shdp.class);
//            Shdp = shdpService.add(Shdp);
//            if (StringUtils.isNotNull(Shdp)) {
//                return ResultInfo.success("添加成功", Shdp);
//            } else {
//                return ResultInfo.success("添加失败", null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("添加失败：{}", e.getMessage());
//            log.error("参数：{}", map);
//            return ResultInfo.error("添加失败");
//        }
//    }
//    @RequestMapping("/add2")
//    public ResultInfo add2(HttpSession session,  String C, String D, String E, String F, String G, String H, String I, String J,String K,String L,String M,String N,String O,String P,String Q, String R, String S, String T, String U, String V){
//        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
//        try {
//
//            shdpService.add2(C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);
//
//            return ResultInfo.success("添加成功", null);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("添加失败：{}", e.getMessage());
//
//            return ResultInfo.error("添加失败");
//        }
//    }

    //查询
//    @RequestMapping("/queryList")
//    public ResultInfo queryList(String D, String H, String I, HttpSession session) {
//        Shdp shdp = GsonUtil.toEntity(SessionUtil.getToken(session), Shdp.class);
//        try {
//            List<Shdp> list = shdpService.queryList(D, H, I);
//            return ResultInfo.success("获取成功", list);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("获取失败：{}", e.getMessage());
//            return ResultInfo.error("错误!");
//        }
//    }

//

//        C = shdpService.getC(id);
//        D = shdpService.getD(id);
//        E = shdpService.getE(id);
//        F = shdpService.getF(id);
//        G = shdpService.getG(id);
//        H = shdpService.getH(id);
//        I = shdpService.getI(id);
//        Q = shdpService.getQ(id);
//        R = shdpService.getR(id);
//        S = shdpService.getS(id);
//        T = shdpService.getT(id);
//        U = shdpService.getU(id);
//        V = shdpService.getV(id);


//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ResultInfo update(@RequestBody String updateJson, HttpSession session) {
//        UserInfo userInfo = GsonUtil.toEntity(SessionUtil.getToken(session), UserInfo.class);
//
//        Shdp shdp =null;
//        try {
//            shdp = DecodeUtil.decodeToJson(updateJson, Shdp.class);
//            if (shdpService.update(shdp)) {
//                return ResultInfo.success("修改成功", shdp);
//            } else {
//                return ResultInfo.success("修改失败", shdp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("修改失败：{}", e.getMessage());
////            log.error("参数：{}", userInfo);
//            return ResultInfo.error("修改失败");
//        }
//    }


}
//}
