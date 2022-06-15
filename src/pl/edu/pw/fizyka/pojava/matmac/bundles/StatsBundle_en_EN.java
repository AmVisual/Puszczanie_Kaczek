package pl.edu.pw.fizyka.pojava.matmac.bundles;

import java.util.ListResourceBundle;

public class StatsBundle_en_EN extends ListResourceBundle {



	private Object[][] contents= {
			{"Najlepszy rzut","Best throw"},
			{"Liczba odbic:","Number of bounces:"},
			{"Odleglosc:","Distance:"},
			{"Czas lotu:","Flight time:"},
			{"Ostatni rzut","Last throw"},
			{"Zapisz","Save"},
			{"Historia","History"},
			{"Predkosc rzutu [m/s]","Throw speed [m/s]"},
			{"Kat rzutu (do osi OX) [o]","Throw angle (to OX axis) [o]"},
			{"Kat kamienia (do osi OX) [o]","Stone angle (to OX axis) [o]"},
			{"Masa kamienia [g]","Stone mass [g]"},
			{"Wysokosc rzutu [m]","Throw height [m]"},
			{"Wspolczynnik oporu powietrza [kg/s]","Air resistance coefficient [kg/s]"},
			{"RZUC!","THROW!"},
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
