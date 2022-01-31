/*****************************************************************************80
 *
 * CryptoCorePack
 * Cryptography Core Package Project
 * 
 * The CryptoCorePack and its resources are a personal project sample, which I have developing to demonstrate some of my abilities: oop, java, kanban, scrum, git, github, gitflow.
 * The CryptoCorePack project belongs to my personal portfolio. Detailed project can be followed just here on GitHub: https://github.com/users/ROPIMASI/projects/. It is also found on my web portfolio: https://ronaldomarques.dev .
 * 
 * AUTHOR: RONALDO MARQUES.
 * LICENSE: SEE FULL DOCUMMENTATION. IT IS A PERSONAL PROJECT, THER IS NO LICENSE YET (either copy or usage are discouraged).
 * 
 * DESCRIPTION:
 *     - PROJECT SUBJECT: Plain text symmetric and asymmetric cryptography package;
 *     - PROJECT NAME: Cryptography Core Package Project;
 *     - PROJECT ALIAS: CryptoCorePack.
 *     
 * For many else informations see the official documentation:
 *     - https://github.com/ROPIMASI/CryptoCorePack/tree/master/README.md ; and,
 *     - https://github.com/ROPIMASI/CryptoCorePack/tree/master/documentation/README.FIRST.md .
 *
 * NOTA IMPORTANTE / ISENÇÃO DE RESPONSABILIDADE:
 *     - Este é um projeto pessoal, com finalidade exclusiva de estudos em tecnologia da informação, e de uso e fruto única e exclusivamente de seu autor. Trata-se de um projeto em fase de desenvovimento e experimentações, o qual não tem nenhuma garantia nem responsabilidade sobre seus resultados e efeitos ao ser utilizado.
 * 
 * IMPORTANT NOTE / DISCLAIMER:
 *     - This is a personal, solely for the purpose of my studies in information technology, and for the sole and exclusive use of its author. It is a project under development and experimentation, which has no guarantee neither responsibility over its results and effects when used.
 * 
 * NOTA IMPORTANTE / DESCARGO DE RESPONSABILIDAD:
 *     - Este es un proyecto personal, con el único propósito de estudiar tecnología de la información, y de uso y fruta única y exclusivamente por su autor. Es un proyecto en desarrollo y experimentación, que no tiene garantía ni responsabilidad por sus resultados y efectos cuando se utiliza.
 *     
 * ВАЖНОЕ ПРИМЕЧАНИЕ / ОТКАЗ ОТ ОТВЕТСТВЕННОСТИ:
 *     - Это личный, частный проект, с единственной целью изучения информационных технологий, а также для использования и плоды исключительно и исключительно его автором. Это проект, находящийся в стадии разработки и экспериментов, который не имеет никаких гарантий или ответственности за его результаты и результаты при использовании.
 *     
 * 重要提示 / 免责声明：
 *     - 这是一个私人的私人项目，其唯一目的是研究信息技术，以及作者独有和专有的使用和成果。 这是一个正在开发和试验中的项目，使用时对其结果和效果不承担任何保证或责任。
 *     
 *     
 ****************************************************************************80/



/* PACKAGE OWNER. */
package dev.ronaldomarques.utils.crypto.cryptocorepack;



/* IMPORTS. */
import java.util.ArrayList;
import java.util.List;



/* THE MAIN CLASS. */
public final class CryptoCore { // v5.

	
	
	/* AUXILIARIES METHODS. */
	
	/* Debug auxiliary method to print when DEBUG_MODE == true: */
	/* This is a tool. Refactor: It must get out in the future. */
	protected static void dmPrint(String str) { // v0.
		if (CCPStandards.DEBUG_MODE) System.out.print(str);
	}
	

	
	/* Auxiliary method: simple flag (Even or Odd) for positive integer numbers: */
	/* This is a tool. Refactor: It must get out in the future. */
	private static int evenOdd(int n) { // v0.
		return ((n % 2) == 0) ? 0 : 1;
	}
	
	
	
