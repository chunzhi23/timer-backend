package com.tsungmn.timer.visit.dto;

import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class VisitRequest {

  @NotNull(message = "CookieId is missing")
  private String cookieId;

  @NotNull(message = "visitDate is missing")
  private Instant visitDate;
}
