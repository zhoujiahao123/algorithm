package �о�������;
public class Permutation {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int a[] = {1,2};
		f(0,a);
	}
	public static void f(int k ,int a[]){
		if(k == a.length){
			for(int i = 0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println();
			return ;
		}
		for(int i = k;i<a.length;i++){
			//��һ���򵥵���������⣬����ABCD���ԣ���k = 0ʱ����ȡA��Ȼ����f(1,a),��ʣ�µ������ж��������У�Ȼ��ѭ��һ��ȡi = 1����A��B��һ��
			//�ͱ��ȡ��B��Ȼ����ACD�ж�����������
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
			f(k+1,a);
			//��Ҫ���ݣ���Ϊ��A��B������ʱ����һ��ѭ��Ӧ����A��C���������ǵ�ǰ��B��C
			a[i] = a[k];
			a[k] = temp;
		}
	}
}
