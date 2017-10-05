package ru.bobans.map_obj;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class Fcik extends Afcik{
    public Fcik(){
    }
    public Fcik(ResultSet rs) throws SQLException {
        mapResult(rs);
    }

    public void mapResult(ResultSet rs) throws SQLException{
        try {
            Field[] fields = Afcik.class.getDeclaredFields();
            ResultSetMetaData resultSetMetaData =  rs.getMetaData();
            for (Field field : fields) {
                for (int i=1;i<=resultSetMetaData.getColumnCount(); i++) {
                    if (resultSetMetaData.getColumnName(i).equals(field.getName().toUpperCase() )){
                        switch (resultSetMetaData.getColumnType(i)) {
                            default: field.set(this, rs.getString(field.getName())); break;
                        }
                    }
                }

            }
        } catch (SecurityException
                | IllegalArgumentException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /*----------------------*/
    public String toString(){
        StringBuilder out_ret = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Field[] fields = Afcik.class.getDeclaredFields();
        try {
            for (Field field : fields) {

                if (out_ret.length()>0) {
                    out_ret.append("\t");
                }

                if ( field.getGenericType().getTypeName().toString().equals("java.sql.Timestamp")) {
                    out_ret.append(field.get(this)==null?"":sdf.format(field.get(this)));
                } else  out_ret.append(field.get(this)==null?"":field.get(this).toString().replaceAll("(\r\n|\n)","") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  out_ret.toString();
    }



}
