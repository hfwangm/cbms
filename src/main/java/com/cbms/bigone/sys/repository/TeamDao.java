package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Team;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator .
 */
public interface TeamDao extends PagingAndSortingRepository<Team , Long> ,
        JpaSpecificationExecutor<Team>
{
}
