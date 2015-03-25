package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Administrator .
 */

@Entity
@Table(name = "sys_team")
public class Team extends IdEntity {

    private String name;
    private SysUser master;
    private List<SysUser> userList = Lists.newArrayList();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "master_id")
    public SysUser getMaster(){
        return master;
    }

    public void setMaster(SysUser master){
        this.master = master;
    }

    @OneToMany(mappedBy = "team")
    public List<SysUser> getUserList(){
        return userList;
    }

    public void setUserList(List<SysUser> userList){
        this.userList = userList;
    }
}
