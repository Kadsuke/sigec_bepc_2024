/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class TourComposition extends Type{
    private Integer tourCode;
    
    
    public TourComposition(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("tourComposition_id"));
        this.setLibelle(rs.getString("tourCompositionLibelle"));
        this.setTourCode(rs.getInt("tourCode"));
    }

    
    public TourComposition() {
        super();
    }


    public static TourComposition id(Long id){
        TourComposition tourComposition = new TourComposition();
        tourComposition.setId(id);
        return tourComposition;
    }
    
    public Integer getTourCode() {
        return tourCode;
    }

    public void setTourCode(Integer tourCode) {
        this.tourCode = tourCode;
    }

}
