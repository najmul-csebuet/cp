package mylib;

public class BinarySearch {
    static int lower_bound(Integer[] arr, int l, int r, int X) {
        int mid;

        // Initialise starting index and
        // ending index
        int low = l;
        int high = r;

        // Till low is less than high
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X > arr[mid]) {
                // If X is greater arr[mid]
                // then find in right sub array
                low = mid + 1;
            } else {
                // If X is less than or equal
                // to arr[mid], then find in
                // left sub array
                high = mid;
            }
        }

        // if X is greater than arr[n-1]
        if (low <= r && arr[low] < X) {
            low++;
        }

        // Return the lower_bound index
        return low;
    }

    // tested ok
    static int upper_bound(Integer[] arr, int l, int r, int X) {
        int mid;

        // Initialise starting index and
        // ending index
        int low = l;
        int high = r;

        // Till low is less than high
        while (low < high) {
            // Find the middle index
            mid = low + (high - low) / 2;

            // If X is greater than or equal
            // to arr[mid] then find
            // in right subarray
            if (X >= arr[mid]) {
                low = mid + 1;
            }

            // If X is less than arr[mid]
            // then find in left sub array
            else {
                high = mid;
            }
        }

        // if X is greater than arr[n-1]
        if (low <= r && arr[low] <= X) {
            low++;
        }

        // Return the upper_bound index
        return low;
    }
}
