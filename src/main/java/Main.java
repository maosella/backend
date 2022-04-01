import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("20-34965448-3", "arcos dorados");
        Empleado emp1 = new Empleado("Juan", "Rodriguez", 1154,56000.00);
        Empleado emp2 = new Empleado("Jonatan", "Gutierrez", 1144,86000.00);
        Empleado emp3 = new Empleado("Martin", "Osella", 1148,86000.00);
        Empleado emp4 = new Empleado("Mario", "Martinez", 2144,58000.00);

        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        empresa.agregarEmpleado(emp4);

        //guardar la empresa en un archivos separando a los empleados mediante;

        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream("Empleados.txt");
            BufferedOutputStream buffer = new BufferedOutputStream(fos);

            for (Empleado empleado : empresa.getEmpleados()){
                String linea = empleado.getNombre()+";"+empleado.getApellido()+";"+empleado.getLegajo()+";"+empleado.getSueldo()+"\n";
                buffer.write(linea.getBytes());
                System.out.println(linea);
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
