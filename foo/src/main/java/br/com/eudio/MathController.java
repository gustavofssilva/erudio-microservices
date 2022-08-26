package br.com.eudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {
		
	//OPERAÇÕES MATEMATICAS
	
	
	
	//SOMA
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
		
	}
	
	
	
	//SUBTRAÇÃO
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sum;
		
	}
	
	
	
	//MULTIPLICAÇÃO
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return sum;
		
	}
	
	
	
	//DIVISÃO
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return sum;
		
	}
	
	
	
	//MEDIANA
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return sum;
		
	}
	
	
	
	//RAIZ QUADRADA
	@RequestMapping(value="/raiz/{number}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("number") String number)  throws Exception  {
		if(!isNumeric(number)) {
			throw new UnsupportedOperationException("Por favor, coloque um valor numérico!");
		}	
		Double sum = (Double) Math.sqrt(convertToDouble(number));
		return sum;
		
	}
	
	
	
	//CONVERSOR
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	
	
	//REGEX PRA VALIDAR
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches ("[-+]?[0-9]*\\.?[0-9]+");
	}

}
