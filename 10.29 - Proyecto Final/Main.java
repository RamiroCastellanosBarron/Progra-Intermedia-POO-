import java.util.*;

public class Main {
	public static void main(String[] args) {

		String formatoTitulo = "| %25s %-15s %24s |%n";
		String formatoSala = "| %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s |%n";
		String formatoNumeros = "%-9s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s |%n";
		String formatoEntradaInstruccion = "| %20s %-25s %19s |%n";
		String formatoEntradaOpcion = "| %10s %-10s %10s | %10s %-10s %9s |%n";
		String formatoBienvenida = "| %-25s %-10s %-29s |%n";
		String formatoTipoCuenta = "| %16s %17s| %-12s %17s |%n";
		String formatoOpcionOperador = "| %-3s | %-30s %29s |%n";
		String[][] usuarios = new String[2][3];
		usuarios[0][0] = "Ramiro";
		usuarios[0][1] = "Pa$$w0rd";
		usuarios[0][2] = "Admin";
		usuarios[1][0] = "Miguel";
		usuarios[1][1] = "Pa$$w0rd";
		usuarios[1][2] = "Operador";
		String[][] funciones = new String[1][3];
		funciones[0][0] = "1";
		funciones[0][1] = "Rey Leon";
		funciones[0][2] = "7:00PM";
		String titulo = "Star-Wars";
		String doblaje = "Esp. Lat.";
		String subtitulos = "Esp.";
		String numSala = "Sala 8";
		String precio = "$45.00MXN";
		String disponibilidad = "50";
		String hora = "7:15PM";
		String sala[][] = new String[11][11];
		for (int i = 0; i < sala.length; i++) {
			for (int j = 0; j < sala.length; j++) {
				sala[i][j] = " ";
			}
		}
		// filas [columnas][filas] numeros
		sala[10][0] = " ";
		sala[10][1] = "1";
		sala[10][2] = "2";
		sala[10][3] = "3";
		sala[10][4] = "4";
		sala[10][5] = "5";
		sala[10][6] = "6";
		sala[10][7] = "7";
		sala[10][8] = "8";
		sala[10][9] = "9";
		sala[10][10] = "10";
		// columnas LETRAS
		// [filas][columnas]
		sala[0][0] = "J";
		sala[1][0] = "I";
		sala[2][0] = "H";
		sala[3][0] = "G";
		sala[4][0] = "F";
		sala[5][0] = "E";
		sala[6][0] = "D";
		sala[7][0] = "C";
		sala[8][0] = "B";
		sala[9][0] = "A";
		boolean llave = false;
		boolean llavePrincipal = false;
		boolean llaveOpcion = false;
		boolean opcionIngreso = false;
		while (opcionIngreso == false) {
			Scanner sc = new Scanner(System.in);
			imprimirEntrada("DESEA ENTRAR AL SISTEMA", "Si", "No", formatoEntradaInstruccion, formatoEntradaOpcion);
			String opcionSistema = sc.nextLine();
			if (opcionSistema.equalsIgnoreCase("si")) {
				opcionIngreso = true;
				imprimirTitulo("SISTEMA CINE", formatoTitulo);
				while (llavePrincipal == false) {
					imprimirTitulo("INICIAR SESION", formatoTitulo);
					System.out.print("  >>  Ingrese su usuario: ");
					String usuario = sc.nextLine();
					if (usuarios[0][0].equalsIgnoreCase(usuario)) {
						llavePrincipal = true;
						while (llave == false) {
							System.out.print("\n  >>  Ingrese su contrasenia: ");
							String contrasenia = sc.nextLine();
							if (usuarios[0][1].equals(contrasenia)) {
								imprimirBienvenida(usuarios[0][0], usuarios[0][2], formatoBienvenida,
										formatoTipoCuenta);
								llave = true;
							} else {
								System.out.println("Contrasenia incorrecta.");
							}
						}
					} else if (usuarios[1][0].equalsIgnoreCase(usuario)) {
						llavePrincipal = true;
						while (llave == false) {
							System.out.print("\n  >>  Ingrese su contrasenia: ");
							String contrasenia = sc.nextLine();
							if (usuarios[1][1].equals(contrasenia)) {
								Scanner sc2 = new Scanner(System.in);
								imprimirBienvenida(usuarios[1][0], usuarios[1][2], formatoBienvenida,
										formatoTipoCuenta);
								while (llaveOpcion == false) {
									imprimirOpcionesOperador(formatoOpcionOperador);
									int opcion = sc2.nextInt();
									if (opcion == 1) {
										Scanner sc3 = new Scanner(System.in);
										imprimirCartelera(titulo, doblaje, subtitulos, numSala, precio, disponibilidad,
												hora);
										String opcionFuncion = sc3.nextLine();
										if (funciones[0][0].equalsIgnoreCase(opcionFuncion)) {
											imprimirTitulo("SALA", formatoTitulo);
											imprimirLinea();
											for (int i = 0; i < sala.length - 1; i++) {
												System.out.printf(formatoSala, sala[i][0], " ", sala[i][1], sala[i][2],
														sala[i][3], sala[i][4], sala[i][5], sala[i][6], sala[i][7],
														sala[i][8], sala[i][9], sala[i][10]);
												imprimirLinea();
											}
											System.out.println();
											imprimirLineaFinal();
											System.out.printf(formatoNumeros, " ", sala[10][1], sala[10][2],
													sala[10][3], sala[10][4], sala[10][5], sala[10][6], sala[10][7],
													sala[10][8], sala[10][9], sala[10][10]);
											imprimirLineaFinal();
										} else {
											System.out.println("Opcion invalida");
										}
										sc3.close();
									} else if (opcion == 2) {
										llaveOpcion = true;
									} else {
										System.out.println("Opcion invalida.");
									}
									llave = true;
								}
								sc2.close();
							} else {
								System.out.println("Contrasenia incorrecta.");
							}
						}

					} else {
						System.out.println("No existe el usuario.");
					}
				}
			} else if (opcionSistema.equalsIgnoreCase("No")) {
				imprimirTitulo("ADIOS", formatoTitulo);
			} else if (!opcionSistema.equalsIgnoreCase("No")) {
				imprimirTitulo("RESPUESTA INVALIDA", formatoTitulo);
			} else if (!opcionSistema.equalsIgnoreCase("Si")) {
				imprimirTitulo("RESPUESTA INVALIDA", formatoTitulo);
			}
			sc.close();
		}
	}

