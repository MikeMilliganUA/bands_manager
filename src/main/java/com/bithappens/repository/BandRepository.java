package com.bithappens.repository;

import com.bithappens.entity.Band;

import java.util.List;

public interface BandRepository {

    List<Band> findAll();

    Band findById(Integer id);

    List<Band> findGroupsEstimatedAfter(Integer year);

    void deleteById(Integer id);

    List<Band> bandByGenre(String s);

    void addNewBand(Integer id, String name, String country, String genre, Integer year);
}
