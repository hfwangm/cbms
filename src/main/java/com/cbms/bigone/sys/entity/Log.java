package com.cbms.bigone.sys.entity;

import com.cbms.commons.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * 日志表
 * Created by Administrator .
 */
@Entity
@Table(name = "sys_log")
public class Log extends IdEntity {
    private String ip;
    private Long category;
    private Date logTime;
    private String content;
    private String url;
    private SysUser user;

    @NotBlank
    public String getIp(){
        return ip;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    @NotBlank
    public Long getCategory(){
        return category;
    }

    public void setCategory(Long category){
        this.category = category;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08:00")
    public Date getLogTime(){
        return logTime;
    }

    public void setLogTime(Date logTime){
        this.logTime = logTime;
    }

    @NotBlank
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @NotBlank
    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public SysUser getUser(){
        return user;
    }

    public void setUser(SysUser user){
        this.user = user;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
