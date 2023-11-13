package com.briup.mybatisplusdemo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Accessors(chain = true)//链式setter
@TableName("t_student")
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
}
