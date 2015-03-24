package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/3/24.
 */
@Entity
@Table(name = "sys_permission")
public class Permission extends IdEntity {

    private String permissionName;
    private String url;
    private String permissions;

    public Permission(){}

    public Permission(Long id){
        this.id = id;
    }

    public String getPermissionName(){
        return permissionName;
    }

    public void setPermissionName(String permissionName){
        this.permissionName = permissionName;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getPermissions(){
        return permissions;
    }

    public void setPermissions(String permissions){
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
