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
                    while (rs.next()) result.add(extractBand(rs));
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Band findById(Integer id) {
        String sql = "SELECT * FROM bands WHERE id = ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) extractBand(rs);
                    return extractBand(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Band> findGroupsEstimatedAfter(Integer year) {
        List<Band> result = new ArrayList<>();
        String sql = "SELECT * FROM bands WHERE year > ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, year);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) result.add(extractBand(rs));
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Band extractBand(ResultSet rs) throws SQLException {
        Band band = new Band();
        band.setId(rs.getInt("id"));
        band.setName(rs.getString("name"));
        band.setCountry(rs.getString("country"));
        band.setGenre(rs.getString("genre"));
        band.setYear(rs.getInt("year"));
        band.setAlbumsCount(rs.getInt("albums_count"));
        return band;
    }
}

