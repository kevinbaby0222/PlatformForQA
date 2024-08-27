package com.mr.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mr.platform.entity.Qa;
import com.mr.platform.mapper.QaMapper;
import com.mr.platform.service.IQaService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MR-DMA
 * @since 2024-08-27
 */
@Service
public class QaServiceImpl extends ServiceImpl<QaMapper, Qa> implements IQaService {
}
