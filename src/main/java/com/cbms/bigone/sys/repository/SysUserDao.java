package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2015/3/14.
 */
public interface SysUserDao extends PagingAndSortingRepository<SysUser , Long > {
    SysUser findByLoginName(String loginName);
}
