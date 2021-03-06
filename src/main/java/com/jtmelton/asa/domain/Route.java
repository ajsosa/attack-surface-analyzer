package com.jtmelton.asa.domain;

import com.google.common.base.MoreObjects;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

public class Route {
  private String fileName;
  private String method;
  private String path;
  private Collection<Parameter> parameters;

  public Route(String fileName, String method, String path, Collection<Parameter> parameters) {
    this.fileName = fileName;
    this.method = method;
    this.path = path;
    this.parameters = parameters;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Collection<Parameter> getParameters() {
    return parameters;
  }

  public void setParameters(Collection<Parameter> parameters) {
    this.parameters = parameters;
  }

  public JSONObject toJSON() {
    JSONObject route = new JSONObject();
    route.put("fileName", fileName);
    route.put("path", path);
    route.put("method", method);

    JSONArray jsonParameters = new JSONArray();
    route.put("parameters", jsonParameters);

    for(Parameter parameter : parameters) {
      JSONObject jsonParam = new JSONObject();

      jsonParam.put("category", parameter.getCategory());
      jsonParam.put("name", parameter.getName());
      jsonParam.put("dataType", parameter.getDataType());

      jsonParameters.put(jsonParam);
    }

    return route;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("fileName", fileName)
        .add("method", method)
        .add("path", path)
        .add("parameters", parameters)
        .toString();
  }
}
