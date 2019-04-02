package it.polito.tdp.corsi.model;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.model.Corso;

public class GestoreCorsi {

	public List<Corso> getCorsiByPeriodo(int periodo) {
		CorsoDAO dao = new CorsoDAO();
		
		// 1. Posso o farmi dare tutti i corsi e poi filtrarli internamente
		// 2. oppure filtrarli direttamente con la query
		
		//Soluzione 1
		/*List<Corso> corsi = dao.listAll();
		List<Corso> result = new ArrayList<Corso>();
		
		for(Corso c : corsi) {
			if(c.getPd() == periodo) {
				result.add(c);
			}
		}
		
		return result;
		*/
		
		//Soluzione 2
		return dao.listCorsiByPD(periodo);
	}

	
	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getIscrittiCorsi(periodo);
	}
	
}
