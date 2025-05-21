package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userInfo")
public class UserInfo {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String C;
    /**
     * 账号
     */
    private String D;
    /**
     * 密码
     */
    private String E;
    /**
     * 职位
     */
    private String F;

//    public Object Power;
//    /**
//     * 操作权限
//     */
//    private String caozuoquanxian;

}
