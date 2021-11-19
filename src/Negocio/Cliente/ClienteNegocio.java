package Negocio.Cliente;

import Datos.Cliente.ClienteDatos;
import Recursos.Clases.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteNegocio {
    public List<Cliente> Leer()throws Exception{
        List<Cliente> listaClientes = new ArrayList<>();
        try{
            listaClientes = ClienteDatos.leerClientes();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaClientes;
    }
    public String Insertar(Cliente pCliente)throws Exception{
        String respuesta = "Error";
        try{
            //DNI
            if(String.valueOf(pCliente.getDNI()).isEmpty()){
                throw new Exception("Error: El DNI esta vacio.");
            }
            if(validarID(pCliente)){
                throw new Exception("Error: El DNI esta en uso.");
            }
            if((String.valueOf(pCliente.getDNI()).length()) <= 0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(pCliente.getDNI()).length()) < 13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(pCliente.getDNI()).length()) > 13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Codigo
            if(String.valueOf(pCliente.getCodigo()).isEmpty()){
                throw new Exception("Error: EL Codigo esta vacio.");
            }
            if(validarCodigo(pCliente)){
                throw new Exception("Error: El codigo ya esta registrado");
            }
            if((String.valueOf(pCliente.getCodigo()).length())<=0){
                throw new Exception("Error: EL Codigo no debe ser menor o igual a 0.");
            }
            if((String.valueOf(pCliente.getCodigo()).length())<7){
                throw new Exception("Error: EL Codigo es muy corto.");
            }
            if((String.valueOf(pCliente.getCodigo()).length())>7){
                throw new Exception("Error: EL Codigo es muy largo.");
            }
            //Categoria
            if((pCliente.getCategoria()).isEmpty()){
                throw new Exception("Error: La categoria esta vacia.");
            }
            if((pCliente.getCategoria()).length() < 4){
                throw new Exception("Error: La categoria es muy corta.");
            }
            if((pCliente.getCategoria()).length() >9){
                throw new Exception("Error: La categoria es muy larga.");
            }
            //Fecha de Ingreso
            if(String.valueOf(pCliente.getFechaIngreso()).isEmpty()){
                throw new Exception("Error: La fecha de ingreso esta vacia.");
            }
            //Saldo
            if(String.valueOf(pCliente.getSaldo()).isEmpty()){
                throw new Exception("Error: El saldo esta vacio.");
            }
            if(pCliente.getSaldo() < 0){
                throw new Exception("Error: El saldo no debe ser menor a 0.");
            }
            //Correo
            if(pCliente.getCorreoElectronico().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(pCliente.getCorreoElectronico().length() < 12){
                throw new Exception("Error: El correo electronico es muy corto.");
            }
            if(pCliente.getCorreoElectronico().length() > 30){
                throw new Exception("Error: El correo electronico es muy largo.");
            }
            //Ocupacion
            if(pCliente.getOcupacion().isEmpty()){
                throw new Exception("Error: La ocupacion esta vacia.");
            }
            if(pCliente.getOcupacion().length() < 3){
                throw new Exception("Error: La ocupacion es muy corta.");
            }
            if(pCliente.getOcupacion().length() > 25){
                throw new Exception("Error: La ocupacion es muy larga.");
            }
            //Tipo de Membresia
            if(pCliente.getTipoMembresia().isEmpty()){
                throw new Exception("Error: La membresia esta vacia.");
            }
            if(pCliente.getTipoMembresia().length() < 4){
                throw new Exception("Error: La membresia es muy corta.");
            }
            if(pCliente.getTipoMembresia().length() > 8){
                throw new Exception("Error: La membresia es muy larga.");
            }
            respuesta= ClienteDatos.insertarCliente(pCliente);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
           throw new Exception(e.getMessage());
            //JOptionPane.showMessageDialog(null,e.getMessage() + "1","Exito",JOptionPane.INFORMATION_MESSAGE);
        }
        finally{
            return respuesta;
        }
    }
    public String Actualizar(Cliente pCliente)throws Exception{
        String respuesta= "Error";
        try{
            //DNI
            if(String.valueOf(pCliente.getDNI()).isEmpty()){
                throw new Exception("Error: El DNI esta vacio.");
            }
            if((String.valueOf(pCliente.getDNI()).length()) <= 0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(pCliente.getDNI()).length()) < 13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(pCliente.getDNI()).length()) > 13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Codigo
            if(String.valueOf(pCliente.getCodigo()).isEmpty()){
                throw new Exception("Error: EL Codigo esta vacio.");
            }
            if((String.valueOf(pCliente.getCodigo()).length())<=0){
                throw new Exception("Error: EL Codigo no debe ser menor o igual a 0.");
            }
            if((String.valueOf(pCliente.getCodigo()).length())<7){
                throw new Exception("Error: EL Codigo es muy corto.");
            }
            if((String.valueOf(pCliente.getCodigo()).length())>7){
                throw new Exception("Error: EL Codigo es muy largo.");
            }
            //Categoria
            if((pCliente.getCategoria()).isEmpty()){
                throw new Exception("Error: La categoria esta vacia.");
            }
            if((pCliente.getCategoria()).length() < 4){
                throw new Exception("Error: La categoria es muy corta.");
            }
            if((pCliente.getCategoria()).length() >9){
                throw new Exception("Error: La categoria es muy larga.");
            }
            //Fecha de Ingreso
            if(String.valueOf(pCliente.getFechaIngreso()).isEmpty()){
                throw new Exception("Error: La fecha de ingreso esta vacia.");
            }
            //Saldo
            if(String.valueOf(pCliente.getSaldo()).isEmpty()){
                throw new Exception("Error: El saldo esta vacio.");
            }
            if(pCliente.getSaldo() < 0){
                throw new Exception("Error: El saldo no debe ser menor a 0.");
            }
            //Correo
            if(pCliente.getCorreoElectronico().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(pCliente.getCorreoElectronico().length() < 12){
                throw new Exception("Error: El correo electronico es muy corto.");
            }
            if(pCliente.getCorreoElectronico().length() > 30){
                throw new Exception("Error: El correo electronico es muy largo.");
            }
            //Ocupacion
            if(pCliente.getOcupacion().isEmpty()){
                throw new Exception("Error: La ocupacion esta vacia.");
            }
            if(pCliente.getOcupacion().length() < 3){
                throw new Exception("Error: La ocupacion es muy corta.");
            }
            if(pCliente.getOcupacion().length() > 25){
                throw new Exception("Error: La ocupacion es muy larga.");
            }
            //Tipo de Membresia
            if(pCliente.getTipoMembresia().isEmpty()){
                throw new Exception("Error: La membresia esta vacia.");
            }
            if(pCliente.getTipoMembresia().length() < 4){
                throw new Exception("Error: La membresia es muy corta.");
            }
            if(pCliente.getTipoMembresia().length() > 8){
                throw new Exception("Error: La membresia es muy larga.");
            }
            respuesta= ClienteDatos.actualizarCliente(pCliente);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public void Eliminar(Cliente pCliente)throws Exception{
        try{
            ClienteDatos.eliminarCliente(pCliente);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Cliente> Buscar(Cliente pCliente)throws Exception{
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            listaCliente = ClienteDatos.buscarCliente(pCliente);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCliente;
    }
    public boolean validarID(Cliente pCliente)throws Exception{
        List<Cliente> listaCliente = new ArrayList<>();
        boolean condicion=false;
        try {
            listaCliente = Leer();
            for (Cliente item: listaCliente) {
                if((pCliente.getDNI()) == item.getDNI()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
    public boolean validarCodigo(Cliente pCliente) throws Exception{
        List<Cliente> listaCliente= new ArrayList<>();
        boolean condicion=false;
        try{
            listaCliente = Leer();
            for (Cliente item: listaCliente) {
                if((pCliente.getCodigo()) == (item.getCodigo())){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }

}
