package com.briup.mybatisplusdemo.service.impl;

import com.briup.mybatisplusdemo.bean.Teacher;
import com.briup.mybatisplusdemo.mapper.TeacherMapper;
import com.briup.mybatisplusdemo.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vivek
 * @since 2023-11-13
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