	/* Auxiliary method: key verification: */
	private static boolean keyValidation(String key) { // v0.
		if ((! key.isEmpty()) && (! key.isBlank()) && (key != null)) {
			return ((key.length() >= CCPStandards.MIN_KEY_SIZE) && (key.length() <= CCPStandards.MAX_KEY_SIZE)) ? true : false;
		} else {
			return false;
		}
	}
	
	
	
	/* Auxiliary method: newLength verification: */
	private static boolean newLengthValidation(int newLength) { // v0.
		return ((newLength >= CCPStandards.MIN_KEY_SIZE) && (newLength <= CCPStandards.MAX_KEY_SIZE)) ? true : false;
	}
	
	
	
	/* Auxiliary method: Encrypted token type recognizer: */
	private static int tokenRecognition(String token) { // v0.
		return (token.substring(token.length()-4).equalsIgnoreCase("ρπμδ")) ? 0 : (token.substring(token.length()-3).contentEquals("ρπμ")) ? 1 : -1 ; // -1 is an error.
	}
	
	
	
	/* Auxiliary method: key resizing: */
	private static String keyRemolding(String key, int newLength) {	// v2.
		if (keyValidation(key) && newLengthValidation(newLength)) {
			if (key.length() == newLength) {
				dmPrint("==");
				return key;
			} else if (key.length() < newLength) {
				dmPrint("<");
				int pos = 0;
				int tokenSize = key.length();
				do {
					dmPrint(",");
					key += key.charAt(pos);
					pos = (pos <= tokenSize - 1) ? pos + 1 : 0;
				} while (key.length() < newLength);
				return key;
			} else { // (key.length() > newLength)
				dmPrint(">");
				key = key.substring(0, newLength);
				return key;
			}
		} else {
			return null;
		}
	}

	
	
	/* FUNCTIONALS METHODS. */
	
	/* accumulativeSeq 0 1 1 2 4 8 16 32 64... up to 536870912, 32 elements. 
	 * Using current version of JAVA 11.0.7, this algorithm has elementsAmount
	 * limited at minimum 2 and max 32.
	 * Functional method: Sequence of accumulative values generator: */	
	private static int[] genAccumulativeSeq(int elementsAmount) { // v0.
		// It will always create, at least, 2 elements, and always at max 32 elements.		
		elementsAmount = (elementsAmount < 2) ? 2 : (elementsAmount > 32) ? 32 : elementsAmount;
		int[] returnArray = new int[elementsAmount];
		returnArray[0] = 0;
		returnArray[1] = 1;
		
		for (int i=2; i<elementsAmount; i++) {
			returnArray[i] = 0;
			for (int j=0; j<i; j++ ) {
				returnArray[i] = returnArray[i] + returnArray[j];
			}
		}
		return returnArray;		
	} 
	
	
	
	/* Using current version of JAVA 11.0.7, this algorithm
	 * has seek (as a index) limited at min 1, and max 31; and
	 * has seek (as a value) limited at min 0, and max 536870912.
	 * Functional method: Accumulative sequence element getter: */
	private static int getAccumulativeSeqElement(char op, int seek) { // v1.
		/* 'op' is caller's option between (('i' or 'I') and ('v' | 'V'))
		 * meaning 'index' or 'value', which will be used on searching, so
		 * the remaining option (the opposite to the choose one) will
		 * be return. */
		
		int[] tmpSequence;
		int tmpReturn; // Define a standarts_ERROR_constants, later.
		
		switch (op) {
		case 'i':
		case 'I':
			tmpReturn = -2; // Initial value supposed. Error 'index' not found.
			seek = (seek < 0) ? 0 : (seek > 31) ? 31 : seek;
			tmpSequence = new int[seek+1];
			tmpSequence = genAccumulativeSeq(seek+1);
			tmpReturn = tmpSequence[seek]; // It was found.
			break;
			
		case 'v':
		case 'V':
			tmpReturn = -3; // Initial value supposed. Error 'value' not found.
			seek = (seek < 0) ? 0 : (seek > 536870912) ? 536870912 : seek;
			tmpSequence = new int[32];
			tmpSequence = genAccumulativeSeq(32);
			for (int i=0; i<tmpSequence.length; i++) {
				if (tmpSequence[i] == seek) {
					tmpReturn = i; // It was found.
				}
			}
			break;
			
		default:
			tmpReturn = -1; // Error 'op' unknow.
			break;
		}
		return tmpReturn; 
	}
	
	
	
