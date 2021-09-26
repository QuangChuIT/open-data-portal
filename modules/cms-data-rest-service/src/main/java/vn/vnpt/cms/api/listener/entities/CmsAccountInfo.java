package vn.vnpt.cms.api.listener.entities;

public class CmsAccountInfo {
    private int id;
    private String user_name;
    private String full_name;
    private String phone;
    private String email;
    private String address;
    private int status;
    private int data_access_limit;
    private int is_supper;
    private String last_login;
    private int group_id;
    private String group_name;

    public CmsAccountInfo() {
    }

    public CmsAccountInfo(int id, String user_name, String full_name, String phone,
                          String email, String address, int status, int data_access_limit, int is_supper, String last_login, int group_id, String group_name) {
        this.id = id;
        this.user_name = user_name;
        this.full_name = full_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.data_access_limit = data_access_limit;
        this.is_supper = is_supper;
        this.last_login = last_login;
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getData_access_limit() {
        return this.data_access_limit;
    }

    public void setData_access_limit(int data_access_limit) {
        this.data_access_limit = data_access_limit;
    }

    public int getIs_supper() {
        return this.is_supper;
    }

    public void setIs_supper(int is_supper) {
        this.is_supper = is_supper;
    }

    public String getLast_login() {
        return this.last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public int getGroup_id() {
        return this.group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String toString() {
        return "CmsAccountInfo [id=" + this.id + ", user_name=" + this.user_name + ", full_name=" + this.full_name + ", phone=" + this.phone + ", email=" + this.email + ", address=" + this.address + ", status=" + this.status + ", data_access_limit=" + this.data_access_limit + ", is_supper=" + this.is_supper + ", last_login=" + this.last_login + ", group_id=" + this.group_id + ", group_name=" + this.group_name + "]";
    }
}
