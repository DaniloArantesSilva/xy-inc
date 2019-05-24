package br.com.zup.xyinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zup.xyinc.model.PontoDeInteresse;

/**
 * Interface que representa o repositório de pontos de interesse
 * @author danilo
 *
 */
@Repository
public interface PontoDeInteresseRepository extends JpaRepository<PontoDeInteresse, Integer> {
	
	/**
	 * Query que retorna todos os POIs da base de dados que estejam a uma distância menor ou igual a distância máxima a partir do ponto de referência.
	 * Para o cálculo da distância foi utilizado o Teorema de Pitágoras: D² = (xb - xa)² + (yb - ya)²  
	 * @param coordenadaX - coordenada X
	 * @param coordenadaY - coordenada Y
	 * @param distanciaMax - distância máxima
	 * @return lista de pontos de interesse
	 */
	@Query("SELECT obj "
		 + "FROM PontoDeInteresse obj "
		 + "WHERE sqrt(pow((obj.coordenadaX - :coordenadaX), 2) + pow((obj.coordenadaY - :coordenadaY),2)) <= :distanciaMax")
	List<PontoDeInteresse> searchByProximity(@Param("coordenadaX") Long coordenadaX, @Param("coordenadaY") Long coordenadaY, @Param("distanciaMax") Double distanciaMax);
}
