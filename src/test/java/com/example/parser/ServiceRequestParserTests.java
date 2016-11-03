package com.example.parser;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.model.ServiceRequest;
import org.junit.Before;
import org.junit.Test;

public class ServiceRequestParserTests {

  ServiceRequestParser parser;

  @Before
  public void setup () {
    parser = new ServiceRequestParser();
  }

	@Test
  public void testDateFormatParsing() throws ParseException {
    final String inputDate="09/16/2016 07:13:22 AM";
    parser = new ServiceRequestParser();
    long dateToLong = parser.convertStringDateToLong(inputDate);

    assertNotNull(dateToLong);

    Date dateForComparison = new Date(dateToLong);
    assertEquals(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a").format(dateForComparison), inputDate);

  }

  @Test
  public void testSuccessfulParsing() throws ParseException {
    String line = "34326532,09/15/2016 07:00:10 PM,09/15/2016 09:00:25 PM,NYPD,New York City Police Department,Illegal Parking,Blocked Sidewalk,Street/Sidewalk,11103,41-18 ASTORIA BOULEVARD SOUTH,ASTORIA BOULEVARD SOUTH,41 STREET,42 STREET,,,ADDRESS,ASTORIA,,Precinct,Closed,09/16/2016 03:00:10 AM,The Police Department responded to the complaint and with the information available observed no evidence of the violation at that time.,09/15/2016 09:00:25 PM,01 QUEENS,QUEENS,1009259,219329,Unspecified,QUEENS,Unspecified,Unspecified,Unspecified,Unspecified,Unspecified,Unspecified,Unspecified,Unspecified,Unspecified,N,,,,,,,,,,,,40.768648447410236,-73.90971325603968,\"(40.768648447410236, -73.90971325603968)\"";

    ServiceRequest request = parser.parseLine(line.split(",")).get();

    assertThat(request.getDescriptor(), is("Blocked Sidewalk"));
    assertThat(request.getAgency(), is("NYPD"));
    assertThat(request.getLatitude(), is(40.76865F));
    //TODO: add more checks

  }

//  @Test
//  public void testSimpleParse() throws Exception {
//    parser.load();
//  }
//
//
//  @Test
//  public void testParsingLine() throws Exception {
//    parser = new ServiceRequestParser(fileLocation);
//    parser.parseLine(null);
//  }
}
