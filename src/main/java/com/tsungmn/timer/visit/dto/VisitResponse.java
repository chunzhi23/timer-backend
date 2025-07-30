package com.tsungmn.timer.visit.dto;

import com.tsungmn.timer.visit.domain.Visit;
import java.time.Instant;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VisitResponse {

  private Long id;
  private String cookieId;
  private Instant visitDate;

  public static VisitResponse from(Visit visit) {
    return new VisitResponse(
        visit.getId(),
        visit.getCookieId(),
        visit.getVisitDate()
    );
  }
}
