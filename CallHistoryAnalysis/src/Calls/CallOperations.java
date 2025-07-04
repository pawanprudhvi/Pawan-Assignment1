package Calls;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CallOperations {
    private List<CallRecord> records = new ArrayList<>();

    public void addRecord(CallRecord record) {
        records.add(record);
    }

    public List<CallRecord> filter(Predicate<CallRecord> condition) {
        return records.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public List<CallRecord> sortByDurationDescending() {
        return records.stream()
                .sorted(Comparator.comparingInt(CallRecord::getDuration).reversed())
                .collect(Collectors.toList());
    }

    public Map<String, List<CallRecord>> groupByOperator() {
        return records.stream()
                .collect(Collectors.groupingBy(CallRecord::getOperator));
    }

    public Map<String, List<CallRecord>> groupByLocation() {
        return records.stream()
                .collect(Collectors.groupingBy(CallRecord::getLocation));
    }
    
    public Map<String, Long> countCallsByCaller() {
        return records.stream()
                       .collect(Collectors
                       .groupingBy(CallRecord::getCaller, Collectors.counting()));
    }

    public int totalCallDuration() {
        return records.stream()
                .mapToInt(CallRecord::getDuration)
                .sum();
    }

    public List<CallRecord> getAllRecords() {
        return records;
    }
}