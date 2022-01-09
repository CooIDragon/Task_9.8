package ru.vsu.cs.baturin_v_a;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.baturin_v_a.util.ArrayUtils;
import ru.vsu.cs.baturin_v_a.util.ListUtils;

import java.util.List;

public class FindingElementsThatOnlyInOneListTest {
    FindingElementsThatOnlyInOneList findingElementsThatOnlyInOneList = new FindingElementsThatOnlyInOneList();

    @Test
    public void testNormalNumsWithOdd() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput1.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_1.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput1.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testNormalNumsWithEven() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_2.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput2.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testOddNumsWithEven() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput3.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_3.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput3.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testManyEqualNums() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput4.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_4.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput4.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testDifferentLength() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput5.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_5.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput5.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testBigNums() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput6.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_6.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput6.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testEqualNumsInOneList() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput7.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_7.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput7.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testReverseLists() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput8.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_8.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput8.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testNegativeNums() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput9.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_9.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput9.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }

    @Test
    public void testOnlyOneElementInEachList() {
        int[] array1 = ArrayUtils.readIntArrayFromFile("testSrc/testInput10.txt");
        int[] array2 = ArrayUtils.readIntArrayFromFile("testSrc/testInput2_10.txt");
        List<Integer> list1 = ListUtils.intArrayToList(array1);
        List<Integer> list2 = ListUtils.intArrayToList(array2);

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput10.txt");

        List<Integer> factualResultInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
        int[] factualResultInArray = ListUtils.intListToArray(factualResultInList);

        Assert.assertArrayEquals(expectedResult, factualResultInArray);
    }
}