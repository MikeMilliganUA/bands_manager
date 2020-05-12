package com.bithappens.repository;

import com.bithappens.entity.Band;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBandRepository implements BandRepository {

    @Override
    public List<Band> findAll() throws SQLException {
        List<Band> result = new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/bands_db";
        String user = "postgres";
        String password = "sacred";

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        String sql = "select * from bands";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            Band band = new Band();
            band.setIndex(rs.getInt("index"));
            band.setName(rs.getString("name"));
            band.setCountry(rs.getString("country"));
            band.setGenre(rs.getString("genre"));
            band.setYear(rs.getInt("year"));
            band.setAlbumsCount(rs.getInt("albumsCount"));

            result.add(band);
    }
        rs.close();
        statement.close();
        return result;
    }

    @Override
    public List<Band> findById() throws SQLException {
        return null;
    }
}
