package pl.edu.pw.fizyka.pojava.matmac.bundles;

import java.util.ListResourceBundle;

public class StatsBundle extends ListResourceBundle {

	private Object[][] contents= {
			{"Najlepszy rzut","Najlepszy rzut"},
			{"Liczba odbić:","Liczba odbić:"},
			{"Odległość:","Odległość:"},
			{"Czas lotu:","Czas lotu:"},
			{"Ostatni rzut","Ostatni rzut"},
			{"Zapisz","Zapisz"},
			{"Historia","Historia"},
			{"Prędkość rzutu [m/s]","Prędkość rzutu [m/s]"},
			{"Kąt rzutu (do osi OX) [o]","Kąt rzutu (do osi OX) [o]"},
			{"Kąt kamienia (do osi OX) [o]","Kąt kamienia (do osi OX) [o]"},
			{"Masa kamienia [g]","Masa kamienia [g]"},
			{"Wysokość rzutu [m]","Wysokość rzutu [m]"},
			{"Współczynnik oporu powietrza [kg/s]","Współczynnik oporu powietrza [kg/s]"},
			{"RZUĆ!","RZUĆ!"},
			{"Puszczanie kaczek","Puszczanie kaczek"},
			{"Stats","Statystyki"},
			{"Par","Parametry"},
			{"Zamknij","Zamknij"},
		};

		
		protected Object[][] getContents() {
			return contents;
		}

}
