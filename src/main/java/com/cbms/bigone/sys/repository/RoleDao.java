package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator .
 */
public interface RoleDao extends PagingAndSortingRepository<Role,Long> ,
        JpaSpecificationExecutor<Role>
{
}
