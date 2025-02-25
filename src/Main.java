import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ListaDeTarefas lista = new ListaDeTarefas();
		int opcao = 1;
		boolean erro = true;
		String titulo, descricao;
		while(opcao != 0) {
			while(erro == true) {
				try {
					System.out.println("---------- Lista de Tarefas ----------\n");
					System.out.println("---------------- MENU ---------------");
					System.out.print("1 - adicionar tarefa\n"+
					   	   		     "2 - remover tarefa\n"+
					   				 "3 - listar tarefas\n"+
					   	   		     "4 - concluir tarefa\n"+
					   				 "0 - sair do programa\n"+
					   				 "Escolha: "
									 );
					opcao = input.nextInt();
					
					while(opcao < 0 || opcao > 4) {
						System.out.println("Valor incorreto. Digite apenas uma das opções.");
						System.out.println("---------- Lista de Tarefas ----------\n");
						System.out.println("---------------- MENU ---------------");
						System.out.print("1 - adicionar tarefa\n"+
						   	   		     "2 - remover tarefa\n"+
						   				 "3 - listar tarefas\n"+
						   				 "4 - concluir tarefa\n"+
						   				 "0 - sair do programa\n"+
						   				 "Escolha: "
										 );
						opcao = input.nextInt();
						
					}
					erro = false;
				} catch (Exception e) {
					System.out.println("\nValor inválido. Digite apenas uma das opções.\n");
					input.nextLine();
				}
			}
			
			switch(opcao) {
				case 1 ->{
					input.nextLine();
					int escolha = 1;
					System.out.print("\nDigite o título da tarefa: ");
					titulo = input.nextLine();
					int retorno = lista.verificarTituloIgual(titulo);
					while(retorno != 1) {
						erro = true;
						while(erro == true) {
							try {
								System.out.println("\nTítulo já existe em uma tarefa.");
								System.out.print("Digite:\n"+
												 "1 - para manter o mesmo titulo\n"+
												 "2 - para mudar o titulo\n"+
												 "Escolha: "
												);
								escolha = input.nextInt();
								input.nextLine();
								while(escolha != 1 && escolha != 2) {
									System.out.println("\nValor incorreto. Digite apenas uma das opções.");
									System.out.print("Digite:\n"+
											 "1 - para manter o mesmo titulo\n"+
											 "2 - para mudar o titulo\n"+
											 "Escolha: "
											);
									escolha = input.nextInt();
									input.nextLine();
								}
								erro = false;
							}catch(Exception e) {
								System.out.println("\nValor incorreto. Digite apenas uma das opções\n");
								input.nextLine();
							}
							
						}
						if(escolha == 1) {
							retorno = 1;
						}else {
							System.out.print("\nDigite o título da tarefa: ");
							titulo = input.nextLine();
							retorno = lista.verificarTituloIgual(titulo);
						}
					}
					System.out.print("\nDigite a descrição da tarefa: ");
					descricao = input.nextLine();
					retorno = lista.verificarDescricaoIgual(descricao);
					while(retorno != 1) {
						erro = true;
						while(erro == true) {
							try {
								System.out.println("\nDescrição já existe em uma tarefa.");
								System.out.print("Digite:\n"+
												 "1 - para manter a mesma descrição\n"+
												 "2 - para mudar a descrição\n"+
												 "Escolha: "
												);
								escolha = input.nextInt();
								input.nextLine();
								while(escolha != 1 && escolha != 2) {
									System.out.println("\nValor incorreto. Digite apenas uma das opções.");
									System.out.print("Digite:\n"+
											 "1 - para manter a mesma descrição\n"+
											 "2 - para mudar a descrição\n"+
											 "Escolha: "
											);
									escolha = input.nextInt();
									input.nextLine();
								}
								erro = false;
							}catch(Exception e) {
								System.out.println("\nValor incorreto. Digite apenas uma das opções\n");
								input.nextLine();
							}
							
						}
						if(escolha == 1) {
							retorno = 1;
						}else {
							System.out.print("\nDigite a descrição da tarefa: ");
							titulo = input.nextLine();
							input.nextLine();
							retorno = lista.verificarTituloIgual(titulo);
						}
					}
					
					if(lista.adicionarTarefa(titulo, descricao)) {
						System.out.println("\nTarefa adicionada com sucesso\n");
					}else {
						System.out.println("\nTarefa não foi adicionada.\n");
					}
					erro = true;
				}
				case 2 ->{
					int escolha, aux  = 1, remover = 0;
					if(lista.listarTarefas(1)) {
						while(aux != 0 ) {
							try {
								System.out.print("\n\nDigite o número da tarefa que deseja remover: ");
								escolha = input.nextInt();
								int tamanho = lista.tamanhoLista();
								while(escolha <= tamanho - tamanho || escolha > tamanho){
									System.out.println("\nValor incorreto. Digite apenas uma das opções.");
									System.out.print("Digite o número da tarefa que deseja remover: ");
									escolha = input.nextInt();
								}
								
								while(aux != 0) {
									
									try{
										System.out.println("\nVocê deseja remover da lista a tarefa de nº " + escolha+"?");
										System.out.print("Digite:\n"+
														   "1 - para confirmar a remoção\n"+
														   "2 - para cancelar a remoção\n"+
														   "Escolha: "
														  );
										remover = input.nextInt();
										input.nextLine();
										while(remover != 1 && remover != 2) {
											System.out.println("\nValor incorreto. Digite uma das opções.");
											System.out.println("Você deseja remover da lista a tarefa de nº " + escolha+"?");
											System.out.print("Digite:\n"+
															   "1 - para confirmar a remoção\n"+
															   "2 - para cancelar a remoção\n"+
															   "Escolha: "
															  );
											remover = input.nextInt();
											input.nextLine();
										}
										aux = 0;
									}catch(Exception e) {
										System.out.println("\nVocê digitou um caracter diferente de numeros.\n");
										input.nextLine();
									}
									
								}
								if(remover == 1) {
									if(lista.removerTarefa(escolha-1) != null) {
										System.out.println("\nTarefa removida com sucesso.\n");
									}else {
										System.out.println("\nTarefa não foi removida com sucesso.\n");
									}
								}
							}catch(Exception e) {
								System.out.println("\nVocê digitou um caracter diferente de numeros.\n");
								input.nextLine();
							}
						}
					}else {
						System.out.println("\nNão há tarefas adicionadas para serem removidas\n");
					}
					erro = true;
				}
				
				case 3 ->{
					int escolha =1, aux =1;
					while(aux != 0) {
						try {
							System.out.print("\nComo deseja ver a lista:\n"+
									"1- ordem cronológica\n"+
									"2- ordem alfabética do titulo\n"+
									"Escolha: "
									);
							escolha = input.nextInt();
							while(escolha != 1 && escolha != 2) {
								System.out.println("\nValor incorreto. Digite apenas um dos valores do menu.");
								System.out.print("\nComo deseja ver a lista:\n"+
										"1- ordem cronológica\n"+
										"2- ordem alfabética do titulo\n"+
										"Escolha: "
										);
								escolha = input.nextInt();
							}
							aux = 0;
							input.nextLine();
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("\nValor incorreto. Digite apenas um dos valores do menu.");
							input.nextLine();
						}
					}
					if(lista.listarTarefas(escolha)) {
						
					}else {
						System.out.println("\nNão há tarefas adicionadas para serem listadas.\n");
					}
					erro = true;
				}
				
				case 4 ->{
					int escolha, aux  = 1, remover = 0;
					if(lista.listarTarefas(1)) {
						while(aux != 0 ) {
							try {
								System.out.print("\n\nDigite o número da tarefa que deseja concluir: ");
								escolha = input.nextInt();
								int tamanho = lista.tamanhoLista();
								while(escolha <= tamanho - tamanho || escolha > tamanho){
									System.out.println("\nValor incorreto. Digite apenas uma das opções.");
									System.out.print("\n\nDigite o número da tarefa que deseja concluir: ");
									escolha = input.nextInt();
								}
								
								while(aux != 0) {
									
									try{
										System.out.println("\nVocê realmente deseja concluir a tarefa de nº " + escolha+"?");
										System.out.print("Digite:\n"+
														   "1 - para confirmar a conclusao\n"+
														   "2 - para cancelar a conclusao\n"+
														   "Escolha: "
														  );
										remover = input.nextInt();
										input.nextLine();
										while(remover != 1 && remover != 2) {
											System.out.println("\nValor incorreto. Digite uma das opções.");
											System.out.println("\nVocê realmente deseja concluir a tarefa de nº " + escolha+"?");
											System.out.print("Digite:\n"+
															   "1 - para confirmar a conclusao\n"+
															   "2 - para cancelar a conclusao\n"+
															   "Escolha: "
															  );
											remover = input.nextInt();
											input.nextLine();
										}
										aux = 0;
									}catch(Exception e) {
										System.out.println("\nVocê digitou um caracter diferente de numeros.\n");
										input.nextLine();
									}
									
								}
								if(remover == 1) {
									if(lista.concluirTarefa(escolha-1)) {
										System.out.println("\nTarefa concluída com sucesso.\n");
									}else {
										System.out.println("\nTarefa não foi concluída.\n");
									}
								}
							}catch(Exception e) {
								System.out.println("\nVocê digitou um caracter diferente de numeros.\n");
								input.nextLine();
							}
						}
					}else {
						System.out.println("\nNão há tarefas adicionadas para serem concluídas\n");
					}
					erro = true;
				}
				
				case 0 ->{
					System.out.println("\nFim do programa.");
				}
			
			}
			
		}
		
	}

}
