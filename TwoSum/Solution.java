package TwoSum;
import java.util.HashMap;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 ע�⣬�����index�����Ǹ�ֵ��ʱ��
 �����������������index��ʱ���ø�������map�������ֻ�����������±꣬�������������������������飩��
 * @author ASUS-NB
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Solution so = new Solution();
		int a[] = {2,7,11,15};
		int ans[] = so.twosum(a,4);
		if(ans!=null){
			for(int i = 0;i<2;i++){
				System.out.println(ans[i]);
			}
		}
	}
	//���ַ�ʽ�������һ��ѭ��ר������mapҪ��
	public int[] twosum(int []numbers,int target){
		HashMap<Integer,Integer> map = new HashMap();
		for(int i = 0;i<numbers.length;i++){
			int b  = target - numbers[i];
			if(map.containsKey(b)){
				//��j��ͷ����Ϊֻ��һ��ѭ����ʱ��iÿ�δ�����ǵ�ǰ�������Ҳ����ʵ���ϵĺ�һ����
				return new int[]{map.get(b)+1,i+1};
			}
			map.put(numbers[i],i);
		}
		return null;
	}

}
