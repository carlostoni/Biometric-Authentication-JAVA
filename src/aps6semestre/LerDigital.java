/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps6semestre;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos
 */




public class LerDigital extends GUI.CapDigtal{

   
    
    private DPFPEnrollment enrollador; // registrador
    private DPFPVerification verificador = DPFPGlobal.getVerificationFactory().createVerification(); // verificador
    private DPFPTemplate plantillaHuella;
    
    private DPFPVerificationResult resultado = null; //resultador da verificacao 
    private DPFPFeatureSet caracteristicas = null; // caracteristicas da digital
    
    private boolean BUSCAR = false;
    
    public LerDigital(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        
               try {
            enrollador = DPFPGlobal.getEnrollmentFactory().createEnrollment();            
        } catch (java.lang.UnsatisfiedLinkError | java.lang.NoClassDefFoundError e) {
            setVisible(false);
        }
    }
    @Override
    protected void processarDigital(DPFPSample sample){
        super.processarDigital(sample);
        
        caracteristicas = extractFeatures(sample,isBUSCAR()?DPFPDataPurpose.DATA_PURPOSE_VERIFICATION:DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        
        if(isBUSCAR()){
            try {                
                boolean encontrado = false;
                String sql = "SELECT idusuario, nome, digital FROM usuario WHERE digital is not null";
                ConexaoBD con = new ConexaoBD();
                con.conectar();
                ResultSet rs = con.CONSULTAR(sql);
                while(rs.next()){
                    resultado = verificador.verify(caracteristicas, DPFPGlobal.getTemplateFactory().createTemplate(rs.getBytes("digital")));
                    if(resultado.isVerified()){
                        System.out.println("HUELLA ES DE "+rs.getString("nome"));
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(LerDigital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if(caracteristicas != null){
            try{
                enrollador.addFeatures(caracteristicas);
                } catch (Exception e) {
                }finally{
                
                  switch(enrollador.getFeaturesNeeded()){
                    case 4:
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso0.PNG")));
                        break;
                    case 3:
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso1.PNG")));                               
                        break;
                    case 2:
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso2.png")));
                        break;
                    case 1:
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso3.png")));
                        break;
                    case 0:
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso4.png")));
                        break;
                }
                
                switch(enrollador.getTemplateStatus()){
                    case TEMPLATE_STATUS_READY:
                        stop();
                        setPlantillaHuella(enrollador.getTemplate());
                        setVisible(false);
                        break;

                    case TEMPLATE_STATUS_FAILED:
                        enrollador.clear();
                        stop();
                        setPlantillaHuella(null);
                        lblPasos.setIcon(new ImageIcon(getClass().getResource("/imagens/paso0.png")));                        
                        start();
                        break;                                
                    default: break;
                }
                    
                }
        }
        
    }
 
    public boolean isBUSCAR() {
        return BUSCAR;
    }

    
    public void setBUSCAR(boolean buscar) {
        this.BUSCAR = buscar;
    }

    public DPFPTemplate getPlantillaHuella() {
        return plantillaHuella;
    }

    public void setPlantillaHuella(DPFPTemplate plantillaHuella) {
        this.plantillaHuella = plantillaHuella;
    }

    
    
        
        
    
    
    
    
}

