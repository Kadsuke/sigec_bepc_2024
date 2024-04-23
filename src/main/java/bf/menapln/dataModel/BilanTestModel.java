/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.dataModel;

/**
 *
 * @author coulibaly
 */
public class BilanTestModel {
    private String entity;
    private Integer total;
    private Integer totalImportable;
    private Integer totalDoublon;
    
    public BilanTestModel(String entity,Integer total,Integer totalImportable,Integer totalDoublon){
        this.entity = entity;
        this.total = total;
        this.totalImportable = totalImportable;
        this.totalDoublon = totalDoublon;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalImportable() {
        return totalImportable;
    }

    public void setTotalImportable(Integer totalImportable) {
        this.totalImportable = totalImportable;
    }

    public Integer getTotalDoublon() {
        return totalDoublon;
    }

    public void setTotalDoublon(Integer totalDoublon) {
        this.totalDoublon = totalDoublon;
    }
    
}
