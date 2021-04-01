package 마방진;

public class Enum {
	public enum OrderValidity{
		EndOfRun,
		Valid,
		TooSmall,
		TooLarge,
		NotOddNumber;
		
		public static OrderValidity validityOf(int order) {
			if(order<0) {	
				return OrderValidity.EndOfRun;	//실행종료
			}
			else if(order<AppController.MIN_ORDER) {
				return OrderValidity.TooSmall;	//3보다 작음
			}
			else if(order>AppController.MAX_ORDER) {	
				return OrderValidity.TooLarge;	//99보다 큼
			}
			else if((order%2)==0) {
				return OrderValidity.NotOddNumber; //짝수 입력
			}
			else {
				return OrderValidity.Valid;	//유효값 입력
			}
		}
	}

}
