package br.com.zup.xyinc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.xyinc.model.PontoDeInteresse;
import br.com.zup.xyinc.repository.PontoDeInteresseRepository;
import br.com.zup.xyinc.service.exception.CoordenadaInvalidaException;

/**
 * Classe que representa o serviço de pontos de interesse
 * @author danilo
 *
 */
@Service
public class PontoDeInteresseService {
	
	@Autowired
	private PontoDeInteresseRepository repository;
	
	/**
	 * Serviço para cadastrar pontos de interesse
	 * @param obj - objeto de ponto de interesse
	 * @return objeto do tipo PontoDeInteresse
	 */
	public PontoDeInteresse insert(PontoDeInteresse obj) {
		if(!isValidCoordinate(obj.getCoordenadaX(), obj.getCoordenadaY())) {
			throw new CoordenadaInvalidaException("Coordenada informada é inválida.");
		}
		
		obj.setId(null); /*Garantir que realmente está inserindo um objeto novo*/
		return repository.save(obj); 
	}
	
	/**
	 * Serviço para listar todos os POIs cadastrados
	 * @return lista de pontos de interesse
	 */
	public List<PontoDeInteresse> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Serviço para listar todos os POIs da base de dados que estejam a uma distância menor ou igual a distância máxima a partir do ponto de referência.
	 * @param coordenadaX - coordenada X
	 * @param coordenadaY - coordenada Y
	 * @param distanciaMax - distância máxima
	 * @return lista de pontos de interesse
	 */
	public List<PontoDeInteresse> searchByProximity(Long coordenadaX, Long coordenadaY, Double distanciaMax) {
		if(!isValidCoordinate(coordenadaX, coordenadaY)) {
			throw new CoordenadaInvalidaException("Coordenada informada é inválida.");
		}
		
		return repository.searchByProximity(coordenadaX, coordenadaY, distanciaMax);
	}
	
	/**
	 * Método para validar se as coordenadas são válidas (inteiro não negativo)
	 * @param obj - objeto de ponto de interesse
	 * @return true se as coordenadas forem positivas ou false se forem negativas
	 */
	private Boolean isValidCoordinate(Long coordenadaX, Long coordenadaY) {
		if((coordenadaX != null && coordenadaX < 0) || (coordenadaY != null && coordenadaY < 0)) {
			return false;
		}
		
		return true;
	}
}
