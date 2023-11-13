package com.briup.mybatisplusdemo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vivek
 * @since 2023-11-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_teacher")
//@Builder //和链式调用结合使用
@ApiModel(value = "Teacher对象", description = "")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Double salary;

    @TableField(select = false)//无法查询这个字段
    @TableLogic//逻辑删除
    private Integer deleted;
}
