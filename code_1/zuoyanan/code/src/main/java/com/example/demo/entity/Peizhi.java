package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2025/5/9 9:07
 */
@Data
@TableName("peizhi")
public class Peizhi {

    @TableId( value = "id",type = IdType.AUTO)
    private  Integer id;

    //工艺员
    private String C;

    //校对员
    private String D;

    //批准员
    private String E;
}
