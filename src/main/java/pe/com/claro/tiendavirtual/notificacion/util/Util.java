package pe.com.claro.tiendavirtual.notificacion.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	Logger log = LoggerFactory.getLogger(Util.class);
	
	public static Date addDays(Date date, Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, days * 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	
	public static String DateToExtendDate(int diasdespacho) {

        try {
            Date fechaActual = new Date();
            String[] diasES = {"Domingo","Lunes", "Martes", "Miércoles", "Jueves", "Viernes","Sábado"};
            String[] mesesES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

            DateFormat dd = new SimpleDateFormat("dd");
            DateFormat mm = new SimpleDateFormat("MM");
            DateFormat yy = new SimpleDateFormat("yyyy");
            Calendar fecha = new GregorianCalendar(Integer.parseInt(yy.format(fechaActual)), Integer.parseInt(mm.format(fechaActual))-1, Integer.parseInt(dd.format(fechaActual))+diasdespacho);

            fecha.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int numdia = fecha.get(Calendar.DAY_OF_WEEK);
            return diasES[numdia-1]+" "+dia+" de "+mesesES[mes];
        } catch (Exception e) {
        	System.out.println("Error convertir fecha: "+e.getMessage());
        }
        
		return null;
	}
	

	public static String formatDate(String date) {
		String[] c = date.split("");
        return c[4] + c[5] + "/" + c[2] + c[3] + "/" + c[0] + c[1] + " " + c[6] + c[7] + ":" + c[8] + c[9] + ":" + c[10] + c[11];
	}
}
