package ar.edu.unahur.obj2.observer;

public class Alerta {
    private String tipo;
    private Integer nivel;
    
    public Alerta(String tipo, Integer nivel){
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public Boolean esCritica(){
        return nivel >= 8;
    }

    public Integer getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }
}
