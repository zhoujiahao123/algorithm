package 研究生复试;
//4 A 2B 2C 1D 1E 3F 能组成多少种5个字母的字符串
public class Combination {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int c[] = {4,2,2};
		f(c,0,4,"");
	}
	public static void f(int a[],int k,int n,String s){
		//意味着可供选择的字母已经选完
		if(k==a.length){
			if(n==0) System.out.println(s);
			return ;
		}
		for(int i = 0;i<=a[k];i++){
			f(a,k+1,n-i,s);
			s += (char)(k+'A');
		}
	}

}
