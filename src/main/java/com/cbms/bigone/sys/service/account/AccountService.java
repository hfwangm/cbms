package com.cbms.bigone.sys.service.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * 用户管理类
 * Created by Administrator on 2015/3/14.
 */
//Spring Service Bean的标识
@Component
@Transactional
public class AccountService {

    public static final String HASH_ALGORITHM = "SHA-A";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(AccountService.class);


}
