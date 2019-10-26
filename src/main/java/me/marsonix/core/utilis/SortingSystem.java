package me.marsonix.core.utilis;

import java.util.*;
import java.util.stream.Collectors;

public class SortingSystem {
    public static<K, V extends Comparable<? super V>> List<Map.Entry<K,V>> sortMapByValueAndGetList(Map<K, V>mapToSort){
        return  mapToSort.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());
    }
}
