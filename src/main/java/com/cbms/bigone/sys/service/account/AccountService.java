package com.cbms.bigone.sys.service.account;

import com.cbms.bigone.sys.entity.Role;
import com.cbms.bigone.sys.entity.SysUser;
import com.cbms.bigone.sys.repository.SysUserDao;
import com.cbms.bigone.sys.service.ShiroDBRealm;
import com.cbms.commons.persistence.DynamicSpecifications;
import com.cbms.commons.persistence.Hibernates;
import com.cbms.commons.persistence.SearchFilter;
import com.cbms.commons.security.Digests;
import com.cbms.commons.utils.Clock;
import com.cbms.commons.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 用户管理类
 * Created by Administrator .
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
     * 获取全部用户，并在返回前对用户的延迟加载关联角色进行初化始
     * @return
     */
    public List<SysUser> getAllUserInitialized(){
        List<SysUser> result =  (List<SysUser>)userDao.findAll();
        for(SysUser sysUser : result){
            Hibernates.initLazyProperty(sysUser.getRoleList());
        }
        return result;
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
     * 按名称查询用户, 并在返回前对用户的延迟加载关联角色进行初始化.
     */
    public SysUser findUserByNameInitialized(String name) {
        SysUser sysUser = userDao.findByName(name);
        if (sysUser != null) {
            Hibernates.initLazyProperty(sysUser.getRoleList());
        }
        return sysUser;
    }

    /**
     * 按页面传来的查询条件查询用户.
     */
    public List<SysUser> searchUser(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<SysUser> spec = DynamicSpecifications.bySearchFilter(filters.values(), SysUser.class);
        List<SysUser> userList = userDao.findAll(spec);

        return userList;
    }

    /**
     * 获取当前用户数量.
     */
    public Long getUserCount() {
        return userDao.count();
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

    /**
     * 取出Shiro中的当前用户LoginName
     * @return
     */
    private String getCurrentUserName(){
        ShiroDBRealm.ShiroUser user = (ShiroDBRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    public static List<Role> roleList(){

    }
}
