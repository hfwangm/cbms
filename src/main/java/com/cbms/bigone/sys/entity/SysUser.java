package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import com.cbms.commons.utils.Collections3;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    private Team team;

    private List<Role> roleList = Lists.newArrayList();

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

    //多对多定义
    @ManyToMany
    @JoinTable(name = "sys_user_role" , joinColumns = { @JoinColumn(name = "user_id") } ,
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    //Fetch策略定义
    @Fetch(FetchMode.SUBSELECT)
    //集合按ID排序
    @OrderBy("id ASC")
    public List<Role> getRoleList(){
        return roleList;
    }

    public void setRoleList(List<Role> roleList){
        this.roleList = roleList;
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Transient
    @JsonIgnore
    public String getRoleNames() {
        return Collections3.extractToString(roleList, "name", ", ");
    }
}
