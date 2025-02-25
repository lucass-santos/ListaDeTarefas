import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ListaDeTarefas {
	private ArrayList<Tarefa> lista = new ArrayList<>();
	
	
	public boolean adicionarTarefa(String titulo, String descricao) {
		return this.lista.add(new Tarefa(titulo, descricao));
	}
	
	
	public Tarefa removerTarefa(int escolha) {
		return lista.remove(escolha);
	}
	
	public boolean listarTarefas(int escolha) {
		if(lista.size() > 0) {
			if(escolha == 1) {
				lista = (ArrayList<Tarefa>) lista.stream().sorted(Comparator.comparing(Tarefa::getDataCriacao)).collect(Collectors.toList());
				for(int i = 0; i < lista.size(); i++) {
					System.out.println("\n----------------------------------------------");
					System.out.println("Tarefa nº "+ (i+1)+"\n"+lista.get(i).toString());
					System.out.println("----------------------------------------------");
				}
			}else {
				lista.sort(Comparator.comparing(Tarefa::getTitulo, String.CASE_INSENSITIVE_ORDER)); 
				for(int i = 0; i < lista.size(); i++) {
					System.out.println("\n----------------------------------------------");
					System.out.println("Tarefa nº "+ (i+1)+"\n"+lista.get(i).toString());
					System.out.println("----------------------------------------------");
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	public int tamanhoLista() {
		return lista.size();
	}
	
	public int verificarTituloIgual(String titulo) {
		for(Tarefa tarefa: lista) {
			if(tarefa.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				return 0;
			}
		}
		return 1;
	}
	
	public int verificarDescricaoIgual(String descricao) {
		for(Tarefa tarefa: lista) {
			if(tarefa.getDescricao().toLowerCase().equals(descricao.toLowerCase())) {
				return 0;
			}
		}
		return 1;
	}
	
	
	public boolean concluirTarefa(int indice) {
		if(lista.get(indice) != null) {
			lista.get(indice).setConcluiuTarefa(true);
			lista.get(indice).setHorarioConclusao(LocalDateTime.now());
			return true;
		}else {
			return false;
		}
	}
	
}
