package com.tsungmn.timer.visit.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    name = "visitor_log",
    indexes = @Index(name = "idx_visit_date", columnList = "visitDate")
)
public class Visit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 64, nullable = false)
  private String cookieId;

  @Column(nullable = false)
  private Instant visitDate;

  private Visit(String cookieId, Instant visitDate) {
    this.cookieId = cookieId;
    this.visitDate = visitDate;
  }

  public static Visit of(String cookieId, Instant visitDate) {
    return new Visit(cookieId, visitDate);
  }
}