	/* fibonacciSeq 0 1 1 2 3 5 8 13 21 35... up to 701408733, 45 elements.
	 * Using current version of JAVA 11.0.7, this algorithm has elementsAmount limited at min 2 and max 44.
	 * Functional method: Sequence of Fibonnacci values generator: */	
	private static int[] genFibonacciSeq(int elementsAmount) { // v0.
		// It will always create, at least, 2 elements.
		elementsAmount = (elementsAmount < 2) ? 2 : (elementsAmount > 45) ? 45 : elementsAmount;
		int[] returnArray = new int[elementsAmount];
		returnArray[0] = 0;
		returnArray[1] = 1;
		
		for (int i=2; i<elementsAmount; i++) {
			returnArray[i] = returnArray[i-1] + returnArray[i-2];
		}
		return returnArray;			
	}
	
	
	
	/* Using current version of JAVA 11.0.7, this algorithm
	 * has seek (as a index) limited at min 0, and max 44; and
	 * has seek (as a value) limited at min 0, and max 701408733.
	 * Functional method: Fibonnacci sequence element getter: */
	private static int getFibonacciSeqElement(char op, int seek) { //v1.
		/* 'op' is caller's option between (('i' or 'I') and ('v' | 'V'))
		 * meaning 'index' or 'value', which will be used on searching, so
		 * the remaining option (the opposite to the choose one) will
		 * be return. */
		int[] tmpSequence;
		int tmpReturn; // Define a standarts_ERROR_constants, later.
		
		switch (op) {
		case 'i':
		case 'I':
			tmpReturn = -2; // Initial value supposed. Error 'index' not found.
			seek = (seek < 0) ? 0 : (seek > 44) ? 44 : seek;
			tmpSequence = new int[seek+1];
			tmpSequence = genFibonacciSeq(seek+1);
			tmpReturn = tmpSequence[seek]; // It was found.
			break;
			
		case 'v':
		case 'V':
			tmpReturn = -3; // Initial value supposed. Error 'value' not found.
			seek = (seek < 0) ? 0 : (seek > 701408733) ? 701408733 : seek;
			tmpSequence = new int[45];
			tmpSequence = genAccumulativeSeq(45);
			for (int i=0; i<tmpSequence.length; i++) {
				if (tmpSequence[i] == seek) {
					tmpReturn = i; // It was found.
				}
			}
			break;
			
		default:
			tmpReturn = -1; // Error 'op' unknow.
			break;
		}
		return tmpReturn; 		
	}
	
	
	