	static void imprimirTitulo(String titulo, String formatoTitulo) {
		System.out.format("%n+--------------------------------------------------------------------+%n");
		System.out.printf(formatoTitulo, " ", titulo, " ");
		System.out.format("+--------------------------------------------------------------------+%n%n");
	}

	static void imprimirLinea() {
		System.out.format("+----+    +----+----+----+----+----+----+----+----+----+----+%n");
	}

	static void imprimirLineaFinal() {
		System.out.format("          +----+----+----+----+----+----+----+----+----+----+%n");
	}

	static void imprimirEntrada(String instruccion, String opcion1, String opcion2, String formatoEntradaInstruccion,
			String formatoEntradaOpcion) {
		System.out.format("%n+--------------------------------------------------------------------+%n");
		System.out.printf(formatoEntradaInstruccion, " ", instruccion, " ");
		System.out.format("+----------------------------------+---------------------------------+%n");
		System.out.printf(formatoEntradaOpcion, " ", opcion1, " ", " ", opcion2, " ");
		System.out.format("+----------------------------------+---------------------------------+%n%n");
		System.out.print("  >>  Ingrese su opcion: ");
	}

	static void imprimirBienvenida(String nomUsuario, String tipoCuenta, String formatoBienvenida,
			String formatoTipoCuenta) {
		System.out.format("%n+--------------------------------------------------------------------+%n");
		System.out.printf(formatoBienvenida, " ", "BIENVENIDO", nomUsuario, " ");
		System.out.format("+-----------------------------------+--------------------------------+%n");
		System.out.printf(formatoTipoCuenta, " ", "Tipo de cuenta ", tipoCuenta, " ");
		System.out.format("+-----------------------------------+--------------------------------+%n");
	}

