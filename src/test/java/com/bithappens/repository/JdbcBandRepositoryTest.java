package com.bithappens.repository;

import com.bithappens.entity.Band;
import org.junit.Test;

import java.util.List;

public class JdbcBandRepositoryTest {
    @Test
    public void testFindAll() throws Exception {

        BandRepository bandRepository = new JdbcBandRepository();
        List<Band> allBands = bandRepository.findAll();

        System.out.println(allBands);
    }

    @Test
    public void testFindById() throws Exception {

        JdbcBandRepository repository = new JdbcBandRepository();
        Band band = repository.findById(25);

        System.out.println(band);
    }

}