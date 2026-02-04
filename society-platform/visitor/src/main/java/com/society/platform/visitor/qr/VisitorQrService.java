package com.society.platform.visitor.qr;

public class VisitorQrService {
  public String createQr(String visitorId) {
    return "QR-" + visitorId;
  }
}
