package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;

@Data
@TableName("hetong_jilu")
public class Htjl {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    /**
     * 业务单位
     */
    private String C;
    /**
     * 合同号
     */
    private String D;
    /**
     * 任务号
     */
    private String E;
    /**
     * 工艺规程状态
     */
    private String F;
    /**
     * 工序
     */
    private String G;
    /**
     * 名称
     */
    private String H;
    /**
     * 图号
     */
    private String I;
    /**
     * 单位
     */
    private String J;
    /**
     * 数量
     */
    private String K;
    /**
     * 材质
     */
    private String L;
    /**
     * 序合计
     */
    private String M;
    /**
     * 重量
     */
    private String N;
    /**
     * 工件
     */
    private String O;
    /**
     * 单元价
     */
    private String P;
    /**
     * 合计金额
     */
    private String Q;
    /**
     * 铣工时/40
     */
    private String R;
    /**
     * 铣单价
     */
    private String S;
    /**
     * 车工时/40
     */
    private String T;
    /**
     * 车单价/34
     */
    private String U;
    /**
     * 钳工时/40
     */
    private String V;
    /**
     * 钳单价
     */
    private String W;
    /**
     * 整件外委工时
     */
    private String X;
    /**
     * 整件外委单价
     */
    private String Y;
    /**
     * 外委工时/48
     */
    private String Z;
    /**
     * 外委单价
     */
    @TableField("AA")
    private String aa;
    /**
     * 镗工时/73
     */
    @TableField("AB")
    private String ab;
    /**
     * 镗单价
     */
    @TableField("AC")
    private String ac;
    /**
     * 割工时/24
     */
    @TableField("AD")
    private String ad;

    /**
     * 割单价
     */
    @TableField("AE")
    private String ae;
    /**
     * 磨工时/42
     */
    @TableField("AF")
    private String af;
    /**
     * 磨单价
     */
    @TableField("AG")
    private String ag;
    /**
     * 数控铣工时/69
     */
    @TableField("AH")
    private String ah;
    /**
     * 数控铣单价
     */
    @TableField("AI")
    private String ai;

    /**
     * 立车/71
     */
    @TableField("AJ")
    private String aj;
    /**
     * 立车单价
     */
    @TableField("AK")
    private String ak;
    /**
     * 电火花/42
     */
    @TableField("AL")
    private String al;
    /**
     * 电火花单价
     */
    @TableField("AM")
    private String am;
    /**
     * 中走私/38
     */
    @TableField("AN")
    private String an;

    /**
     * 中走丝单价
     */
    @TableField("AO")
    private String ao;
    /**
     * 下料
     */
    @TableField("AP")
    private String ap;
    /**
     * 深孔钻
     */
    @TableField("AQ")
    private String aq;
    /**
     * 回厂日期
     */
    @TableField("AR")
    private String ar;
    /**
     * 出厂日期
     */
//    @Column(name = "`AS`")
    @TableField("ASS")
    private String ass;

    /**
     * 订单要求交货时间
     */
    @TableField("AT")
    private String at;
    /**
     * 铣
     */
    private String hetongZhuangtai ;
    /**
     * 车
     */
    @TableField("AU")
    private String au;
    /**
     * 登记员
     */
    @TableField("AV")
    private String av;
    /**
     * 备注
     */
    @TableField("AW")
    private String aw;
}