	/* Very simple, old, and rudimentary method of cryptography, it works, unless, like knowledge.
	 * Simple char switching method without key, used as a cryptography step. It will be used on hybrid modes.
	 * Functional method: simple char switching for others methods calling. */
	private static char charSwitching(char c, boolean doUndo) { // v0.
		switch (c) {
		case 'a': 
			return (doUndo) ? 'q' : 'K';
		
		case 'b':
			return (doUndo) ? 'w' : 'X';
		
		case 'c':
			return (doUndo) ? 'e' : 'V';
		
		case 'd':
			return (doUndo) ? 'R' : 'm';
		
		case 'e':
			return (doUndo) ? '4' : 'c';
		
		case 'f':
			return (doUndo) ? 'Y' : 'n';
		
		case 'g':
			return (doUndo) ? 'u' : '2';
		
		case 'h':
			return (doUndo) ? 'i' : 'P';
		
		case 'i':
			return (doUndo) ? 'o' : 'h';
		
		case 'j':
			return (doUndo) ? '8' : 'Q';
		
		case 'k':
			return (doUndo) ? 'A' : '8';
		
		case 'l':
			return (doUndo) ? 'S' : 's';
		
		case 'm':
			return (doUndo) ? 'd' : 'z';
		
		case 'n':
			return (doUndo) ? 'f' : '4';
		
		case 'o':
			return (doUndo) ? '2' : 'i';
		
		case 'p':
			return (doUndo) ? 'H' : 'J';
		
		case 'q':
			return (doUndo) ? 'J' : 'a';
		
		case 'r':
			return (doUndo) ? 'K' : 'D';
		
		case 's':
			return (doUndo) ? 'l' : '7';
		
		case 't':
			return (doUndo) ? '6' : 'E';
		
		case 'u':
			return (doUndo) ? 'x' : 'g';
		
		case 'v':
			return (doUndo) ? 'C' : 'W';
		
		case 'w':
			return (doUndo) ? 'V' : 'b';
		
		case 'x':
			return (doUndo) ? 'B' : 'u';
		
		case 'y':
			return (doUndo) ? '0' : 'F';
		
		case 'z':
			return (doUndo) ? 'm' : '3';
			
		case 'A':
			return (doUndo) ? 'Q' : 'k';
	
		case 'B':
			return (doUndo) ? 'W' : 'x';

		case 'C':
			return (doUndo) ? '5' : 'v';
		
		case 'D':
			return (doUndo) ? 'r' : 'M';
		
		case 'E':
			return (doUndo) ? 't' : '@';
		
		case 'F':
			return (doUndo) ? 'y' : 'N';
		
		case 'G':
			return (doUndo) ? '9' : 'O';
		
		case 'H':
			return (doUndo) ? 'I' : 'p';
		
		case 'I':
			return (doUndo) ? 'O' : 'H';
		
		case 'J':
			return (doUndo) ? 'p' : 'q';
		
		case 'K':
			return (doUndo) ? 'a' : 'r';
		
		case 'L':
			return (doUndo) ? '3' : 'S';
		
		case 'M':
			return (doUndo) ? 'D' : ' ';
		
		case 'N':
			return (doUndo) ? 'F' : '!';
		
		case 'O':
			return (doUndo) ? 'G' : 'I';
		
		case 'P':
			return (doUndo) ? 'h' : '1';

		case 'Q':
			return (doUndo) ? 'j' : 'A';
		
		case 'R':
			return (doUndo) ? '7' : 'd';

		case 'S':
			return (doUndo) ? 'L' : 'l';
		
		case 'T':
			return (doUndo) ? 'Z' : '0';

		case 'U':
			return (doUndo) ? 'X' : '6';
		
		case 'V':
			return (doUndo) ? 'c' : 'w';

		case 'W':
			return (doUndo) ? 'v' : 'B';
		
		case 'X':
			return (doUndo) ? 'b' : 'U';

		case 'Y':
			return (doUndo) ? '1' : 'f';
		
		case 'Z':
			return (doUndo) ? ' ' : 'T';
			
		case ' ':
			return (doUndo) ? 'M' : 'Z';
			
		case '0':
			return (doUndo) ? 'T' : 'y';
		
		case '1':
			return (doUndo) ? 'P' : 'Y';
		
		case '2':
			return (doUndo) ? 'g' : 'o';
		
		case '3':
			return (doUndo) ? 'z' : 'L';
		
		case '4':
			return (doUndo) ? 'n' : 'e';
		
		case '5':
			return (doUndo) ? '@' : 'C';
		
		case '6':
			return (doUndo) ? 'U' : 't';
		
		case '7':
			return (doUndo) ? 's' : 'R';
		
		case '8':
			return (doUndo) ? 'k' : 'j';
		
		case '9':
			return (doUndo) ? '!' : 'G';
			
		case '!':
			return (doUndo) ? 'N' : '9';

		case '@':
			return (doUndo) ? 'E' : '5';
			
		default:
			return c;
		}
	}


	
	/* Very simple, old, and rudimentary method of cryptography, it works, unless, like knowledge.
	 * Simple char switching method *WITH* key, used as a cryptography step. It will be used on hybrid modes.
	 * Functional method: simple char switching for others methods calling. */
	
