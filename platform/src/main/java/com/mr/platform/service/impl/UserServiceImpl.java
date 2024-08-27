package com.mr.platform.service.impl;

import com.mr.platform.entity.Qa;
import com.mr.platform.entity.User;
import com.mr.platform.mapper.UserMapper;
import com.mr.platform.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MR-DMA
 * @since 2024-08-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
