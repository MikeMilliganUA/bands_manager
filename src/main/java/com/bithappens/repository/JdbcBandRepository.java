package com.bithappens.repository;

import com.bithappens.entity.Band;
import com.bithappens.utils.DbUtils;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBandRepository implements BandRepository {


    @Override
    public List<Band> findAll() {
        List<Band> result = new ArrayList<>();
        String sql = "SELECT * FROM bands";
        try (Connection connection = DbUtils.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(sql)) {
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
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Band findById(Integer id) {
        Band band = null;
        String sql = "SELECT * FROM bands WHERE index = ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        band = new Band();
                        band.setIndex(rs.getInt("index"));
                        band.setName(rs.getString("name"));
                        band.setCountry(rs.getString("country"));
                        band.setGenre(rs.getString("genre"));
                        band.setYear(rs.getInt("year"));
                        band.setAlbumsCount(rs.getInt("albumsCount"));
                    }
                    return band;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

