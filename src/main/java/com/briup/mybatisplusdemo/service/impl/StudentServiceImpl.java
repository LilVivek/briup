package com.briup.mybatisplusdemo.service.impl;

import com.briup.mybatisplusdemo.bean.Student;
import com.briup.mybatisplusdemo.mapper.StudentMapper;
import com.briup.mybatisplusdemo.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
