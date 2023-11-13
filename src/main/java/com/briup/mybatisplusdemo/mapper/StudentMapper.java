package com.briup.mybatisplusdemo.mapper;

import com.briup.mybatisplusdemo.bean.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Vivek
 * @since 2023-11-13
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
