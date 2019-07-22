package dream.entity;

import java.util.List;
public class Data {
    private List<List<TableFileds>> filedsList;
    private List<Tables> tables;

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
    }

    public List<List<TableFileds>> getFiledsList() {
        return filedsList;
    }

    public void setFiledsList(List<List<TableFileds>> filedsList) {
        this.filedsList = filedsList;
    }
}
