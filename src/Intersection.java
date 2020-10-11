import java.util.*;

class Intersection {
  public int[] intersection(final int[] nums1, final int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int m = nums1.length;
    int n = nums2.length;
    Set<Integer> resultSet = new TreeSet<>();
    

    System.out.println("m=" + m);
    System.out.println("n=" + n);
    int i = 0, j = 0;
    int c = 0;
    while (i < m && j < n) {
      if (nums1[i] == nums2[j]) {
        System.out.println("Adding nums1[i] to result list = "+nums1[i]);
        resultSet.add(nums1[i]);
        i++;j++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      }

    }

    return resultSet.stream().mapToInt(obj -> obj).toArray();
  }

  public static void main(final String[] args) {
    //[4,9,5]
//[9,4,9,8,4]
    final int nums1[] = new int[] { 4,9,5 };
    final int nums2[] = new int[] { 9,4,9,8,4 };
    final Intersection intersection = new Intersection();
    System.out.println(Arrays.toString(intersection.intersection(nums1, nums2)));

  }
}