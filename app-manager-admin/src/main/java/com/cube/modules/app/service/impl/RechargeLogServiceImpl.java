package com.cube.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cube.common.utils.PageUtils;
import com.cube.common.utils.Query;

import com.cube.modules.app.dao.RechargeLogDao;
import com.cube.modules.app.entity.RechargeLogEntity;
import com.cube.modules.app.service.RechargeLogService;


@Service("rechargeLogService")
public class RechargeLogServiceImpl extends ServiceImpl<RechargeLogDao, RechargeLogEntity> implements RechargeLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RechargeLogEntity> page = this.page(
                new Query<RechargeLogEntity>().getPage(params),
                new QueryWrapper<RechargeLogEntity>()
        );

        return new PageUtils(page);
    }

}
