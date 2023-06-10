package com.pluralcamp.wbe.entities;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Event {

    //<editor-fold defaultstate="collapsed" desc="Estado: Atributos/Campos">
    private long id = -1;
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String place;
    private String description;
    private Color backgroundColor;
    private Color textColor;
    private boolean visible;
    private LocalDateTime registrationDate;
    
    public static final int MIN_DURATION = 30;
    private static final int NAME_MAX_LENGTH = 50;
    private static final int PLACE_MAX_LENGTH = 100;
    private static final int DESCRIPTION_MAX_LENGTH = 500;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Comportamiento: Métodos/Operaciones">
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Event(String name, LocalDate date, LocalTime startTime, LocalTime endTime, String place, String description, Color backgroundColor, Color textColor, boolean visible) {    
        this.setName(name);
        this.setDate(date);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setPlace(place);
        this.setDescription(description);
        this.setBackgroundColor(backgroundColor);
        this.setTextColor(textColor);
        this.setVisible(visible);
        this.setRegistrationDate(LocalDateTime.now());
    }
   
    public Event(String name, LocalDate date, LocalTime startTime, LocalTime endTime, String place, String description, Color backgroundColor, Color textColor) {    
        this(name, date, startTime, endTime, place, description, backgroundColor, textColor, true);
    }
    
    public Event(String name, LocalDate date, String place, String description, Color backgroundColor, Color textColor, boolean visible) {    
        this(name, date, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 59),place, description, backgroundColor, textColor, visible);
    }
    
    public Event(String name, LocalDate date, String place, String description, Color backgroundColor, Color textColor) {    
        this(name, date, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 59), place, description, backgroundColor, textColor, true);
    }
    
    public Event(String name, String date, String startTime, String endTime, String place, String description, Color backgroundColor, Color textColor, boolean visible) {    
        this(name, LocalDate.parse(date, DATE_FORMATTER), LocalTime.parse(startTime, TIME_FORMATTER), LocalTime.parse(endTime, TIME_FORMATTER), place, description, backgroundColor, textColor, visible);
    }
    
    public Event(String name, String date, String startTime, String endTime, String place, String description, Color backgroundColor, Color textColor) {    
        this(name, date, startTime, endTime, place, description, backgroundColor, textColor, true);
    }
    
    public Event(String name, String date, String place, String description, Color backgroundColor, Color textColor, boolean visible) {    
        this(name, date, "00:00", "23:59", place, description, backgroundColor, textColor, visible);
    }
    
    public Event(String name, String date, String place, String description, Color backgroundColor, Color textColor) {    
        this(name, date, place, description, backgroundColor, textColor, true);
    }
    
    private Event() {}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (this.getId() != -1) {
            throw new UnsupportedOperationException("No se puede cambiar el id de un objeto ya asignado");
        }
        if (id <= 0) {    
            throw new IllegalArgumentException("El id a asignar a una entidad debe ser un valor positivo");
        }
        
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar el nombre de un evento");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("El nombre del evento no puede ser superior a %d caracteres. Longitud indicada: %d", NAME_MAX_LENGTH, name.length()));
        }
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (this.getDate() != null && this.isFinished()) {
            throw new UnsupportedOperationException("No se puede cambiar la fecha de un evento ya celebrado");
        }
        if (date == null) {
            throw new NullPointerException("Es obligatorio indicar la fecha de celebración del evento");
        }
        
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if (this.getStartTime() != null && this.isFinished()) {
            throw new UnsupportedOperationException("No se puede cambiar la hora de inicio de un evento ya celebrado");
        }
        if (startTime == null) {
            throw new NullPointerException("Es obligatorio indicar la hora de inicio del evento");
        }
        if (this.getEndTime() != null && !startTime.isBefore(this.getEndTime())) {
            throw new IllegalArgumentException("La hora de finalización del evento no puede ser anterior o igual a la hora de inicio");
        }
        if (this.getEndTime() != null && Duration.between(startTime, this.getEndTime()).toMinutes() < MIN_DURATION) {
            throw new IllegalArgumentException("La duración del evento no puede ser inferior a 30'");
        }
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (this.getEndTime() != null && this.isFinished()) {
            throw new UnsupportedOperationException("No se puede cambiar la hora de fin de un evento ya celebrado");
        }
        if (endTime == null) {
            throw new NullPointerException("Es obligatorio indicar la hora de fin del evento");
        }
        if (this.getStartTime()!= null && !endTime.isAfter(this.getStartTime())) {
            throw new IllegalArgumentException("La hora de finalización del evento no puede ser posterior o igual a la hora de inicio");
        }
        if (this.getStartTime() != null && Duration.between(this.getStartTime(), endTime).toMinutes() < MIN_DURATION) {
            throw new IllegalArgumentException("La duración del evento no puede ser inferior a 30'");
        }
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (place == null || place.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar el lugar de celebración de un evento");
        }
        if (place.length() > PLACE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("El lugar de celebración del evento no puede ser superior a %d caracteres. Longitud indicada: %d", PLACE_MAX_LENGTH, place.length()));
        }
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar la descripción de un evento");
        }
        if (description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("La descripción del evento no puede ser superior a %d caracteres. Longitud indicada: %d", DESCRIPTION_MAX_LENGTH, description.length()));
        }
        this.description = description;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        if (backgroundColor == null) {
            throw new NullPointerException("Es obligatorio indicar el color de fondo del evento");
        }
        if (this.getTextColor() != null && backgroundColor.equals(this.getTextColor())) {
            throw new IllegalArgumentException(String.format("El color de fondo y de texto de un evento no puede ser el mismo. Color: %s", backgroundColor.toHexString()));
        }
        this.backgroundColor = backgroundColor;
    }
    
    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        if (textColor == null) {
            throw new NullPointerException("Es obligatorio indicar el color de texto del evento");
        }
        if (this.getBackgroundColor()!= null && textColor.equals(this.getBackgroundColor())) {
            throw new IllegalArgumentException(String.format("El color de fondo y de texto de un evento no puede ser el mismo. Color: %s", textColor.toHexString()));
        }
        this.textColor = textColor;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        if (registrationDate == null) {
            throw new NullPointerException("Es obligatorio indicar la fecha de registro del evento en el sistema");
        }
        
        this.registrationDate = registrationDate;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="API pública del objeto">
    
    public String getDateInfo() {
        return DATE_FORMATTER.format(this.getDate());
    }
    
    public String getStartTimeInfo(boolean timeIndicator) {
        return timeIndicator ? String.format("%sh", TIME_FORMATTER.format(this.getStartTime())) : TIME_FORMATTER.format(this.getStartTime());
    }
    
    public String getStartTimeInfo() {
        return getStartTimeInfo(false);
    }
    
    public String getEndTimeInfo(boolean timeIndicator) {
        return timeIndicator ? String.format("%sh", TIME_FORMATTER.format(this.getEndTime())) : TIME_FORMATTER.format(this.getEndTime());
    }
    
    public String getEndTimeInfo() {
        return getEndTimeInfo(false);
    }
    
    public String getDateTimeInfo(boolean timeIndicator) {
        return String.format("%s %s - %s", getDateInfo(), getStartTimeInfo(timeIndicator), getEndTimeInfo(timeIndicator));
    }
    
    public String getDateTimeInfo() {
        return getDateTimeInfo(false);
    }
    
    public String getRegistrationDateInfo() {
        return DATE_TIME_FORMATTER.format(this.getRegistrationDate());
    }
    
    public long getDuration() {
        return Duration.between(this.getStartTime(), this.getEndTime()).toMinutes();
    }
    
    public boolean isFinished() {
        return this.getDate().isBefore(LocalDate.now()) || (this.getDate().isEqual(LocalDate.now()) && this.getEndTime().isBefore(LocalTime.now()));
    }
    
    public boolean isBefore(Event event) {
        if (event == null) {
            throw new NullPointerException("El evento a comparar no puede ser la referencia nula");
        }
        return this.getDate().isBefore(event.getDate()) || (this.getDate().isEqual(event.getDate()) && this.getStartTime().isBefore(event.getStartTime()));
    }
    
    public boolean isAfter(Event event) {
        if (event == null) {
            throw new NullPointerException("El evento a comparar no puede ser la referencia nula");
        }
        
        return this.getDate().isAfter(event.getDate()) || (this.getDate().isEqual(event.getDate()) && this.getStartTime().isAfter(event.getStartTime()));
    }
    
    public int getDaysLeft() {
        return isFinished() ? 0 : Period.between(LocalDate.now(), this.getDate()).getDays();
    }
    
    public int getDaysPassed() {
        return !isFinished() ? 0 : Period.between(this.getDate(), LocalDate.now()).getDays();
    }
    
    public int getDaysBetween(Event event) {
        if (event == null) {
            throw new NullPointerException("El evento a comparar no puede ser la referencia nula");
        }
        
        return Math.abs(Period.between(this.getDate(), event.getDate()).getDays());
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Sobreescritura de métodos">
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("-------------------------------------%n"));
        sb.append(String.format("   E V E N T O %n"));
        sb.append(String.format("-------------------------------------%n"));
        sb.append(String.format("- Id:             %d %n", this.getId()));
        sb.append(String.format("- Nombre:         %s %n", this.getName()));
        sb.append(String.format("- Fecha:          %s %n", this.getDateInfo()));
        sb.append(String.format("- Inicio:         %s %n", this.getStartTimeInfo()));
        sb.append(String.format("- Fin:            %s %n", this.getEndTimeInfo()));
        sb.append(String.format("- Lugar:          %s %n", this.getPlace()));
        sb.append(String.format("- Descripción:    %s %n", this.getDescription()));
        sb.append(String.format("- Color de fondo: %s %n", this.getBackgroundColor().toHexString()));
        sb.append(String.format("- Color de texto: %s %n", this.getTextColor().toHexString()));
        sb.append(String.format("- Visible:        %s %n", this.isVisible()));
        sb.append(String.format("- Registrado:     %s %n", this.getRegistrationDateInfo()));
        return sb.toString();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos estáticos o de clase">
    
    public static int getDaysBetween(Event event1, Event event2) {
        if (event1 == null || event2 == null) {
            throw new NullPointerException("Los eventos a comparar no puede ser la referencia nula");
        }
        
        return Math.abs(Period.between(event1.getDate(), event2.getDate()).getDays());
    }
    //</editor-fold>
    
    //</editor-fold>

}

