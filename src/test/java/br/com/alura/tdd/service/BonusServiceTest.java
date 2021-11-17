package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	

	private BonusService service;
	private Funcionario func;
	
	@BeforeEach
	public void inicializa() {
		this.service = new BonusService();
		
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		this.func = new Funcionario("Tester", LocalDate.now(), new BigDecimal("25000"));
		
		// ****** MÉTODO 01 - USO DE assertThrows *********
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(func));

		// ****** MÉTODO 02 - USO DE try/catch *********
//		try {
//			service.calcularBonus(new Funcionario("Tester", LocalDate.now(), new BigDecimal("25000")));
//			fail("Exceção não foi lançada");
//		} catch (Exception e) {
//			assertEquals("Funcionário com salário acima de R$10.000,00 não podem receber bônus.", e.getMessage());
//		}
		
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		this.func = new Funcionario("Tester", LocalDate.now(), new BigDecimal("2500"));
		BigDecimal bonus = service.calcularBonus(func);
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDe10000() {
		this.func = new Funcionario("Tester", LocalDate.now(), new BigDecimal("10000"));
		BigDecimal bonus = service.calcularBonus(func);
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
	

}
