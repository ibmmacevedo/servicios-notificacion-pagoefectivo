package pe.com.claro.tiendavirtual.notificacion.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.claro.tiendavirtual.notificacion.repository.model.C2C;


@Repository
public interface C2CRepository extends CrudRepository<C2C, Integer>{

	@Query(value = "{call OBTENER_C2C(:piId)}", nativeQuery = true)
	public C2C getC2C(@Param("piId") String piId);
}
