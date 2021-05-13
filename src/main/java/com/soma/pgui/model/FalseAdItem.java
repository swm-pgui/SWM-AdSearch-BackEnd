package com.soma.pgui.model;

import java.io.Serializable;

public class FalseAdItem implements Serializable {
  private int userId;
  private int id;
  private String title;
  private String body;
  // getters and setters

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return title + body; // + " " + id + " " + title + " " + body;
  }
}