package com.bithappens.repository;

import com.bithappens.entity.Band;

import java.util.List;

public interface BandRepository {

    List<Band> findAll();

    Band findById(Integer id);

}
