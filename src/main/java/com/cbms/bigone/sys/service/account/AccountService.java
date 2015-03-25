package com.cbms.bigone.sys.service.account;

import com.cbms.bigone.sys.entity.SysUser;
import com.cbms.bigone.sys.repository.SysUserDao;
import com.cbms.commons.security.Digests;
import com.cbms.commons.utils.Clock;
import com.cbms.commons.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    private SysUserDao userDao;

    @Autowired
    public void setUserDao(SysUserDao userDao){
        this.userDao = userDao;
    }

    private Clock clock;

    public void setClock(Clock clock){
        this.clock = clock;
    }

    /**
     *
     * @return 返回所有用户信息
     */
    public List<SysUser> getAllUser(){
        return (List<SysUser>)userDao.findAll();
    }

    /**
     *
     * @param id
     * @return 根据主键返回用户信息
     */
    public SysUser getUser(Long id){
        return userDao.findOne(id);
    }

    /**
     *
     * @param loginName
     * @return 根据登录名返回用户信息
     */
    public SysUser findUserByLoginName(String loginName){
        return userDao.findByLoginName(loginName);
    }

    /**
     * 保存
     * @param user
     */
    public void saveUser(SysUser user){
        if(StringUtils.isNoneBlank(user.getPlainPassword())){
            entryptPassword(user);
        }

        userDao.save(user);
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     * @param user
     */
    private void entryptPassword(SysUser user){
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),salt,HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }
}
