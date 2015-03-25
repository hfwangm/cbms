package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator .
 */
public interface PermissionDao extends PagingAndSortingRepository<Permission , Long> ,
        JpaSpecificationExecutor<Permission>
{


}
