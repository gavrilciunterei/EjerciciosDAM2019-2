
public class TemporizadorProbar {

	public static void main(String[] args) {

		Temporizador ext = new Temporizador(2, 59, 9);
		Temporizador end = new Temporizador(3, 0, 0);

		System.out.println(end.compareTo(ext));
		end.dec();
		System.out.println(end.compareTo(ext));
		ext.dec();
		System.out.println(end.compareTo(ext));

		System.out.println(ext);
		System.out.println(end);

		System.out.println("-- A POR NOTA --");
		Temporizador now = new Temporizador();
		int veces = 0;
		while (now.compareTo(end) > 0) {
			now.dec(1, 2, 3);
			veces++;
		}
		System.out.println(now);
		System.out.println(end);
		System.out.println(veces);
	}

}
