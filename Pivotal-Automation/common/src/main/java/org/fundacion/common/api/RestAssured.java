package org.fundacion.common.api;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.Properties;

import org.fundacion.common.objectReader.ReadObject;


/**
 * Created by RoyRodriguez on 12/23/2016.
 */
public class RestAssured {
  private Properties configurationObj;
  private String url;
  private String token;
  private String keyToken;

  public RestAssured() throws IOException {
    ReadObject object = new ReadObject();
    configurationObj = object.getObjectRepository();

    url = configurationObj.getProperty("urlApi");
    token = configurationObj.getProperty("token");
    keyToken = configurationObj.getProperty("keyToken");

  }

  public JsonPath get(String endPoint) {
    String finalUrl = url + "/" + endPoint;
    JsonPath response = given().header(keyToken, token).get(finalUrl).jsonPath();
    return response;
  }

  public boolean delete(String endPoint) {
    boolean res = false;
    String finalUrl = url + "/" + endPoint;
    if (given().header(keyToken, token).delete(finalUrl).statusCode() == 204) {
      res = true;
    }

    return res;
  }

}