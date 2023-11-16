package negocio;

import datos.PropiedadDao;
import datos.impl.PropiedadDaoImpl;
import dominio.Propiedad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PropiedadControl {

    private final PropiedadDao DATOS;
    private Propiedad obj;
    private int registrosMostrados;

    public PropiedadControl() {
        this.DATOS = new PropiedadDaoImpl();
        this.obj = new Propiedad();
        registrosMostrados = 0;
    }

    private DefaultTableModel modeloTabla;

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Propiedad> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        
        // Establecemos la columna del tableModel
        String[] titulos = {"ID", "NOMBRE", "DIRECCION", "CARACTERISTICAS", "ESTADO", "PRECIO ALQUILER", "CREATED_AT", "UPDATED_AT"};
        
        // Declaramos un vector que será el que agreguemos como registro al DefaultTableModel
        String[] registro = new String[8];
        
        // Agrego los títulos al DefaultTableModel
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        // Recorrer toda mi lista y la pasaré al DefaultTableModel
        for (Propiedad item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDireccion();
            registro[3] = item.getCaracteristicas();
            registro[4] = item.getEstado();
            registro[5] = Double.toString(item.getPrecioAlquiler());
            registro[6] = item.getCreatedAt().toString();  // Asegúrate de formatear adecuadamente la fecha
            registro[7] = item.getUpdatedAt().toString();  // Asegúrate de formatear adecuadamente la fecha
            
            this.registrosMostrados++;
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Propiedad obj) {
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en el ingreso de datos.";
        }
    }

    public String actualizar(Propiedad obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización de datos.";
        }
    }

    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK";
        } else {
            return "Error en la eliminación de datos.";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