	// Implementation in future versions, maybe.
	
	
	
	/* Symmetric char-switching-technique without key.
	 * Very simple, old, and rudimentary method of cryptography, unless like knowledge.
	 * Single char switching method, used as a cryptography step. It will be used on hybrid mode. */
	public static String symmCharSwitching(String aText, boolean doUndo) { // v0.
		String returnText = "";
		for (int i = 0; i < aText.length(); i++) {
			dmPrint(".");
			returnText += charSwitching(aText.charAt(i), doUndo);
		}
		dmPrint("[" + returnText + "]");
		return returnText;
	}	
	
	
	
	/* Symmetric foundry-technique without key: */ 
	public static String symmRandomFoundry(String aText, boolean doUndo) { // v0.
		String returnText = "";
		for (int i = 0; i < aText.length(); i++) {
			dmPrint(".");
			returnText += 
					(doUndo) ?
					(char) ((int) (aText.charAt(i)) + (aText.length() - i)) :
					(char) ((int) (aText.charAt(i)) - (aText.length() - i)) ;
		}
		dmPrint("[" + returnText + "]");
		return returnText;
	}
	
	
	
	/* Symmetric foundry-technique with key: */ 
	public static String symmKeyFoundry(String aText, String key, boolean doUndo) { // v0.
		dmPrint("[" + key + "][" + aText.length() + "]");
		key = keyRemolding(key, aText.length());
		String returnText = "";
		for (int i = 0; i < aText.length(); i++) {
			dmPrint(".");
			returnText += 
					(doUndo) ?
					(char) ((int) (aText.charAt(i)) + (int) (key.charAt(i)) + i) :
					(char) ((int) (aText.charAt(i)) - (int) (key.charAt(i)) - i) ;
		}
		dmPrint("[" + key + "][" + aText.length() + "][" + returnText + "]");
		return returnText;
	}
	
	
	
