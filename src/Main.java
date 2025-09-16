import java.util.Scanner;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, ingresa un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarPerro(sc);
                    break;
                case 2:
                    buscarPorId(sc);
                    break;
                case 3:
                    registrarAdopcion(sc);
                    break;
                case 4:
                    vacunarPerro(sc);
                    break;
                case 5:
                    esterilizarPerro(sc);
                    break;
                case 6:
                    listarDisponibles();
                    break;
                case 7:
                    eliminarPorId(sc);
                    break;
                case 8:
                    listarTodos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;

            }
    }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("Seleccione número de opción:");
        System.out.println("1. Agregar perro");
        System.out.println("2. Buscar perro por ID");
        System.out.println("3. Registrar adopción");
        System.out.println("4. Vacunar perro");
        System.out.println("5. Esterilizar perro");
        System.out.println("6. Listar perros disponibles");
        System.out.println("7. Eliminar perro por ID");
        System.out.println("8. Listar todos los perros");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }



                private static void agregarPerro(Scanner sc) {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();

                    System.out.print("Raza: ");
                    String raza = sc.nextLine().trim();

                    System.out.print("Edad en meses: ");
                    int edadMeses;
                    try {
                        edadMeses = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Edad inválida.");
                        return;
                    }

                    System.out.print("Tamaño (PEQUENO, MEDIANO, GRANDE): ");
                    Perro.Tamano tamano;
                    try {
                        tamano = Perro.Tamano.valueOf(sc.nextLine().trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tamaño inválido. Se usará MEDIANO.");
                        tamano = Perro.Tamano.MEDIANO;
                    }

                    System.out.print("¿Vacunado? (s/n): ");
                    boolean vacunado = leerSiNo(sc);

                    System.out.print("¿Esterilizado? (s/n): ");
                    boolean esterilizado = leerSiNo(sc);

                    Perro p = new Perro(nombre,raza,edadMeses,tamano,vacunado, esterilizado);
                    Perro.add(p);
                    System.out.println("Agregado: " + p);
                }

    //Documentacion :

//* Busca y muestra la información de un perro por su ID.
    private static void buscarPorId(Scanner sc) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    Perro p = encontrarPorId(id);
                    if (p == null) {
                        System.out.println("No existe perro con id " + id);
                    } else {
                        System.out.println(p);
                    }
                }
//Registra la adopción de un perro si no ha sido adoptado previamente.
                private static void registrarAdopcion(Scanner sc) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Perro p = encontrarPorId(id);
                    if (p == null) {
                        System.out.println("No existe perro con id " + id);
                        return;
                    }
                    if (p.isAdoptado()) {
                        System.out.println("El perro ya fue adoptado por: " + p.getAdoptante());
                        return;
                    }
                    System.out.print("Nombre del adoptante: ");
                    String adoptante = sc.nextLine();
                    boolean ok = p.Adoptar(adoptante);
                    System.out.println(ok ? "Adopción registrada." : "No se pudo registrar adopción.");
                }

                private static void vacunarPerro(Scanner sc) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Perro p = encontrarPorId(id);
                    if (p == null) {
                        System.out.println("No existe perro con id " + id);
                        return;
                    }
                    p.Vacunar();
                    System.out.println("Vacunado: " + p.getNombre());
                }

                private static void esterilizarPerro(Scanner sc) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Perro p = encontrarPorId(id);
                    if (p == null) {
                        System.out.println("No existe perro con id " + id);
                        return;
                    }
                    p.Esterilizar();
                    System.out.println("Esterilizado: " + p.getNombre());
                }

                private static void listarDisponibles() {
                    System.out.println("Perros no adoptados:");
                    for (Perro p : Perro.perros) {
                        if (!p.isAdoptado()) {
                            System.out.println(p);
                        }
                    }
                }

                private static void eliminarPorId(Scanner sc) {
                    System.out.print("ID a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Perro p = encontrarPorId(id);
                    if (p == null) {
                        System.out.println("No existe perro con id " + id);
                        return;
                    }
                    Perro.perros.remove(p);
                    System.out.println("Eliminado id " + id);
                }

                private static void listarTodos() {
                    if (Perro.perros.isEmpty()) {
                        System.out.println("No hay perros registrados.");
                        return;
                    }
                    for (Perro p : Perro.perros) {
                        System.out.println(p);
                    }
                }
                // Utilidades
                private static Perro encontrarPorId(int id) {
                    for (Perro p : Perro.perros) {
                        if (p.getId() == id) return p;
                    }
                    return null;
                }
    // Lee una respuesta de sí/no desde consola y la convierte a boolean.
    private static boolean leerSiNo(Scanner sc) {
        String s = sc.nextLine().trim().toLowerCase();
        return s.equals("s") || s.equals("si") || s.equals("sí") || s.equals("y") || s.equals("yes");
    }


    

