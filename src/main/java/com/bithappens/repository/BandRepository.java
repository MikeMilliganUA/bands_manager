package com.bithappens.repository;

import com.bithappens.entity.Band;

import java.sql.SQLException;
import java.util.List;

public interface BandRepository {

    List<Band> findAll() throws SQLException;

    Band findById(Integer id) throws SQLException;

}
