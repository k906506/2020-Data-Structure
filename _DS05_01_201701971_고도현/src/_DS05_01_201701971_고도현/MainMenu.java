package _DS05_01_201701971_고도현;

public enum MainMenu {
	Error,			// error
	
	DoesContain,	// 1. doesContain
	ElementAt,		// 2. elementAt
	First,			// 3. first
	Last,			// 4. last
	OrderOf,		// 5. orderOf
	
	AddTo,			// 6. addTo
	AddToFirst,		// 7. addToFirst
	AddToLast,		// 8. addToLast
	Add,			// 9. add
	
	RemoveFrom,		// 10. removeFrom
	RemoveFirst,	// 11. removeFirst
	RemoveLast,		// 12. removeLast
	RemoveAny,		// 13. removeAny
	
	ReplaceAt,		// 14. replaceAt
	
	EndOfRun;		// 15. endOfRun
	public static final int END_OF_RUN = 99;

	public static MainMenu value (int menuNumber) {
		if (menuNumber == END_OF_RUN) {	// 99번이 입력되면
			return MainMenu.EndOfRun;	// EndOfRun 실행
		}
		else if (menuNumber < DoesContain.ordinal() || menuNumber > ReplaceAt.ordinal()) {	// 값이 1보다 작고 14보다 크면
			return MainMenu.Error; 	// 에러 
		}
		else {
			return MainMenu.values()[menuNumber];
		}
	}
}


