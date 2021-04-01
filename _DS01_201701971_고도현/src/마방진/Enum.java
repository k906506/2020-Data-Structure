package ������;

public class Enum {
	public enum OrderValidity{
		EndOfRun,
		Valid,
		TooSmall,
		TooLarge,
		NotOddNumber;
		
		public static OrderValidity validityOf(int order) {
			if(order<0) {	
				return OrderValidity.EndOfRun;	//��������
			}
			else if(order<AppController.MIN_ORDER) {
				return OrderValidity.TooSmall;	//3���� ����
			}
			else if(order>AppController.MAX_ORDER) {	
				return OrderValidity.TooLarge;	//99���� ŭ
			}
			else if((order%2)==0) {
				return OrderValidity.NotOddNumber; //¦�� �Է�
			}
			else {
				return OrderValidity.Valid;	//��ȿ�� �Է�
			}
		}
	}

}
