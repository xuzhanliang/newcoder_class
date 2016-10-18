package Chapter1;
/**
 * ����һ�����飬ÿ��ֵ�������ӵĸ߶ȣ�����֮��ľ���Χ��һ�����
 * ���=�������ӵ���Сֵ*��������֮��ľ���
 * [3��4��2��5] ����6
 * ������������Χ�ǵ������󣬲�����
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
