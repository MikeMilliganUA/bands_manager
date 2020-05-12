package com.bithappens.repository;

import com.bithappens.entity.Band;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcBandRepositoryTest {
    @Test
    public void findAll() throws Exception {
        BandRepository bandRepository = new JdbcBandRepository();
        List<Band> allBands = bandRepository.findAll();

        System.out.println(allBands);

    }

}