package com.society.platform.notification.push;

public class PushNotificationService {
  public String send(String token) {
    return "PUSH-" + token;
  }
}
