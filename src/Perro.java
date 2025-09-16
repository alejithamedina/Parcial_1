import java.util.ArrayList;
import java.util.List;

public class Perro {
    public static void add(Perro p) {
    }
    // Creacion de Lista

    static List<Perro> perros = new ArrayList<>();

    //Enum usado para el tamaño
    enum Tamano {PEQUENO, MEDIANO, GRANDE}

    private static int nextId = 1;

    // Atributos

    private int id;
    private String nombre;
    private String raza;
    private int edadmeses;
    private Tamano tamano;
    private boolean vacunado;
    private boolean esterilizado;
    private boolean adoptado;
    private String adoptante;

    //Constructor Vacio
    public Perro(String nombre, String raza, int edadMeses, Tamano tamano, boolean vacunado, boolean esterilizado) {
        this.id = nextId++;
        this.adoptado = false;
        this.adoptante = null;
    }

    //Constructor Con Parametros

    public Perro(int id, String nombre, String raza, int edadmeses, boolean vacunado, boolean esterilizado,
                 boolean adoptado, String adoptante) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edadmeses = edadmeses;
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
        this.adoptado = false;
        this.adoptante = null;
    }

    //Getters Y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad_meses() {
        return edadmeses;
    }

    public void setEdad_meses(int edadmeses) {
        this.edadmeses = edadmeses;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(String adoptante) {
        this.adoptante = adoptante;
    }

    //Metodo Vacunar:
    public void Vacunar() {
        this.vacunado = true;
    }

    //Metodo Esterilizar:
    public void Esterilizar() {
        this.esterilizado = true;
    }

    //Metodo MarcarAdoptado:
    public boolean Adoptar(String adoptante) {
        if (this.adoptado) return false;
        this.adoptado = true;
        this.adoptante = adoptante;
        return true;
    }

    // Metodo Calcular Edad Humana :
    public double calcularEdadHumanaAprox() {
        return (this.edadmeses / 12.0) * 7.0;
    }

    //Metodo AptoParaDepartamento:
    public boolean aptoParaDepartamento() {
        return (this.tamano == Tamano.PEQUENO || this.tamano == Tamano.MEDIANO) && this.vacunado;
    }
 //Metodo To String
    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edadmeses=" + edadmeses +
                ", tamano=" + tamano +
                ", vacunado=" + vacunado +
                ", esterilizado=" + esterilizado +
                ", adoptado=" + adoptado +
                ", adoptante='" + adoptante + '\'' +
                '}';
    }
}
