package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * 角色
 * Created by Administrator on 2015/3/19.
 */
@Entity
@Table(name = "sys_role")
public class Role extends IdEntity {

    private String name;
    private String discription;
    private List<Permission> permissionsList = Lists.newArrayList();

    public Role(){}

    public Role(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription(){
        return discription;
    }

    public void setDiscription(String discription){
        this.discription = discription;
    }

    //多对多定义
    @ManyToMany
    @JoinTable(name = "sys_role_permission" , joinColumns = { @JoinColumn(name = "role_id") } ,
    inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    public List<Permission> getPermissionsList(){
        return permissionsList;
    }

    public void setPermissionsList(List<Permission> permissionsList){
        this.permissionsList = permissionsList;
    }

    //另一种数据库表设计方式，role和permission合二为一，permission以,分隔存储
//    @Transient
//    public List<String> getPermissionList() {
//        return ImmutableList.copyOf(StringUtils.split(permissions, ","));
//    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
