package com.pluralcamp.wbe.entities;

import java.util.Random;

public class Color  {

    //<editor-fold defaultstate="collapsed" desc="Estado: Atributos/Campos">
    private long id = -1;
    private String name;
    private int red;
    private int green;
    private int blue;

    public static final int MAX_VALUE = 255;
    public static final int MIN_VALUE = 0;
    public static final String DEFAULT_NAME = "Undefined";
    private static int counter = 0;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Comportamiento: Métodos/Operaciones">

    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public Color(String name, int red, int green, int blue) {
        counter++;
        this.setName(name);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }
    public Color(int red, int green, int blue) {
        this(DEFAULT_NAME, red, green, blue);
    }

    Color() {}

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public long getId() {
        return id;
    }

    public void setId(long id) {
//        if (this.getId() != -1) {
//            throw new UnsupportedOperationException("No se puede cambiar el id de un objeto ya asignado");
//        }
        if (id <= 0) {
            throw new IllegalArgumentException("El id a asignar a una entidad debe ser un valor positivo");
        }

        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar el nombre del color!!");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if (red < MIN_VALUE || red > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido para la coordenada R. Valores válidos: %d - %d", red, MIN_VALUE, MAX_VALUE));
        }
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        if (green < MIN_VALUE || green > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido para la coordenada G. Valores válidos: %d - %d", green, MIN_VALUE, MAX_VALUE));
        }
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if (blue < MIN_VALUE || blue > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido para la coordenada B. Valores válidos: %d - %d", blue, MIN_VALUE, MAX_VALUE));
        }
        this.blue = blue;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="API pública del objeto">
    public String toRGBString(boolean upper) {
        return String.format("%s(%d, %d, %d)", upper ? "RGB": "rgb", this.getRed(), this.getGreen(), this.getBlue());
    }

    public String toRGBString() {
        return toRGBString(false);
    }

    public String toHexString(boolean upper) {
        return String.format(upper ? "#%02X%02X%02X" : "#%02x%02x%02x", this.getRed(), this.getGreen(), this.getBlue());
    }

    public String toHexString() {
        return toHexString(true);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Sobreescritura de métodos">
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%n-----------------------------------%n"));
        sb.append(String.format("   C O L O R%n"));
        sb.append(String.format("-----------------------------------%n"));
        sb.append(String.format("- Id:       %s %n", this.getId()));
        sb.append(String.format("- Nombre:   %s %n", this.getName()));
        sb.append(String.format("- RGB:      %s %n", this.toRGBString()));
        sb.append(String.format("- Hex:      %s %n", this.toHexString()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Color)) {
            return false;
        }

        Color other = (Color)obj;
        return ((this.getName().equalsIgnoreCase(other.getName())) && (this.getRed() == other.getRed())
               && (this.getGreen()== other.getGreen()) && (this.getBlue()== other.getBlue()));
    }

    @Override
    public int hashCode() {
        return String.format("%S,%d,%d,%d", this.getName(), this.getRed(), this.getGreen(), this.getBlue()).hashCode();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos estáticos o de clase">
    public static int getCounter() {
        return counter;
    }

    public static Color getRandom() {
        Random rnd = new Random();
        return new Color(rnd.nextInt(MAX_VALUE + 1), rnd.nextInt(MAX_VALUE + 1), rnd.nextInt(MAX_VALUE + 1));
    }

    public static Color fromHexString(String name, String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar una cadena de texto");
        }
        if (!color.matches("^#[0-9A-Fa-f]{6}$")) {
            throw new IllegalArgumentException(String.format("El texto %s no tiene formato de color en hexadecimal", color));
        }
        return new Color(name, Integer.parseInt(color.substring(1,3), 16), Integer.parseInt(color.substring(3,5), 16), Integer.parseInt(color.substring(5,7), 16));
    }

    public static Color fromHexString(String color) {
        return fromHexString(DEFAULT_NAME, color);
    }
    //</editor-fold>

    //</editor-fold>
}
