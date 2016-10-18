package Chapter1;

import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode problem 354 Russion Doll Envelopes
 * @author xyuser
 *
 */
public class RussianDollEnvelopes {
	public static class Dot{
		public int w;
		public int h;
		public Dot(int weight,int height){
			w = weight;
			h = height;
		}
	}
	public static class DotComparator implements Comparator<Dot>{
		@Override
		public int compare(Dot o1, Dot o2) {
			if(o1.w == o2.w){
				if(o1.h == o2.h){
					return 0;
				}else if(o1.h < o2.h){
					return 1;
				}else{
					return -1;
				}
			}else if(o1.w < o2.w){
				return -1;
			}else{
				return 1;
		}
	}
}
	public static int maxEnvelops(int[][] es){
		if(es == null || es.length == 0 || es[0] == null||es[0].length !=2){
			return 0;
		}
		Dot[] dots = new Dot[es.length];
		for(int i =0;i < es.length ; i++){
			dots[i] = new Dot(es[i][0], es[i][1]);
		}
		Arrays.sort(dots,new DotComparator());
		//存放的是长度为i+1的最长递增子序列结尾处值为h的最小值
		int[] ends = new int[es.length];
		ends[0] = dots[0].h;
		int right = 0;//有效区
		int l =0;
		int r =0;
		int m = 0;
		for(int i =1;i<dots.length;i++){
			l=0;
			r=right;
			while(l<=r){
				m=(l+r)/2;
				if(dots[i].h>ends[m]){
					l=m+1;
				}else{
					r=m-1;
				}
			}
			right = Math.max(right, l);
			ends[l]=dots[i].h;
		}
		return right + 1;
	}
	public static void main(String[] args) {
		int[][] e = new int[][]{
			{5,4},
			{6,4},
			{6,7},
			{2,3}
		};
		int maxEnvelopes = maxEnvelops(e);
		System.out.println(maxEnvelopes);
	}
}
