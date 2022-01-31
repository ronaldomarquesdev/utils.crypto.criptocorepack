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



/* IMPORT OF DEPENDENCES. */



/* THE MAIN CLASS. */
public final class CCPStandards { // v3

	/* DEBUG auxiliary variable to print when DEBUG_MODE == true. */
	public static boolean DEBUG_MODE = false;
	
	
	
	/* PRE-DEFINED PROJECT STANDARD INFOMATIONS CONSTANTS. */
	public static final String PROJ_NAME = "Cryptography Core Package Project";
	public static final String PROJ_ALIAS = "CryptoCorePack";
	public static final String PROJ_PACKAGE_PATH = "dev/ronaldomarques/cryptocorepack";
	public static final String PROJ_PACKAGE_NAME = "dev.ronaldomarques.cryptocorepack";
	public static final String PROJ_BUILD = "20200611";
	public static final String PROJ_PRE_VERSION = "dev";
	public static final String PROJ_VERSION_PATCH = "0";
	public static final String PROJ_VERSION_MINOR = "1";
	public static final String PROJ_VERSION_MAJOR = "0";
	public static final String PROJ_VERSION = PROJ_VERSION_MAJOR+"."+PROJ_VERSION_MINOR+"."+PROJ_VERSION_PATCH+"-"+PROJ_PRE_VERSION+"+"+PROJ_BUILD;
	public static final String TITLE = PROJ_NAME +"\n"+ PROJ_ALIAS +" "+ PROJ_VERSION;
	public static final String CHARSET_WORKABLE = "ASCII";
	
	
	
	/* PRE-DEFINED PROJECT STANDARD ERROR MENSAGES CONSTANTS. */
	
	/* ERR01__ SERIES: Error-Group description xyz foo bar baz: */
	/* discern error: */
	public static final String ERR0101 = "Error # 0101.\nDescription: ...\nSolution: ...\nSee ... for more information.";
	/* discern error: */
	public static final String ERR0102 = "Error # 0102.\nDescription: ...\nSolution: ...\nSee ... for more information.";
	
	/* ERR02__ SERIES: Error-Group description xyz foo bar baz: */
	/* discern error: */
	public static final String ERR0201 = "Error # 0201.\nDescription: ...\nSolution: ...\nSee ... for more information.";
	
	/* ERR03__ SERIES: Error-Group description xyz foo bar baz: */
	/* discern error: */
	public static final String ERR0301 = "Error # 0301.\nDescription: ...\nSolution: ...\nSee ... for more information.";

	/* ERR99__ SERIES: UNHANDLED OR UNSPECTED: */
	/* discern error: */
	public static final String ERR9999 = "Error # 9999.\nDescription: Unspected error.";
	
	
	
	/* PRE-DEFINED PROJECT PARAMS. */
	public static final int MIN_KEY_SIZE = 3;
	public static final int MAX_KEY_SIZE = 32;
	
	/* Experimental: Under analysis whether it'll be continued. */
	public static final int[] ACC_SEQ_VALUES = {0, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912};
	
	/* Experimental: Under analysis whether it'll be continued. */
	public static final int[] ASJGOBITCI = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, -1};
	
	/* Experimental: Under analysis whether it'll be continued. */
	public static final int[] FIB_SEQ_VALUES = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269};

	/* Experimental: And under analysis whether it'll be continued. */
	public static final int[] FSJGOBITCI = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8};
			
	
	
	/* Text to be printed as SYNTAX. */
	public static final String usageSyntaxe = "Usage syntax> under developing...";
	
	/* Text to be printed as HELP. */
	public static final String usageExplanaion = "Usage explanation> under developing...";
}
  















