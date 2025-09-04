import java.util.*;

public class BuggyActividadCorregido {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Validar índice
        if (nombres.size() > 2) {
            System.out.println("Elemento en posición 2: " + nombres.get(2));
        }

        // Comparación de cadenas con equals
        String buscado = "Ana";
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");

        if (!telefonos.containsKey("Ana")) {
            telefonos.put("Ana", "0993333333");
        } else {
            System.out.println("Ya existe Ana en el mapa, no se reemplaza");
        }

        // Validar clave inexistente
        if (telefonos.containsKey("Bea")) {
            System.out.println("Bea: " + telefonos.get("Bea"));
        } else {
            System.out.println("Bea no está registrada");
        }

        // SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // no se agregará porque equals/hashCode

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) { 
        this.id = id; 
        this.nombre = nombre; 
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno a = (Alumno) o;
        return id == a.id && nombre.equals(a.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}