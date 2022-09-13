package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Teste concluído");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Iniciando testes");
	}
	
	@AfterAll
	public static void finalizarTodos() {
		System.out.println("Testes finalizados");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoComDesempenhoADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);	
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());	
	
	}  
	
	@Test
	public void reajusteDeveriaSerDe15PorCentoComDesempenhoBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);	
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());	
	
	} 
	
	@Test
	public void reajusteDeveriaSerDe20PorCentoComDesempenhoOtimo() { 
		service.concederReajuste(funcionario, Desempenho.OTIMO);	
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());	
	
	} 
	
}
