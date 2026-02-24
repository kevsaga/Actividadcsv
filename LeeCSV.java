import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeCSV {
    public static void main(String[] args) {
        String rutaArchivo = "datos.csv";
        int contadorNotasAltas = 0;
        int totalEdades = 0;
        int cantidadEstudiantes = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                String nombre = columnas[0];
                int edad = Integer.parseInt(columnas[1].trim());
                int nota = Integer.parseInt(columnas[2].trim());
                
                if (nota >= 90) {
                    contadorNotasAltas++;
                }
                totalEdades += edad;
                cantidadEstudiantes++;
            }
            double promedioEdad = (cantidadEstudiantes > 0) ? (double) totalEdades / cantidadEstudiantes : 0;

            System.out.println("Cantidad de estudiantes con nota >= 90: " 
                                + contadorNotasAltas);
            System.out.println("Promedio de edad: " + promedioEdad);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
