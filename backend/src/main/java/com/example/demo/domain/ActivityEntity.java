package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity", schema = "public", catalog = "postgres")
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="timeStamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timeStamp;

    @Column(name="firstcurr")
    private String firstcurr;

    @Column(name="secondcurr")
    private String secondcurr;

    public ActivityEntity() {}

    public ActivityEntity(String firstcurr, String secondcurr) {
        this.timeStamp = new Date(System.currentTimeMillis());
        this.firstcurr = firstcurr;
        this.secondcurr = secondcurr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getFirstcurr() {
        return firstcurr;
    }

    public void setFirstcurr(String firstcurr) {
        this.firstcurr = firstcurr;
    }

    public String getSecondcurr() {
        return secondcurr;
    }

    public void setSecondcurr(String secondcurr) {
        this.secondcurr = secondcurr;
    }
}
