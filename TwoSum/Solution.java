package TwoSum;
import java.util.HashMap;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author ASUS-NB
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Solution so = new Solution();
		int a[] = {2,7,11,15};
		int ans[] = so.twosum(a,9);
		if(ans!=null){
			for(int i = 0;i<2;i++){
				System.out.println(ans[i]);
			}
		}
	}
	//这种方式会比增加一个循环专用来放map要快
	public int[] twosum(int []numbers,int target){
		HashMap<Integer,Integer> map = new HashMap();
		for(int i = 0;i<numbers.length;i++){
			int b  = target - numbers[i];
			Integer j = map.get(b);
			if(j!=null){
				//以j开头是因为只用一个循环的时候，i每次代表的是当前这个数，也就是实际上的后一个数
				return new int[]{j+1,i+1};
			}
            map.put(numbers[i],i);
		}
		return null;
	}

}
