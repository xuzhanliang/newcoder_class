package Chapter1;
/**
 * 数组[0,1,0,2,1,0,1,3,2,1,2,1]，就是黑色部分，求容器能装多少水
 * 最优解：时间复杂度O(N) 额外空间复杂度0(1)
 * @author xyuser
 *
 */
public class WaterProblem {
	public static int getWater(int[] arr){
		if(arr == null || arr.length<3){
			return 0;
		}
		int value =0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int l = 1;
		int r = arr.length-2;
		while(l<=r){
			if(leftMax <=rightMax){
				value += Math.max(0, leftMax - arr[l]);
				leftMax = Math.max(leftMax, arr[l++]);
			}else{
				value += Math.max(0, rightMax - arr[r]);
				rightMax = Math.max(rightMax, arr[r--]);
			}
		}
		return value;
	}
	public static void main(String[] args) {
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int value = getWater(arr);
		System.out.println(value);
	}
}
