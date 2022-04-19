package leetcode.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Duplicate
{

    @Test
    public void test() {
        int[] nums = new int[]{0,0,1};
        int k = removeDuplicates(nums);
        assert (k == 2);
        for (int i =0; i < k; i++ ) {
            assert(nums[i] == i);
        }
    }

    @Test
    public void test1() {
        int[] nums = new int[]{0,0,1,1,1,2,3,4,4,4,5};
        int k = removeDuplicates(nums);
        assert (k == 6);
        for (int i =0; i < k; i++ ) {
            assert(nums[i] == i);
        }
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        assert (k == 5);
        for (int i =0; i < k; i++ ) {
            assert(nums[i] == i);
        }
    }

    @Test
    public void test3() {
        int[] nums = new int[]{0};
        int k = removeDuplicates(nums);
        assert (k == 1);
        for (int i =0; i < k; i++ ) {
            assert(nums[i] == i);
        }
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1,1};
        int k = removeDuplicates(nums);
        assert (k == 1);
    }

//  --------------------------------
//    Code Starts
//  --------------------------------

    public int removeDuplicates(int[] nums) {
        int kIndex = 0;
        for (int i = 0; i < nums.length; ) {
            // last put at the end
            if (i == nums.length - 1) {
                nums[kIndex] = nums[i];
                kIndex += 1;
                break;
            } else if (nums[i] == nums[i + 1]) {
                // Looked Forward found a match lets see how many more
                int matchSkip = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        matchSkip++;
                    } else {
                        break;
                    }
                }
                // Get us the next;
                nums[kIndex] = nums[i + matchSkip -1];
                kIndex += 1;
                i += (matchSkip);
            } else {
                // No Match Set and move
                nums[kIndex] = nums[i];
                kIndex += 1;
                i++;
            }
        }
        return kIndex;
    }


}


