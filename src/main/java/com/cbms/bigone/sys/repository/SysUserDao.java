package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.SysUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator .
 */
public interface SysUserDao extends PagingAndSortingRepository<SysUser , Long > , JpaSpecificationExecutor<SysUser> {

    SysUser findByLoginName(String loginName);

    SysUser findByName(String name);
}
