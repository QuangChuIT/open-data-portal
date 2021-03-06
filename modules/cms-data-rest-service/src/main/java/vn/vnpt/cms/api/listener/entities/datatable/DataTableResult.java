package vn.vnpt.cms.api.listener.entities.datatable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataTableResult {
    /**
     * The draw.
     */
    private int draw;

    /**
     * The records filtered.
     */
    private int recordsFiltered;

    /**
     * The records total.
     */
    private int recordsTotal;

    /**
     * The list of data objects.
     */
    @SerializedName("data")
    List<Object> listOfDataObjects;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<Object> getListOfDataObjects() {
        return listOfDataObjects;
    }

    public void setListOfDataObjects(List<Object> listOfDataObjects) {
        this.listOfDataObjects = listOfDataObjects;
    }
}