	/* Symmetric token-injection-technique without key: */ 
	public static String symmTokenInjection(String inputText, boolean doUndo) { // v1.
		
		/* It will contain, temporarily, the value to be return, in 'List' form, for better manageable in this method: */
		List<Character> tmpList = new ArrayList<Character>();
		/* It will receive tmpList converted in a String to bee return: */
		String returnText = "";
		/* Keep a sequence of 'ints', used in sequence of jumps: */
		final int[] seqJumps;
		/* Keep the converted inputText to CharArray, better manageable in this method: */
		final char[] inTxt;
		// Keep the key to be injected converted in charArray, better manageable in this method: */
		final char[] arbitraryToken; // An arbritary to this method token, which will be injected to the inputText.
		/* Variables of loop control: */
		int i = 0;		// Index that controls	"iteration seq"		on the sequence values.
		int j = 1;		// Index that controls	"jumps"				on the loop with inputText.length() repetitions.
		int k = 0;		// Index that controls	"keyToken"			on the returnText.
		int last_j = 0;	// Index that keep		"last jump index"	where there was a keyToken[k] injection.		

		if (doUndo) {
			/* Encrypt */
		
			/* Which injection mode use, Accumulative or Fiboancci? */
			switch (evenOdd(inputText.length())) {
			
			case 0: // Even: Using Accumulative sequence for jumps:
				seqJumps = genAccumulativeSeq(8);
				inTxt = inputText.toCharArray();
				arbitraryToken = keyRemolding("ROPIMASI", inputText.length()).toCharArray();
				
				for (j = 1; j <= inTxt.length; j++) {
					i = (i == seqJumps.length-1) ? 0 : i;
					if ((j - last_j) == seqJumps[i+1] ) {
						tmpList.add(arbitraryToken[k]);
						tmpList.add(inTxt[j-1]);
						last_j = j;
						i++;
						// j++; it is with in 'for' loop head.
						k++;
					} else {
						tmpList.add(inTxt[j-1]);
					}
				}
				break;
			
			case 1: // Odd: Using Fibonacci sequence for jumps:
				seqJumps = genFibonacciSeq(8);
				inTxt = inputText.toCharArray();
				arbitraryToken = keyRemolding("ROPIMASI", inputText.length()).toCharArray();
						
				for (j = 1; j <= inTxt.length; j++) {
					i = (i == seqJumps.length-1) ? 0 : i;
					if ((j - last_j) == seqJumps[i+1] ) {
						tmpList.add(arbitraryToken[k]);
						tmpList.add(inTxt[j-1]);
						last_j = j;
						i++;
						// j++; it is with in 'for' loop head.
						k++;
					} else {
						tmpList.add(inTxt[j-1]);
					}
				}
				break;
			
			default: // Unexpected error:
				System.out.println("Error: out of Sequence-Method.");
				break;
			}
			
			/* List to String convert: */
			for (Character character : tmpList) returnText += character;
			/* Label whether return (returnText) was input even so injected with AccSeq, or,
			 * return (returnText) was input odd so injected with FiboSeq:  */
			returnText += ( evenOdd(inputText.length()) == 0 ) ? "ρπμδ" : "ρπμ" ;
			return returnText;
		} else {
			/* Decrypt */
			/* Decrypt */
			String e = "";
			String ie = "";
			if (inputText.substring(inputText.length()-4).equalsIgnoreCase("ρπμδ")) { // ρπμδ || ρπμ
				// Even, 0, accumulative.
				
				ie = inputText.substring(0, inputText.length()-4);
				for (int n=0; n<inputText.length(); n++) {
					e += (CCPStandards.ASJGOBITCI[n] == CCPStandards.ASJGOBITCI[n+1]) ? ie.charAt(n) : "" ;
				}
			
			} else if (inputText.substring(inputText.length()-3).equalsIgnoreCase("ρπμ")) {
				// Odd, 1, fibonacci.
				
				ie = inputText.substring(0, inputText.length()-3);
				for (int n=0; n<inputText.length(); n++) {
					e += (CCPStandards.FSJGOBITCI[n] == CCPStandards.FSJGOBITCI[n+1]) ? ie.charAt(n) : "" ;
				}
				
			}
			returnText = e;
			return returnText;
		}
	}
	
	
	
