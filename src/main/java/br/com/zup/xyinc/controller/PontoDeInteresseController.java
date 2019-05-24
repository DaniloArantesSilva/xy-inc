package br.com.zup.xyinc.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.xyinc.model.PontoDeInteresse;
import br.com.zup.xyinc.service.PontoDeInteresseService;

/**
 * Classe que representa o controlador dos pontos de interesse
 * @author danilo
 *
 */
@RestController
@RequestMapping(value="/poi")
public class PontoDeInteresseController {
	
	@Autowired
	private PontoDeInteresseService service;
	
	/**
	 * Método para cadastrar pontos de interesse 
	 * RequestBody - faz o json ser convertido para o objeto java automaticamente
	 * @param obj - objeto de ponto de interesse a ser inserido
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PontoDeInteresse obj) {
		obj = service.insert(obj);
		
		/*Criando a URI do novo objeto*/
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}") /*pega a url de inserção e acrescenta o id do objeto criado*/
				.buildAndExpand(obj.getId()).toUri(); /*atribui o valor do id e converte para URI*/
		
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Método para listar todos os POIs cadastrados
	 * @return objeto ResponseEntity contendo no corpo a lista de pontos de interesse
	 */
	@RequestMapping(method=RequestMethod.GET)	
	public ResponseEntity<List<PontoDeInteresse>> findAll() {		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	/**
	 * Método para listar todos os POIs da base de dados que estejam a uma distância menor ou igual a distância máxima a partir do ponto de referência.
	 * @param coordenadaX - coordenada X
	 * @param coordenadaY - coordenada Y
	 * @param distanciaMax - distância máxima
	 * @return lista de pontos de interesse
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<PontoDeInteresse> searchByProximity(@RequestParam(value="coordenadaX") Long coordenadaX, 
			@RequestParam(value="coordenadaY")Long coordenadaY, @RequestParam(value="distanciaMax") Double distanciaMax) {
		
		return service.searchByProximity(coordenadaX, coordenadaY, distanciaMax);
	}
}
