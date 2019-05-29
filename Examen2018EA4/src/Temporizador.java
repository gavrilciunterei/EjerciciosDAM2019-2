
public class Temporizador {

	private int minutos;
	private int segundos;
	private int decimas;

	public Temporizador() {
		this.minutos = 59;
		this.segundos = 59;
		this.decimas = 0;
	}

	public Temporizador(int minutos, int segundos, int decimas) {
		comprobarMinutos(minutos);
		comprobarSegundos(segundos);
		comprobarDecimas(decimas);
	}

	private void comprobarMinutos(int minutos) {
		if (minutos > 59 || minutos < 0) {
			this.minutos = 0;
		} else {
			this.minutos = minutos;
		}
	}

	private void comprobarSegundos(int segundos) {
		if (segundos > 59 || segundos < 0) {
			this.segundos = 0;
		} else {
			this.segundos = segundos;
		}
	}

	private void comprobarDecimas(int decimas) {
		if (decimas > 59 || decimas < 0) {
			this.decimas = 0;
		} else {
			this.decimas = decimas;
		}
	}

	public String toString() {
		return minutos + "." + segundos + "." + decimas;
	}

	public int compareTo(Temporizador t) {
		int total = 1;

		if (minutos < t.minutos) {
			total = -1;
		}
		if (minutos == t.minutos) {
			if (segundos == t.segundos) {
				if (decimas == t.decimas) {
					total = 0;
				}
				if (decimas > t.decimas) {
					total = 1;
				}
				if (decimas < t.decimas) {
					total = -1;
				}
			}
			if (segundos > t.segundos) {
				total = 1;
			}
			if (segundos < t.segundos) {
				total = -1;
			}
		}
		if (minutos > t.minutos) {
			total = 1;
		}
		return total;
	}

	public boolean equals(Temporizador t) {
		if (minutos == t.minutos && segundos == t.segundos && decimas == t.decimas) {
			return true;
		}
		return false;
	}

	public void dec() {
		if (decimas > 0) {
			decimas--;
		} else {
			if (segundos > 0) {
				decimas = 9;
				segundos--;
			} else {
				if (minutos > 0) {
					segundos = 59;
					decimas = 9;
					minutos--;
				}
			}
		}
	}

	public void dec(int minutos, int segundos, int decimas) {

		if (this.minutos - minutos < 0) {
			this.minutos = 0;
		} else {
			this.minutos -= minutos;
		}
		if (this.segundos - segundos < 0) {
			this.segundos = 0;
		} else {
			this.segundos -= segundos;
		}
		if (this.decimas - decimas < 0) {
			this.decimas = 0;
		} else {
			this.decimas -= decimas;
		}

	}

}
