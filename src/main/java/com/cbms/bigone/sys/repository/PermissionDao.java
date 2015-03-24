package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2015/3/24.
 */
public interface PermissionDao extends PagingAndSortingRepository<Permission , Long> {
}
