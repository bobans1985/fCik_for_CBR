package ru.bobans.Response;


import ru.bobans.Utils.NamedParameterStatement;
import ru.bobans.Utils.PrefSettings;
import ru.bobans.map_obj.Fcik;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class fcikResponse {
    List<Fcik> fcikList=new ArrayList<Fcik>();
    int count=0;



    public fcikResponse(Connection con, String date, String kod, String ser, String nomer) throws SQLException,Exception  {
        String query = new PrefSettings().GetSettingsFromConfig("QUERY");
        NamedParameterStatement stmt = new NamedParameterStatement(con, query);

            System.out.format("Usage params in select: <1>= %s | <2>= %s | <3>= %s | <4>= %s \r\n", kod, ser,nomer,date);
            stmt.setString("p1", kod);
            stmt.setString("p2", ser);
            stmt.setString("p3", nomer);
            stmt.setString("p4", date);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fcik fcik=new Fcik(rs);
                fcikList.add(fcik);
                count++;
            }
        stmt.close();
    }

    public List<Fcik> getFcikList() {
        return fcikList;
    }

    public int getCount() {
        return count;
    }
}

