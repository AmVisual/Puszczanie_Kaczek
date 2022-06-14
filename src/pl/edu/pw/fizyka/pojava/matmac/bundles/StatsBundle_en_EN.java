package pl.edu.pw.fizyka.pojava.matmac.bundles;

import java.util.ListResourceBundle;

public class StatsBundle_en_EN extends ListResourceBundle {



	private Object[][] contents= {
			{"Najlepszy rzut","Best throw"},
			{"Liczba odbić:","Number of bounces:"},
			{"Odległość:","Distance:"},
			{"Czas lotu:","Flight time:"},
			{"Ostatni rzut","Last throw"},
			{"Zapisz","Save"},
			{"Historia","History"},
			{"Prędkość rzutu [m/s]","Throw speed [m/s]"},
			{"Kąt rzutu (do osi OX) [o]","Throw angle (to OX axis) [o]"},
			{"Kąt kamienia (do osi OX) [o]","Stone angle (to OX axis) [o]"},
			{"Masa kamienia [g]","Stone mass [g]"},
			{"Wysokość rzutu [m]","Throw height [m]"},
			{"Współczynnik oporu powietrza [kg/s]","Air resistance coefficient [kg/s]"},
			{"RZUĆ!","THROW!"},
			{"Puszczanie kaczek","Skipping stones"},
			{"Stats","Statistics"},
			{"Par","Parameters"},
			{"Zamknij","Exit"},
			{"dz","Acceptable range: ["},
		};

		
		protected Object[][] getContents() {
			return contents;
		}

}
