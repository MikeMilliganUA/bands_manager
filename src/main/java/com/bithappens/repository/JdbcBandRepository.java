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
                        result.add(extractBand(rs));
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
        String sql = "SELECT * FROM bands WHERE id = ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        band = extractBand(rs);
                    }
                    return band;
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
                    while (rs.next()) {
                        result.add(extractBand(rs));
                    }
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM bands WHERE id = ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Band> bandByGenre(String s) {
        List<Band> result = new ArrayList<>();
        String sql = "SELECT * FROM bands WHERE genre = ?";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, s);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        result.add(extractBand(rs));
                    }
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewBand(String name, String country, String genre, Integer year) {
        String sql = "INSERT INTO bands (name, country, genre, year)" + " VALUES (?, ?, ?, ?)";
        try (Connection connection = DbUtils.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, country);
                ps.setString(3, genre);
                ps.setInt(4, year);
                ps.executeUpdate();
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
        return band;
    }
}

