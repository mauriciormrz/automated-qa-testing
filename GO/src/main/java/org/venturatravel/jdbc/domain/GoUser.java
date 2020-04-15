package org.venturatravel.jdbc.domain;

import java.util.Date;

public class GoUser {

    private int id;
    private String first_name;
    private String last_name;
    private String vi_email;
    private Date end_date;
    private int incoming_office_id;
    private int sf_guard_user_id;
    private int go_user_boss_id;
    private String job_title;
    private int is_active;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getVi_email() {
        return vi_email;
    }

    public void setVi_email(String vi_email) {
        this.vi_email = vi_email;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getGo_user_boss_id() {
        return go_user_boss_id;
    }

    public void setGo_user_boss_id(int go_user_boss_id) {
        this.go_user_boss_id = go_user_boss_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getIncoming_office_id() {
        return incoming_office_id;
    }

    public void setIncoming_office_id(int incoming_office_id) {
        this.incoming_office_id = incoming_office_id;
    }

    @Override
    public String toString() {
        return "GoUser{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", vi_email='" + vi_email + '\'' +
                ", end_date='" + end_date + '\'' +
                ", incoming_office_id='" + incoming_office_id + '\'' +
                ", go_user_boss_id='" + go_user_boss_id + '\'' +
                ", job_title='" + job_title + '\'' +
                ", is_active='" + is_active + '\'' +
                '}';
    }

    public int getSf_guard_user_id() {
        return sf_guard_user_id;
    }

    public void setSf_guard_user_id(int sf_guard_user_id) {
        this.sf_guard_user_id = sf_guard_user_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}
