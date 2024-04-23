package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeSituation extends Type{
    public TypeSituation(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("typeSituation_id"));
        this.setLibelle(rs.getString("typeSituationLibelle"));
    }
}
