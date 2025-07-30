package com.tsungmn.timer.visit.controller;

import com.tsungmn.timer.visit.dto.VisitRequest;
import com.tsungmn.timer.visit.dto.VisitResponse;
import com.tsungmn.timer.visit.service.VisitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visit")
public class VisitController {

  private final VisitService visitService;

  @PostMapping
  public ResponseEntity<VisitResponse> createVisit(@RequestBody @Valid VisitRequest visitRequest) {
    VisitResponse visitResponse = visitService.createVisit(visitRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(visitResponse);
  }

  @GetMapping("/total")
  public ResponseEntity<Long> getTotalVisits() {
    List<VisitResponse> visitResponseList = visitService.getTotalVisits();
    return ResponseEntity.ok((long) visitResponseList.size());
  }

  @GetMapping("/today")
  public ResponseEntity<Long> getTodayVisits() {
    List<VisitResponse> visitResponseList = visitService.getTodayVisits();
    return ResponseEntity.ok((long) visitResponseList.size());
  }
}