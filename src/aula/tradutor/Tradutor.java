package aula.tradutor;

import java.util.LinkedList;
import java.util.List;

import aula.tradutor.exception.WrongParamException;

public class Tradutor {
	
	private static final String REGEX_ROMAN_VALIDATION = "(M{1,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})|M{0,4}(CM|C?D|D?C{1,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})|M{0,4}(CM|CD|D?C{0,3})(XC|X?L|L?X{1,3})(IX|IV|V?I{0,3})|M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|I?V|V?I{1,3}))";
	
	public Integer converte(String roman) {
			
		validateRoman(roman);
		
		return getNumeralFromRomanAlg(roman);
		
	}

	private Integer getNumeralFromRomanAlg(String roman) {
		
		Integer numeral = 0;
		Integer lastNumber = 0;

		for (Integer algValue : getAlgarisms(roman)) {
			numeral = calculateRomanNumber(algValue, lastNumber, numeral);
			lastNumber = algValue;
		}
		
		return numeral;
	}

	private List<Integer> getAlgarisms(String romano) {
		
		List<Integer> algarismos = new LinkedList<Integer>();

		for (int i = romano.length() -1; i >= 0; i--) {

			String algAtual = null;
			Integer valorAtual = null;

			algAtual = ((Character) romano.charAt(i)).toString();

			for (Romanos romanos : Romanos.values()) {

				if (romanos.getRomano().equalsIgnoreCase(algAtual.toString())) {

					valorAtual = romanos.getValor();
				}
			}

			algarismos.add(valorAtual);
		}
		
		return algarismos;
	}

	private static void validateRoman(String roman) {
		
		if (roman == null || roman.isEmpty()) {
			throw new WrongParamException("Parametro romano n‹o pode ser nulo.", new Throwable("NULL_OR_EMPTY_PARAM"));
		}
		
		if (!roman.toUpperCase().matches(REGEX_ROMAN_VALIDATION)) {
			throw new WrongParamException("Algarismo inv‡lido", new Throwable("INVALID_PARAM"));
		}
		
	}
	
	private static int calculateRomanNumber(Integer atual, Integer lastNumber, Integer lastDecimal) {
		if (lastNumber > atual) {
			return lastDecimal - atual;
		} else {
			return lastDecimal + atual;
		}
	}

}
