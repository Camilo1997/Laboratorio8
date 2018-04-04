package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli")int id);
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idi")int id, 
            @Param("idclie")int idit, 
            @Param("feini")Date fechainicio,
            @Param("fefin")Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
        public void agregarCliente(@Param("doc") long documento, 
            @Param("nom") String nombre, 
            @Param("tel") String telefono,
            @Param("dir") String direccion, 
            @Param("mail") String email, 
            @Param("vetado") boolean vetado       
    );
}
