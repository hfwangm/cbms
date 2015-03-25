package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator .
 */
public interface LogDao extends PagingAndSortingRepository<Log,Long> ,
        JpaSpecificationExecutor<Log>
{
    Page<Log> findByUserId(Long id , Pageable pageRequest);

}
