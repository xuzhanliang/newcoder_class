package Chapter1;
/**
 * 给定一个数组，每个值代表柱子的高度，柱子之间的距离围成一个面积
 * 面积=两根柱子的最小值*两根柱子之间的距离
 * [3，4，2，5] 返回6
 * 求哪两个柱子围城的面积最大，并返回
 * @author xyuser
 *
 */
public class BarProblem {
	public static int maxArea(int[] arr){
		if(arr == null || arr.length < 3){
			return 0;
		}
		int l = 0;
		int r = arr.length - 1;
		int res = Integer.MIN_VALUE;
		while (l < r){
			if(arr[l] < arr[r]){
				res = Math.max(res, (r - l - 1) * arr[l++]);
			}else{
				res = Math.max(res,(r - l - 1) * arr[r--]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int arr[] =  {3,4,2,5};
		int res = maxArea(arr);
		System.out.println(res);
	}
}
