package com.bithappens.repository;

import com.bithappens.entity.Band;
import com.bithappens.utils.DbUtils;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBandRepository implements BandRepository {


    @Override
    public List<Band> findAll() throws SQLException {
        List<Band> result = new ArrayList<>();

        Statement statement = DbUtils.getConnection().createStatement();
        String sql = "SELECT * FROM bands";
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
    public Band findById(Integer id) throws SQLException {
        Band band = null;
        String sql = "SELECT * FROM bands WHERE index = ?";
        PreparedStatement ps = DbUtils.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            band = new Band();
            band.setIndex(rs.getInt("index"));
            band.setName(rs.getString("name"));
            band.setCountry(rs.getString("country"));
            band.setGenre(rs.getString("genre"));
            band.setYear(rs.getInt("year"));
            band.setAlbumsCount(rs.getInt("albumsCount"));
        }
        rs.close();
        ps.close();
        return band;
    }
}

