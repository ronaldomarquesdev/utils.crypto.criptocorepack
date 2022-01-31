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




/* THE MAIN CLASS. */
public class CCPCLI {

	public static void main(String[] args) {

		if ((args.length > 0) && (args[0].charAt(0) == '-')) {

			switch (args[0].charAt(1)) {
			case 'v':
				System.out.println("\n"+ CCPStandards.TITLE +"\n");
				break;

			case 's':
				System.out.println("\n"+ CCPStandards.usageSyntaxe +"\n");
				break;
				
			case 'h':
				System.out.println("\n"+ CCPStandards.usageExplanaion +"\n");
				break;

			case 'e':
				System.out.println("encr");
				break;

			case 'd':
				System.out.println("decr");
				break;

			default:
				System.out.println("default");
				break;
			}
		} else {
			System.out.println(
					"Error in args! The first one must be an option.\n" + "Type 'java CCPCLI -s' to see the syntax.");
		}
		System.out.println("Done.\n");
	}
}
