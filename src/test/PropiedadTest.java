package test;

import datos.PropiedadDao;
import datos.impl.PropiedadDaoImpl;
import dominio.Propiedad;

public class PropiedadTest {

    public static void main(String[] args) {
        insertar();
    }
    private static void insertar() {
    PropiedadDao datos = new PropiedadDaoImpl();
    Propiedad obj = new Propiedad();

    // Establecer valores para los atributos de la propiedad
    obj.setNombre("Nombre de la Propiedad");
    obj.setDireccion("Dirección de la Propiedad");
    obj.setCaracteristicas("Características de la Propiedad");
    obj.setEstado("Estado de la Propiedad");
    obj.setPrecioAlquiler(1000.0); // Ajustar según sea necesario

    try {
        // Intentar realizar la inserción
        System.out.println(datos.insertar(obj));
    } catch (Exception e) {
        // Manejar excepciones, imprimir mensaje de error o realizar otras acciones
        e.printStackTrace();
    }
}

}
