/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.SwingWorker;

/**
 *
 * @author Carlos
 */


public class Acao1 extends SwingWorker<Object, Object> {
	protected Object doInBackground() throws Exception {
		
		
		Main ma = new Main();
                ma.chamar();
		
		
		return null;
		
	}
	

}

