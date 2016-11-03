package com.example;

import static org.apache.geode.cache.RegionShortcut.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoaderTest {

  private static final String REGION_NAME = "SERVICE_REQUEST";
  private static final String FILE_LOCATION = "311-sample.csv";
  private Cache cache;
  private Region region;

  @Before
  public void setUp() throws Exception {
    cache = new CacheFactory().set("mcast-port", "0").set("log-level", "config").create();
    region = cache.createRegionFactory(LOCAL).create(REGION_NAME);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void validateCacheServerAndRegionCreation() {
    assertFalse(cache.isClosed());
    assertTrue(region.isEmpty());
    assertEquals(region, cache.getRegion(REGION_NAME));
  }


  @Test
  public void createLoaderWithRegionAndLoadFile() throws IOException {
//    loader = new Loader(FILE_LOCATION, region);
    assertEquals(region.size(), Files.lines(Paths.get(FILE_LOCATION)).count());
  }

  @Test
  public void loadSample() throws Exception {

  }

  @Test
  public void process() throws Exception {

  }

}