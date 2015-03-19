package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2015/3/19.
 */
public interface RoleDao extends PagingAndSortingRepository<Role,Long> {
}
