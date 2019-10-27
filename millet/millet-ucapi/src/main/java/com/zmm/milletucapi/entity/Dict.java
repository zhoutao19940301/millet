package com.zmm.milletucapi.entity;

import java.io.Serializable;
import java.util.Date;

public class Dict implements Serializable {
    private Integer id;

    private String dict_type;

    private String name;

    private String addtion;

    private Date create_time;

    private Date last_uptime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type == null ? null : dict_type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddtion() {
        return addtion;
    }

    public void setAddtion(String addtion) {
        this.addtion = addtion == null ? null : addtion.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_uptime() {
        return last_uptime;
    }

    public void setLast_uptime(Date last_uptime) {
        this.last_uptime = last_uptime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dict_type=").append(dict_type);
        sb.append(", name=").append(name);
        sb.append(", addtion=").append(addtion);
        sb.append(", create_time=").append(create_time);
        sb.append(", last_uptime=").append(last_uptime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}