	static void imprimirOpcionesOperador(String formatoOpcionOperador) {
		System.out.format("%n+-----+--------------------------------------------------------------+%n");
		System.out.printf(formatoOpcionOperador, "1", "Ver cartelera", " ");
		System.out.format("+-----+--------------------------------------------------------------+%n");
		System.out.printf(formatoOpcionOperador, "2", "Cerrar sesion", " ");
		System.out.format("+-----+--------------------------------------------------------------+%n%n");
		System.out.print("  >>  Ingrese su opcion: ");
	}

	static void imprimirCartelera(String titulo, String doblaje, String subtitulos, String numSala, String precio,
			String disponibilidad, String hora) {
		String formatoCarteleraTitulo = "| %1s | %-25s|%5s| %1s | %-25s|%5s| %1s | %-25s|%n";
		String formatoOpcionesCartas = "| %11s | %-14s |%5s| %11s | %-14s |%5s| %11s | %-14s |%n";
		System.out.format(
				"%n+---+--------------------------+     +---+--------------------------+     +---+--------------------------+%n");
		System.out.printf(formatoCarteleraTitulo, "1", titulo, " ", "2", "Indiana Jones", " ", "3", "Jumanji");
		System.out.format(
				"+---+--------------------------+     +---+--------------------------+     +---+--------------------------+%n");
		System.out.printf(formatoOpcionesCartas, "Doblaje", doblaje, " ", "Doblaje", "Ingles", " ", "Doblaje", doblaje,
				" ");
		System.out.printf(formatoOpcionesCartas, "Subs", subtitulos, " ", "Subs", "Ingles[CC]", " ", "Subs", subtitulos,
				" ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n");
		System.out.printf(formatoOpcionesCartas, numSala, precio, " ", "Sala 3", precio, " ", "Sala 5", precio, " ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n");
		System.out.printf(formatoOpcionesCartas, "Disp.", disponibilidad, " ", "Disp.", "12", " ", "Disp.", "94", " ");
		System.out.printf(formatoOpcionesCartas, "Hora", hora, " ", "Hora", hora, " ", "Hora", hora, " ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n%n");
		System.out.format(
				"+---+--------------------------+     +---+--------------------------+     +---+--------------------------+%n");
		System.out.printf(formatoCarteleraTitulo, "4", "The Godfather", " ", "5", "Toy Story", " ", "6", "Shrek");
		System.out.format(
				"+---+--------------------------+     +---+--------------------------+     +---+--------------------------+%n");
		System.out.printf(formatoOpcionesCartas, "Doblaje", "Ingles", " ", "Doblaje", "Esp. Lat.", " ", "Doblaje",
				doblaje, " ");
		System.out.printf(formatoOpcionesCartas, "Subs", "Ingles[CC]", " ", "Subs", "Sin subs", " ", "Subs", subtitulos,
				" ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n");
		System.out.printf(formatoOpcionesCartas, "Sala 1", "$75.00MXN", " ", "Sala 11", precio, " ", "Sala 4", precio,
				" ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n");
		System.out.printf(formatoOpcionesCartas, "Disp.", "3", " ", "Disp.", "35", " ", "Disp.", "0", " ");
		System.out.printf(formatoOpcionesCartas, "Hora", "2:30PM", " ", "Hora", "5:00PM", " ", "Hora", "11:25AM", " ");
		System.out.format(
				"+-------------+----------------+     +-------------+----------------+     +-------------+----------------+%n%n");
		System.out.print("  >>  Ingrese su opcion: ");

		
	}

	static String[] leerNombre() {
		Scanner sc = new Scanner(System.in);
		String[] nombre = new String[3];
		System.out.println("Nombre Completo");
		System.out.print("  >>  primer nombre: ");
		nombre[0] = sc.nextLine();
		System.out.print("  >>  Apellido paterno: ");
		nombre[1] = sc.nextLine();
		System.out.print("  >>  Apellido materno: ");
		nombre[2] = sc.nextLine();
		sc.close();
		return nombre;
	}
	
	static int[] leerFecha(){
		Scanner sc = new Scanner(System.in);
		int[] fecha = new int[3];
		System.out.println("Fecha de Funcion ");
		System.out.print("  >>  Dia: ");
		fecha[0] = sc.nextInt();
		System.out.print("  >>  Mes: ");
		fecha[1] = sc.nextInt();
		System.out.print("  >>  Anio: ");
		fecha[2] = sc.nextInt();
		sc.close();
		return fecha;
	}
	
