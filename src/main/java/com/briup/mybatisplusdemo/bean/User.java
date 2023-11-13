package com.briup.mybatisplusdemo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)//链式调用,将set方法返回值 从void ->User对象
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("`user`")//映射数据库表名并自动resultMap
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}