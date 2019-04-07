/**
 * Sample Skeleton for 'GestoreCorsi.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {

	private GestoreCorsi model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnStatCorsi"
    private Button btnStatCorsi; // Value injected by FXMLLoader
    
    @FXML
    private TextField txtFieldCorso;
    // txtCorso

    @FXML
    private Button btnStudentiCorso;
    
    @FXML
    private Button btnCDS;

    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {
    	
    	int periodo;
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	if(periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	Map<Corso, Integer> res = model.getIscrittiCorsi(1); // periodo
    	
    	for(Entry entry : res.entrySet()) {
    		txtResult.appendText(((Corso)entry.getKey()).getNome() + "=" + entry.getValue() + "\n");
    	}
    	
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	int periodo;
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
    	for(Corso c : corsi) {
    		txtResult.appendText(c.toString() + "\n");
    	}
    	
    }
    

    @FXML
    void doCalcolaStatCDS(ActionEvent event) {

    }
    
    @FXML
    void doElencaStudenti(ActionEvent event) {
    	
    	String codins = txtFieldCorso.getText();
    	List<Studente> studenti = this.model.elencaStudenti(codins);
    	
    	for(Studente s : studenti) {
    		txtResult.appendText(s.toString()+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtFieldCorso != null : "fx:id=\"txtFieldCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStudentiCorso != null : "fx:id=\"btnStudentiCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCDS != null : "fx:id=\"btnCDS\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
    }
    
    public void setModel(GestoreCorsi model) {
    	this.model = model;
    }
    
}
