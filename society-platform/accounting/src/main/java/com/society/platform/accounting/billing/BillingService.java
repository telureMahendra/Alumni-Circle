package com.society.platform.accounting.billing;

public class BillingService {
  public String generateInvoice(String accountId) {
    return "INV-" + accountId;
  }
}
