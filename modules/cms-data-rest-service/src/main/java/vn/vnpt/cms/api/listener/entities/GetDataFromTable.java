package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class GetDataFromTable {
    private List<Column> headers;
    private Object data;

    public GetDataFromTable() {
    }

    public List<Column> getHeaders() {
        return this.headers;
    }

    public void setHeaders(List<Column> headers) {
        this.headers = headers;
    }

    public Object getItems() {
        return this.data;
    }

    public void setItems(Object items) {
        this.data = items;
    }

    public String toString() {
        return "GetDataFromTable [headers.size=" + (this.headers == null ? null : this.headers.size()) + ", items.size=" + (this.data) + "]";
    }
}
