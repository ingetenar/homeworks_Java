package Challenge12_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array_methods {

    public static int[] sortDescending(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(result);

        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        return result;
    }

    public static int[] removeDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int number : array) {
            set.add(number);
        }

        int[] result = new int[set.size()];
        int index = 0;

        for (int number : set) {
            result[index++] = number;
        }

        return result;
    }

    public static int[] findCommonElements(int[] firstArray, int[] secondArray) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> commonSet = new HashSet<>();

        for (int number : firstArray) {
            firstSet.add(number);
        }

        for (int number : secondArray) {
            if (firstSet.contains(number)) {
                commonSet.add(number);
            }
        }

        int[] result = new int[commonSet.size()];
        int index = 0;

        for (int number : commonSet) {
            result[index++] = number;
        }

        return result;
    }

    public static int[] findTwoElementsClosestToZero(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        int left = 0;
        int right = sortedArray.length - 1;

        int firstNumber = sortedArray[left];
        int secondNumber = sortedArray[right];
        int closestSum = Math.abs(firstNumber + secondNumber);

        while (left < right) {
            int sum = sortedArray[left] + sortedArray[right];

            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                firstNumber = sortedArray[left];
                secondNumber = sortedArray[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{firstNumber, secondNumber};
    }

    public static int[] findLongestConsecutiveSequence(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int number : array) {
            set.add(number);
        }

        int longestStart = 0;
        int longestLength = 0;

        for (int number : set) {
            if (!set.contains(number - 1)) {
                int currentNumber = number;
                int currentLength = 1;

                while (set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentLength++;
                }

                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestStart = number;
                }
            }
        }

        int[] result = new int[longestLength];

        for (int i = 0; i < longestLength; i++) {
            result[i] = longestStart + i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {49, 1, 3, 200, 2, 4, 70, 5};
        int[] arrayWithDuplicates = {1, 2, 2, 3, 4, 4, 5};
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {3, 4, 5, 6, 7};
        int[] mixedArray = {-8, -66, -60, 5, 3, 7};

        System.out.println(Arrays.toString(sortDescending(array)));
        System.out.println(Arrays.toString(removeDuplicates(arrayWithDuplicates)));
        System.out.println(Arrays.toString(findCommonElements(firstArray, secondArray)));
        System.out.println(Arrays.toString(findTwoElementsClosestToZero(mixedArray)));
        System.out.println(Arrays.toString(findLongestConsecutiveSequence(array)));
    }
}