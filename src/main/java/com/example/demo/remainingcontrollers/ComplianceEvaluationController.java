// package com.example.demo.controller;

// import com.example.demo.entity.ComplianceLog;
// import com.example.demo.service.ComplianceEvaluationService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/compliance")
// public class ComplianceEvaluationController {

//     private final ComplianceEvaluationService evaluationService;

//     public ComplianceEvaluationController(
//             ComplianceEvaluationService evaluationService) {
//         this.evaluationService = evaluationService;
//     }

//     @PostMapping("/evaluate/{readingId}")
//     public ComplianceLog evaluate(@PathVariable Long readingId) {
//         return evaluationService.evaluateReading(readingId);
//     }

//     @GetMapping("/reading/{readingId}")
//     public List<ComplianceLog> logs(@PathVariable Long readingId) {
//         return evaluationService.getLogsByReading(readingId);
//     }

//     @GetMapping("/{id}")
//     public ComplianceLog get(@PathVariable Long id) {
//         return evaluationService.getLog(id);
//     }
// }
