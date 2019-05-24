package br.com.zup.xyinc;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zup.xyinc.model.PontoDeInteresse;
import br.com.zup.xyinc.service.PontoDeInteresseService;
import br.com.zup.xyinc.service.exception.CoordenadaInvalidaException;

/**
 * Classe que representa os testes da aplicação
 * @author danilo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PontoDeInteresseTest {

	
	@Autowired
	private PontoDeInteresseService service;
	
	/**
	 * Teste para validar se irá ser lançado uma exceção ao cadastrar um ponto de interesse com
	 * coordenadas negativas
	 */
	@Test
	public void testInsert() {
		assertThatThrownBy(() -> { service.insert(new PontoDeInteresse(null, "zup", (long)-5, (long)9)); })
        .isInstanceOf(CoordenadaInvalidaException.class)
        .hasMessageContaining("Coordenada informada é inválida.");
	}
	
	/**
	 * Teste para validar se irá ser lançado uma exceção ao listar os pontos de interesse por proximidade
	 * com valores de coordenadas negativas
	 */
	@Test
	public void testSearchByProximity() {		
		assertThatThrownBy(() -> { service.searchByProximity((long)-5, (long)9, 10.0); })
        .isInstanceOf(CoordenadaInvalidaException.class)
        .hasMessageContaining("Coordenada informada é inválida.");
	}
}