	/* Overload. */
	/* Symmetric token-injection-technique with key: */
	public static String symmTokenInjection(String inputKey, String inputText, boolean doUndo) { // v1
		
		/* It will contain, temporarily, the value to be return, in 'List' form, for better manageable in this method: */
		List<Character> tmpList = new ArrayList<Character>();
		/* It will receive tmpList converted in a String to bee return: */
		String returnText = "";
		/* Keep a sequence of 'ints', used in sequence of jumps: */
		final int[] seqJumps;
		/* Keep the converted inputText to CharArray, better manageable in this method: */
		final char[] inTxt;
		// Keep the key to be injected converted in charArray, better manageable in this method: */
		final char[] inKeyTkn; // An token based on 'inputKey' to this method, which will be injected to the inputText.
		/* Variables of loop control: */
		int i = 0;		// Index that controls	"iteration seq"		on the sequence values.
		int j = 1;		// Index that controls	"jumps"				on the loop with inputText.length() repetitions.
		int k = 0;		// Index that controls	"keyToken"			on the returnText.
		int last_j = 0;	// Index that keep		"last jump index"	where there was a keyToken[k] injection.		

		if (doUndo) {
		/* Encrypt */
		
			/* Which injection mode use, Accumulative or Fiboancci? */
			switch (evenOdd(inputText.length())) {
			case 0: // Even, 0: Use accumulative sequence for jumps:
				seqJumps = genAccumulativeSeq(8);
				inTxt = inputText.toCharArray();
				inKeyTkn = keyRemolding(inputKey, inputText.length()).toCharArray();
				
				for (j = 1; j <= inTxt.length; j++) {
					i = (i == seqJumps.length-1) ? 0 : i;
					if ((j - last_j) == seqJumps[i+1] ) {
						tmpList.add(inKeyTkn[k]);
						tmpList.add(inTxt[j-1]);
						last_j = j;
						i++;
						// j++; it is with in 'for' loop head.
						k++;
					} else {
						tmpList.add(inTxt[j-1]);
					}
				}
				break;
			
			case 1: // Odd, 1: Use Fibonacci sequence for jumps:
				seqJumps = genFibonacciSeq(8);
				inTxt = inputText.toCharArray();
				inKeyTkn = keyRemolding(inputKey, inputText.length()).toCharArray();
						
				for (j = 1; j <= inTxt.length; j++) {
					i = (i == seqJumps.length-1) ? 0 : i;
					if ((j - last_j) == seqJumps[i+1] ) {
						tmpList.add(inKeyTkn[k]);
						tmpList.add(inTxt[j-1]);
						last_j = j;
						i++;
						// j++; it is with in 'for' loop head.
						k++;
					} else {
						tmpList.add(inTxt[j-1]);
					}
				}
				break;
			
			default: // Unexpected error:
				System.out.println("Error: out of Sequence-Method.");
				break;
			}

			/* List to String convert: */
			for (Character character : tmpList) returnText += character;
			/* Label whether return (returnText) was input even so injected with AccSeq, or,
			 * return (returnText) was input odd so injected with FiboSeq:  */
			returnText += ( evenOdd(inputText.length()) == 0 ) ? "ρπμδ" : "ρπμ" ;
			return returnText;
			
		} else {
			/* Decrypt */
			String e = "";
			String ie = "";
			if (inputText.substring(inputText.length()-4).equalsIgnoreCase("ρπμδ")) { // ρπμδ || ρπμ
				// Even, 0, accumulative.
				
				ie = inputText.substring(0, inputText.length()-4);
				for (int n=0; n<inputText.length(); n++) {
					e += (CCPStandards.ASJGOBITCI[n] == CCPStandards.ASJGOBITCI[n+1]) ? ie.charAt(n) : "" ;
				}
			
			} else if (inputText.substring(inputText.length()-3).equalsIgnoreCase("ρπμ")) {
				// Odd, 1, fibonacci.
				
				ie = inputText.substring(0, inputText.length()-3);
				for (int n=0; n<inputText.length(); n++) {
					e += (CCPStandards.FSJGOBITCI[n] == CCPStandards.FSJGOBITCI[n+1]) ? ie.charAt(n) : "" ;
				}
				
			}
			returnText = e;
			return returnText;
		}
	}



	/* Symmetric hybrid techniques without key: */
	public static String symmHybrid_v1(String inputText, boolean doUndo) { // v0.
		
		dmPrint("symmHybrid_v1(String inputText, boolean doUndo)   UNDER CONSTRUCTION...");
		
		return "symmHybrid_v1(String inputText, boolean doUndo)   UNDER CONSTRUCTION...";
	}
	
	
	
	/* Overload. */
	/* Symmetric hybrid techniques with key: */
	public static String symmHybrid_v1(String inputKey, String inputText, boolean doUndo) { // v0.
		
		dmPrint("symmHybrid_v1(String inputKey, String inputText, boolean doUndo)   UNDER CONSTRUCTION...");
				
		return "symmHybrid_v1(String inputKey, String inputText, boolean doUndo)   UNDER CONSTRUCTION...";
	}
}





/*
Guardar estes 3 tipos de sequências para desenvolvimento futuro próximo.
piFraction(Pi)		1 4 1 5 9 2 6 5 
eFraction(Euler)	7 1 8 2 8 1 8 2 
fiFractional(Aurea)	6 1 8 0 3 3 9 8
*/

/*
It generates a token with inputText length used as a key.
List<Character> keyToken = new ArrayList<Character>(); 
aKeyToken = symmKeyFoundry(inputText, "ROPIMASI", true).chars().mapToObj(letra -> (char) letra).collect(Collectors.toList());
*/









//EOF.