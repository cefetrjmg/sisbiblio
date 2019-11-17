/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.reports;

import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author cristian
 */
public class Report {

    public static void authorsByBook(ArrayList<Obra> obras)  {
        try {
            String pacote="/src/br/cefetrj/mg/bsi/sisbiblio/reports/";
            String caminho=System.getProperty("user.dir")+pacote;
            String arquivo="autores_por_obra.jasper";
            HashMap params =new HashMap();
            JRBeanCollectionDataSource jr =new JRBeanCollectionDataSource(obras);
            JasperPrint jasperPrint=JasperFillManager.fillReport(caminho+arquivo,params,jr);
            JasperExportManager.exportReportToPdfFile(jasperPrint,"autores_por_obra.pdf");
            Desktop.getDesktop().open(new File("autores_por_obra.pdf"));
        } catch (JRException | IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   


}
