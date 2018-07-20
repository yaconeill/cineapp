package net.yaco.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	/**
	 * Metodo que devuelve una lista de Strings con las fechas siguientes, segun el parametro count.
	 * @param count
	 * @return
	 */
	public static List<String> getNextDate(int count){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));			
		}
		return nextDays;
	}
	
	public static String saveImage(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String originalName = multiPart.getOriginalFilename();
		originalName = originalName.replace(" ", "-");
		String finalName = randomAphaNumeric(8) + originalName;
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		String finalPath = request.getServletContext().getRealPath("/resources/images/");
		
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(finalPath + finalName);
			//System.out.println(imageFile.getAbsolutePath());
			// Aqui se guarda fisicamente el archivo en el disco duro
			multiPart.transferTo(imageFile);
			return finalName;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	public static String randomAphaNumeric(int count) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CHARACTERS.length());
			builder.append(CHARACTERS.charAt(character));
		}
		return builder.toString();
	}
	
	public static String toString(int n , String[] items) {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(n).length() < 2 ? "0" + n + " - " : "" + n + " - ");
		for(String i : items) {
			sb.append(i + " - ");
		}
		//return (Integer.toString(n).length() < 2 ? "0" + n : "" + n);
		return sb.toString().substring(0, sb.length() - 2);
	}

}
