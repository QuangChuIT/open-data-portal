package vn.vnpt.cms.api.listener.entities;

public class CmsCategoryInfo {
    private int category_id;
    private String cat_table_name;
    private String cat_full_name;
    private int cat_type;
    private int status;
    private int[] children;

    public CmsCategoryInfo() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCat_table_name() {
        return this.cat_table_name;
    }

    public void setCat_table_name(String cat_table_name) {
        this.cat_table_name = cat_table_name;
    }

    public String getCat_full_name() {
        return this.cat_full_name;
    }

    public void setCat_full_name(String cat_full_name) {
        this.cat_full_name = cat_full_name;
    }

    public int getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(int cat_type) {
        this.cat_type = cat_type;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int[] getChildren() {
        return this.children;
    }

    public void setChildren(int[] children) {
        this.children = children;
    }
}
