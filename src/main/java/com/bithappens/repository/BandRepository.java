package com.bithappens.repository;

import entity.Band;

import java.util.List;

public interface BandRepository {

    List<Band> findAll();

}
