
public class Main {

    public static void main(String[] args) {

        int[] a,b,c;

        for (int i=1;i<100;i++) {
            if (i % 2 != 0) {
                System.out.println(i+","+(i+1));
            }
        }

    }

    private static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int pi = partition(nums, low, high);

            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        int temp = 0;

        for (int j=low;j<high;j++) {
            if (nums[j] < pivot) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

}

