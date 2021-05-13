package com.soma.pgui.model;

import java.io.Serializable;

public class Post implements Serializable {

  private int userId;
  private int id;
  private String title;
  private String body;

  // getters and setters
  @Override
  public String toString() {
    return userId + " " + id + " " + title + " " + body;
  }
}