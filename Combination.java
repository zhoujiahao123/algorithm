package �о�������;
//4 A 2B 2C 1D 1E 3F ����ɶ�����5����ĸ���ַ���
public class Combination {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int c[] = {4,2,2};
		f(c,0,4,"");
	}
	public static void f(int a[],int k,int n,String s){
		//��ζ�ſɹ�ѡ�����ĸ�Ѿ�ѡ��
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
