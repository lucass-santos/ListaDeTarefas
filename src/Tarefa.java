
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private boolean concluiuTarefa;
	private LocalDateTime horarioConclusao;
	
	
	public Tarefa(String titulo, String descricao) {
		
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
		this.concluiuTarefa = false;
		this.horarioConclusao = null; 
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean isConcluiuTarefa() {
		return concluiuTarefa;
	}

	public void setConcluiuTarefa(boolean concluiuTarefa) {
		this.concluiuTarefa = concluiuTarefa;
	}

	public LocalDateTime getHorarioConclusao() {
		return horarioConclusao;
	}

	public void setHorarioConclusao(LocalDateTime horarioConclusao) {
		this.horarioConclusao = horarioConclusao;
	}

	@Override
	public String toString() {
		DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormated = DateTimeFormatter.ofPattern("HH:mm:ss");
		DateTimeFormatter finishedFormated = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada =  dataCriacao.format(dateFormated);
		String horaFormatada =  dataCriacao.format(timeFormated);
		if(concluiuTarefa == true) {
			String conclusaoFormatada = horarioConclusao.format(finishedFormated);
			return "Titulo: " + titulo +
					"\nDescricao: " + descricao + 
					"\nData de criacao: " + dataFormatada +
					"\nHorário criacao: " + horaFormatada+
					"\nConcluiu a tarefa?: sim" + 
					"\nData da Conclusao: " + conclusaoFormatada;
		}else {
			return "Titulo: " + titulo +
					"\nDescricao: " + descricao + 
					"\nData de criacao: " + dataFormatada +
					"\nHorário criacao: " + horaFormatada+
					"\nConcluiu a tarefa? : não";
		}
		
	}
	
}
