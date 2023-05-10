package BusquedaEstudiante;
import javax.swing.JOptionPane;

public class Procesos {
    static String listado = "";
    private static String nombresEstudiantes [] = new String [100];
    public static int edadesEstudiantes [] = new int [100];
    public static int numEstudiantes  =  0;
    static int opcion = 0;
    public static void iniciar() {
        do {
            opcion = metodoMenu();
            switch (opcion) {
                case 1:
                    pedirDatos();
                    break;
                case 2:
                    calcularPromedioEdades();
                    break;
                case 3:
                    buscarEstudiantePorNombre();
                    break;
                case 4:
                    buscarEstudiantesPorEdad();
                    break;
                case 5:
                    buscarEstudiantesMenorEdad();
                    break;
                case 6:
                    buscarEstudiantesMayoresEdad();
                    break;
                case 7:
                    buscarEstudianteMayorEdad();
                    break;
                case 8:
                    imprimirListaEstudiantes();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "gracias por usar el sistema!", "proceso terminado", JOptionPane.CLOSED_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida.","ERROR",JOptionPane.ERROR_MESSAGE);
                    
            }
        } while (opcion != 9);
    }
    private static int metodoMenu() {
        String menu = "seleccione uan opcion.\n";
               menu += "1, almacenar Estudiantes.\n";
               menu += "2. calcular promedio de edades.\n";
               menu += "3. buscar estudiantes por nombres.\n";
               menu += "4. buscar estudiantes por edades. \n";
               menu += "5. buscar estudiantes menores de edad.\n";
               menu += "6. buscar estudiantes mayores de adeades.\n";
               menu += "7. buscar un solo estudiante mayor de edad.\n";
               menu += "8. imprimir listas de estudiantes almacenados.\n";
               menu += "9. terminar proceso.\n";
        String opcion = JOptionPane.showInputDialog(menu);       
        return Integer.parseInt(opcion);
    }
    private static void pedirDatos() {
        int cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de estudiantes a imprimir"));
        for (int i = 0; i < cantidadEstudiantes; i++) {
            String nombre = JOptionPane.showInputDialog("ingrese el nombre del estudiante");
            int edades = Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad del estudiante"));
            nombresEstudiantes[numEstudiantes]=nombre;
            edadesEstudiantes[numEstudiantes]=edades;
            numEstudiantes++;
        } 
    }
    private static void calcularPromedioEdades() {
        int sumaEdades=0;
        for (int i = 0; i < numEstudiantes; i++) {
            sumaEdades += edadesEstudiantes[i];
        }
        double promedioEdades = (double) sumaEdades / numEstudiantes;
        System.out.println("El promedio del todas las edades es: " + promedioEdades);
    }
    private static void buscarEstudiantePorNombre() {
        String buscaNombre = JOptionPane.showInputDialog("ingrese el nombre a buscar");
        int indice = -1;
        for (int i = 0; i < numEstudiantes; i++) {
            if (nombresEstudiantes[i].equalsIgnoreCase(buscaNombre)) {
                indice=i;
                break;
            }
        }
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "el nombre ingresado no existe", "ERROR DE ENTRADA", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("el estudiando encontrado es: " + nombresEstudiantes[indice] + " con edad de: " + edadesEstudiantes[indice]);
        }
    }
    private static void buscarEstudiantesPorEdad() {
        int buscaEdad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad buscar para buscar los estudiantes"));
        String cadstudent = "Estudiantes con edad " + buscaEdad + ":\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == buscaEdad) {
                cadstudent += "Nombre del estudiante " + nombresEstudiantes[i] + "\n y edad " + edadesEstudiantes[i] + "\n";
            }
            System.out.println(cadstudent);
        }
    }
    private static void buscarEstudiantesMenorEdad() {
        int menorEdad = Integer.MAX_VALUE;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] < menorEdad) {
                menorEdad = edadesEstudiantes[i];
            }
        }
        String estudaintesMenores = "El estudiante mas menor\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == menorEdad) {
                estudaintesMenores += "El estudiante: " + nombresEstudiantes[i] +"\n tiene una edad de: "+edadesEstudiantes[i]+" años." ;
            }
        }
        System.out.println(estudaintesMenores);
    }
    private static void buscarEstudiantesMayoresEdad() {
        int contador = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] >= 18) {
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Hay " + contador + " estudiantes mayores de edad.");
    }
    private static void buscarEstudianteMayorEdad() {
        int mayoresEstudiantes = Integer.MAX_VALUE;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] > mayoresEstudiantes) {
                mayoresEstudiantes = edadesEstudiantes[i];
            }
        }
        String estudiantesMayros = "El estudiante mas mayor\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == mayoresEstudiantes) {
                estudiantesMayros += "El estudiante: "+nombresEstudiantes[i]+" con una edad de: "+edadesEstudiantes[i]+" años\n";
            }
        }
        System.out.println(estudiantesMayros);
    }
    private static void imprimirListaEstudiantes() {
        listado += "lista de los estudiantes\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            listado += nombresEstudiantes[i] + " | " + edadesEstudiantes[i] + "\n";
        }
        System.out.println(listado);
    }
}

