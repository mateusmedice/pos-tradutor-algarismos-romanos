package aula.tradutor.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aula.tradutor.Tradutor;
import aula.tradutor.exception.WrongParamException;

public class TradutorTest {

	private Tradutor tradutor;
	
	private String algarismoRomano;
	
	private Integer numeral;
	
	@Before
	public void setup() {
		this.tradutor = new Tradutor();
		this.algarismoRomano = null;
		this.numeral = null;
	}

	@Test
	public void testConvertSuccess() {
		
		this.algarismoRomano = "XV";
		this.numeral = 15;
		
		Integer resultado = this.tradutor.converte(algarismoRomano);
		
		Assert.assertEquals(numeral, resultado);
	}
	
	@Test
	public void testConvertFail() {
		
		this.algarismoRomano = "XV";
		this.numeral = 9;
		
		Integer resultado = this.tradutor.converte(algarismoRomano);
		
		Assert.assertNotEquals(numeral, resultado);
	}

	@Test
	public void testConvertLowCaseParam() {
		
		this.algarismoRomano = "xv";
		this.numeral = 9;
		
		Integer resultado = this.tradutor.converte(algarismoRomano);
		
		Assert.assertNotEquals(this.numeral, resultado);
	}

	@Test(expected=WrongParamException.class)
	public void testConvertEmptyParam() {
		
		this.algarismoRomano = "";
		
		this.tradutor.converte(algarismoRomano);
			
	}
	
	@Test(expected=WrongParamException.class)
	public void testConvertNullParam() {
		
		this.algarismoRomano = null;
		
		this.tradutor.converte(algarismoRomano);
	}

	@Test(expected=WrongParamException.class)
	public void testConvertWrongParam1() {
		
		this.algarismoRomano = "XIIII";
		
		this.tradutor.converte(algarismoRomano);
	}
	
	@Test(expected=WrongParamException.class)
	public void testConvertWrongParam2() {
		
		this.algarismoRomano = "IIIIX";
		
		this.tradutor.converte(algarismoRomano);
	}

	@Test(expected=WrongParamException.class)
	public void testConvertWrongParam3() {
		
		this.algarismoRomano = "CCCIIIXXX";
		
		this.tradutor.converte(algarismoRomano);
	}
	
	@Test(expected=WrongParamException.class)
	public void testConvertWrongParam4() {
		
		this.algarismoRomano = "IVX";
		
		this.tradutor.converte(algarismoRomano);
	}
}
