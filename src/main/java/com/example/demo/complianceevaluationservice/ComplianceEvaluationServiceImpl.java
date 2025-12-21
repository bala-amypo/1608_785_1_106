// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.*;
// import com.example.demo.service.ComplianceEvaluationService;

// import java.time.LocalDateTime;
// import java.util.List;

// public class ComplianceEvaluationServiceImpl
//         implements ComplianceEvaluationService {

//     private final SensorReadingRepository readingRepository;
//     private final ComplianceThresholdRepository thresholdRepository;
//     private final ComplianceLogRepository logRepository;

//     public ComplianceEvaluationServiceImpl(
//             SensorReadingRepository readingRepository,
//             ComplianceThresholdRepository thresholdRepository,
//             ComplianceLogRepository logRepository) {

//         this.readingRepository = readingRepository;
//         this.thresholdRepository = thresholdRepository;
//         this.logRepository = logRepository;
//     }

//     public ComplianceLog evaluateReading(Long readingId) {

//         SensorReading reading = readingRepository.findById(readingId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Reading not found"));

//         String sensorType = reading.getSensor().getSensorType();

//         ComplianceThreshold threshold =
//                 thresholdRepository.findBySensorType(sensorType)
//                         .orElseThrow(() ->
//                                 new ResourceNotFoundException("Threshold not found"));

//         String status;
//         if (reading.getReadingValue() >= threshold.getMinValue()
//                 && reading.getReadingValue() <= threshold.getMaxValue()) {
//             status = "SAFE";
//         } else {
//             status = "UNSAFE";
//         }

//         List<ComplianceLog> existingLogs =
//                 logRepository.findBySensorReading_Id(readingId);

//         ComplianceLog log;
//         if (existingLogs.isEmpty()) {
//             log = new ComplianceLog(
//                     reading,
//                     threshold,
//                     status,
//                     "Evaluated",
//                     LocalDateTime.now()
//             );
//         } else {
//             log = existingLogs.get(0);
//             log.setStatusAssigned(status);
//             log.setLoggedAt(LocalDateTime.now());
//         }

//         return logRepository.save(log);
//     }

//     public List<ComplianceLog> getLogsByReading(Long readingId) {
//         return logRepository.findBySensorReading_Id(readingId);
//     }

//     public ComplianceLog getLog(Long id) {
//         return logRepository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Log not found"));
//     }
// }
