import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        int[] sortedArray = sortArray(nums);

        for (int i : sortedArray) {
            System.out.print("" + i + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        int largestNumber = findLargestNumber(nums);
        int increment = 1;

        ArrayList<Integer>[] bins = new ArrayList[10];
        int[] sortedNums = new int[nums.length];

        while (increment <= largestNumber) {

            // adding to bins
            for (int num : nums) {
                int divider = (num / increment) % 10;
                if (bins[divider] != null) {
                    bins[divider].add(num);
                } else {
                    bins[divider] = new ArrayList<>();
                    bins[divider].add(num);
                }
            }

            // clear the bins
            int sortedNumsPointer = 0;
            for (int i = 0; i < bins.length; i++) {
                if (bins[i] != null) {
                    for (int bin : bins[i]) {
                        sortedNums[sortedNumsPointer] = bin;
                        sortedNumsPointer++;
                    }
                    bins[i] = new ArrayList<>();
                }
            }

            nums = sortedNums;
            increment *= 10;
        }
        return sortedNums;
    }

    private static int findLargestNumber(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}

