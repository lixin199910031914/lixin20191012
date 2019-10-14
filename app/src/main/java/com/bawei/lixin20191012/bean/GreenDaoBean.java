package com.bawei.lixin20191012.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenDaoBean {
    @Id
    private Long id;
    private String headPic;
    private String nickName;
    private String phone;
    private String sessionId;
    private int sex;
    private int userId;
    @Generated(hash = 971678426)
    public GreenDaoBean(Long id, String headPic, String nickName, String phone,
            String sessionId, int sex, int userId) {
        this.id = id;
        this.headPic = headPic;
        this.nickName = nickName;
        this.phone = phone;
        this.sessionId = sessionId;
        this.sex = sex;
        this.userId = userId;
    }
    @Generated(hash = 826843181)
    public GreenDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getHeadPic() {
        return this.headPic;
    }
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
