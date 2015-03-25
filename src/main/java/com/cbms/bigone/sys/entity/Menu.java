package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by TheOne .
 */
@Entity
@Table(name = "sys_menu")
public class Menu extends IdEntity {

    private Menu parent;        //父级菜单
    private String parentIds;   //所有父级编号
    private String name;        //菜单名称
    private String href;        //链接
    private String target;      //目标( mainFrame、_blank、_self、_parent、_top)
    private String icon;        //图标
    private Integer sort;       //排序
    private String isShow;      //是否显示（1:显示；0:不显示）
    private String identity;    //权限匹配 如sys:resource

    public Menu(){
        super();
        this.sort = 30;
        this.isShow = "1";
    }

    public Menu(Long id){}

    @JsonBackReference
    @NotNull
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Length(min=1, max=2000)
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Length(min=1, max=100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min=0, max=2000)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Length(min=0, max=20)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Length(min=0, max=100)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NotNull
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Length(min=1, max=1)
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIdentity(){
        return identity;
    }

    public void setIdentity(String identity){
        this.identity = identity;
    }

    @Transient
    public List<String> getIdentityList(){
        return ImmutableList.copyOf(StringUtils.split( identity , ","));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
