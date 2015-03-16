package com.cbms.bigone.sys.entity;

import com.cbms.utils.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 系统用户表
 * Created by Administrator on 2015/3/11.
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends IdEntity {
    private String loginName;
    private String name;
    private String plainPassword;
    private String password;
    private String salt;
    private String email;
    private Date registerDate;
    private String status;

    public SysUser(){

    }

    public SysUser(Long id){

    }

    @NotBlank
    public String getLoginName(){
        return loginName;
    }

    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    @NotBlank
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //不持久化到数据库，也不显示在restful接口的属性
    @Transient
    @JsonIgnore
    @NotBlank
    public String getPlainPassword(){
        return  plainPassword;
    }

    public void setPlainPassword(String plainPassword){
        this.plainPassword = plainPassword;
    }

    @NotBlank
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @NotBlank
    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

    @Email
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @NotBlank
    public String getStatus(){
        return status;
    }

    public void setStatus(){
        this.status = status;
    }

    //设定JSON序列化时的日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08:00")
    public Date getRegisterDate(){
        return  registerDate;
    }

    public void setRegisterDate(Date registerDate){
        this.registerDate = registerDate;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
