package �о�������;
/**
 * ѡ������
 * @author ASUS-NB
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int array[] = {7,5,4,6,9,8,1,2,3};
		int index = 0;
		for(int i = 0;i<array.length-1;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[j]<array[index]) index = j; 
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
