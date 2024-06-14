package Clases;

import Interfaz.IFiltrado;

import java.util.Objects;

public class Expansion implements IFiltrado {
    private Integer id;
    private String titulo;
    private String genero;
    private String creador;
    private String fechaLanzamiento;

    public Expansion(Integer id, String titulo, String genero, String fechaLanzamiento, String creador) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String buscarPorGenero() {
        return getGenero().trim() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expansion expansion)) return false;
        return Objects.equals(id, expansion.id);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public void modificar(int opcion, String modificacion) {
        if(opcion == 1){
            setTitulo(modificacion);
        } else if (opcion == 2) {
            setCreador(modificacion);
        } else if (opcion == 3) {
            setGenero(modificacion);
        } else if (opcion == 4) {
            setFechaLanzamiento(modificacion);
        }
    }

    @Override
    public String toString() {
        return "Expansion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", creador='" + creador + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                '}';
    }
}
