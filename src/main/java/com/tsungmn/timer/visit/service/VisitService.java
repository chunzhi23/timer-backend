package com.tsungmn.timer.visit.service;

import com.tsungmn.timer.visit.domain.Visit;
import com.tsungmn.timer.visit.dto.VisitRequest;
import com.tsungmn.timer.visit.dto.VisitResponse;
import com.tsungmn.timer.visit.repository.VisitRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService {

  private final VisitRepository visitRepository;

  public VisitResponse createVisit(VisitRequest request) {
    Visit visit = Visit.of(request.getCookieId(), request.getVisitDate());
    Visit saved = visitRepository.save(visit);

    return VisitResponse.from(saved);
  }

  @Transactional(readOnly = true)
  public List<VisitResponse> getTotalVisits() {
    return visitRepository.findAll()
        .stream()
        .map(VisitResponse::from)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public List<VisitResponse> getTodayVisits() {
    LocalDate today = LocalDate.now(ZoneId.systemDefault());

    Instant startOfDay = today.atStartOfDay(ZoneId.systemDefault()).toInstant();
    Instant startOfNextDay = today.plusDays(1)
        .atStartOfDay(ZoneId.systemDefault())
        .toInstant();

    return visitRepository.findAll()
        .stream()
        .filter(v -> {
          Instant ts = v.getVisitDate();
          return !ts.isBefore(startOfDay) && ts.isBefore(startOfNextDay);
        })
        .map(VisitResponse::from)
        .collect(Collectors.toList());
  }
}
