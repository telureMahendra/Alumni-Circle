package com.society.platform.common.utils;

public final class CommonUtils {
  private CommonUtils() {
  }

  public static String normalize(String value) {
    if (value == null) {
      return "";
    }
    return value.trim();
  }
}
