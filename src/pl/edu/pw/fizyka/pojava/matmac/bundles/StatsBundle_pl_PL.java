package pl.edu.pw.fizyka.pojava.matmac.bundles;

import java.util.ListResourceBundle;

public class StatsBundle_pl_PL extends ListResourceBundle {
	

	private Object[][] contents= {
		{"Najlepszy rzut","Najlepszy rzut"},
		{"Liczba odbic:","Liczba odbić:"},
		{"Odleglosc:","Odległość:"},
		{"Czas lotu:","Czas lotu:"},
		{"Ostatni rzut","Ostatni rzut"},
		{"Zapisz","Zapisz"},
		{"Historia","Historia"},
		{"Predkosc rzutu [m/s]","Prędkość rzutu [m/s]"},
		{"Kat rzutu (do osi OX) [o]","Kąt rzutu (do osi OX) [o]"},
		{"Kat kamienia (do osi OX) [o]","Kąt kamienia (do osi OX) [o]"},
		{"Masa kamienia [g]","Masa kamienia [g]"},
		{"Wysokosc rzutu [m]","Wysokość rzutu [m]"},
		{"Wspolczynnik oporu powietrza [kg/s]","Współczynnik oporu powietrza [kg/s]"},
		{"RZUC!","RZUĆ!"},
		{"Puszczanie kaczek","Puszczanie kaczek"},
		{"Stats","Statystyki"},
		{"Par","Parametry"},
		{"Zamknij","Zamknij"},
		{"dz","Dopuszczalny zakres: ["},
	};

	
	protected Object[][] getContents() {
		return contents;
	}

}
