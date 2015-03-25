package com.cbms.bigone.sys.repository;

import com.cbms.bigone.sys.entity.Menu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by TheOne .
 */
public interface MenuDao extends PagingAndSortingRepository<Menu , Long> ,
        JpaSpecificationExecutor<Menu>
{

}
