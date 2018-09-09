package com.mywuwu.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wuwu_user")
public class WuwuUser {
    @Id
    private Integer id;

    @Column(name = "user_Type")
    private Integer userType;

    private String weicar;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "login_Date")
    private Date loginDate;

    @Column(name = "phoneCode")
    private String phonecode;

    @Column(name = "rigDateTime")
    private Date rigdatetime;

    private String remark;

    @Column(name = "passWord")
    private String password;

    @Column(name = "login_Name")
    private String loginName;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "lock_type")
    private Integer lockType;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_Type
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * @return weicar
     */
    public String getWeicar() {
        return weicar;
    }

    /**
     * @param weicar
     */
    public void setWeicar(String weicar) {
        this.weicar = weicar;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return login_Date
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * @return phoneCode
     */
    public String getPhonecode() {
        return phonecode;
    }

    /**
     * @param phonecode
     */
    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    /**
     * @return rigDateTime
     */
    public Date getRigdatetime() {
        return rigdatetime;
    }

    /**
     * @param rigdatetime
     */
    public void setRigdatetime(Date rigdatetime) {
        this.rigdatetime = rigdatetime;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return passWord
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return login_Name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return user_Name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return lock_type
     */
    public Integer getLockType() {
        return lockType;
    }

    /**
     * @param lockType
     */
    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }
}