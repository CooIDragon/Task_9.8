package ru.vsu.cs.baturin_v_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindingElementsThatOnlyInOneList {
    public List<Integer> isOnlyInTheFirstAndSecondList(List<Integer> list1, List<Integer> list2) {
        List<Integer> inList1NotInList2 = isOnlyInOneListNotInAnother(list1, list2);
        List<Integer> inList2NotInList1 = isOnlyInOneListNotInAnother(list2, list1);
        inList1NotInList2.addAll(inList2NotInList1);
        return inList1NotInList2;
    }

    public List<Integer> isOnlyInOneListNotInAnother(List<Integer> list1, List<Integer> list2) {
        List<Integer> elementsLocatedOnlyInOneListNotInOther = new ArrayList<>();
        int tmp;
        for (Integer value : list1) {
            tmp = 0;
            for (Integer integer : list2) {
                if (Objects.equals(value, integer)) {
                    tmp++;
                }
            }
            if (tmp == 0) {
                elementsLocatedOnlyInOneListNotInOther.add(value);
            }
        }
        return elementsLocatedOnlyInOneListNotInOther;
    }
}