	static int leerHora() {
		Scanner sc = new Scanner(System.in);
		int hora = 0;
		System.out.print("  >>  Hora: ");
		hora = sc.nextInt();
		sc.close();
		return hora;
	}
	
	static int leerMinutos() {
		Scanner sc = new Scanner(System.in);
		int minuto = 0;
		System.out.print("  >> Minuto: ");
		minuto = sc.nextInt();
		sc.close();
		return minuto;
	}
	
	static String leerTipo(){
		Scanner sc = new Scanner(System.in);
		String tipo="";
		System.out.println("tipo: ");
		tipo = sc.nextLine();
		sc.close();
		return tipo;
	  }
	
	static String leerUsuario(){
		Scanner sc = new Scanner(System.in);
		String usuario="";
		System.out.print("  >>  Nombre usuario: ");
		usuario = sc.nextLine();
		sc.close();
		return usuario;
	  }
	
	static String leerContrasenia(){
		Scanner sc = new Scanner(System.in);
		String contrasenia="";
		System.out.print("  >>  Contrasenia: ");
		contrasenia = sc.nextLine();
		sc.close();
		return contrasenia;
	  }
	
	static String leerTitulo(){
		Scanner sc = new Scanner(System.in);
		String titulo = "";
		System.out.print("  >>  Titulo: ");
		titulo = sc.nextLine();
		sc.close();
		return titulo;
	  }
	  
	static String leerIdiomas(){
		String idiomas="";
		Scanner sc = new Scanner(System.in);
		System.out.print("  >>  Idioma: ");
		idiomas = sc.nextLine();
		sc.close();
		return idiomas;
	  }
	
	static String leerSubtitulos(){
		String subtitulos="";
		Scanner sc = new Scanner(System.in);
		System.out.println("  >>  Subtitulos: ");
		subtitulos = sc.nextLine();
		sc.close();
		return subtitulos;
	  }
	
	static int leerNoSala(){
		int noSala = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero de Sala: ");
		noSala = sc.nextInt();
		sc.close();
		return noSala;
	  }
	
	static int leerDisponibilidad(){
		int disponibilidad = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("  >>  Asientos Disponibles: ");
		disponibilidad = sc.nextInt();
		sc.close();
		return disponibilidad;
	  }
	
	static int leerCapacidad() {
		Scanner sc = new Scanner(System.in);
		int capacidad=0;
		System.out.print("  >>  Numero de Asientos en Sala: ");
		capacidad = sc.nextInt();
		sc.close();
		return capacidad;
	}
	
	static int leerNumBoleto(){
		int numBoleto = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("  >>  Numero de boleto: ");
		numBoleto = sc.nextInt();
		sc.close();
		return numBoleto;
	}
	
	static String leerAsiento(){
		String asiento = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Asiento: ");
		asiento = sc.nextLine();
		sc.close();
		return asiento;
	}
	
	static double leerPrecio() {
		Scanner sc = new Scanner(System.in);
		double precio = 0;
		System.out.println("Precio del Boleto: ");
		precio = sc.nextDouble();
		sc.close();
		return precio;
	  }
	
	static int leerCantidad() {
		Scanner sc = new Scanner(System.in);
		int cantidad=0;
		System.out.println("  >>  Cantidad de boletos: ");
		cantidad = sc.nextInt();
		sc.close();
		return cantidad;
	}
	
	static String leerTituloFuncionBoleto() {
		Scanner sc = new Scanner(System.in);
		String tituloFuncionBoleto = "";
		System.out.println("  >>  Funcion del boleto: ");
		tituloFuncionBoleto = sc.nextLine();
		sc.close();
		return tituloFuncionBoleto;
	}
	
	static double leerPrecioUnitario() {
		Scanner sc = new Scanner(System.in);
		double precioUnitario=0;
		System.out.println("  >>  Precio Unitario del boleto: ");
		precioUnitario = sc.nextDouble();
		sc.close();
		return precioUnitario;
	}
	
	static double leerDescuento() {
		Scanner sc = new Scanner(System.in);
		double descuento = 0;
		System.out.println("  >>  Descuento del boleto: ");
		descuento = sc.nextDouble();
		sc.close();
		return descuento;
	}
}