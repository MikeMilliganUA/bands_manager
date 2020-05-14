package com.bithappens.repository;

import com.bithappens.entity.Band;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcBandRepositoryTest {

    private BandRepository bandRepository;

    @Before
    public void setUp() throws Exception {             //Exception?
        bandRepository = new JdbcBandRepository();
    }

    @Test
    public void testFindAll() {
        List<Band> allBands = bandRepository.findAll();
        System.out.println(allBands);
    }

    @Test
    public void testFindById() {
        Band band = bandRepository.findById(25);
        System.out.println(band);
    }
}