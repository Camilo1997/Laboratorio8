/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import java.util.List;

/**
 *
 * @author camilo
 */
public class MyBATISClienteDAO implements ClienteDAO{
    
    @Inject
    private ClienteMapper clienteMapper;
    
    @Override
    public void save(Cliente c) throws PersistenceException {
        try{ 
            clienteMapper.agregarCliente(c.getDocumento(), c.getNombre(), c.getTelefono(), c.getDireccion(), c.getEmail(), c.isVetado());
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el cliente "+c.toString() ,e);
        }
    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        try{ 
            clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al cargar el cliente "+id ,e);
        }        
        return clienteMapper.consultarCliente(id);
    }    

    @Override
    public List<Cliente> loadClientes() throws PersistenceException {
        return clienteMapper.consultarClientes();
    }
}
