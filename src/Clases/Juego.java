package Clases;

import Interfaz.IFiltrado;

import java.util.Objects;

public class Juego implements IFiltrado {
    private Integer id;
    private String titulo;
    private String genero;
    private String creador;
    private String version;

    public Juego(Integer id, String titulo, String genero, String creador, String version) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.creador = creador;
        this.version = version;
    }


    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", creador='" + creador + '\'' +
                ", version=" + version +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juego juego)) return false;
        return Objects.equals(id, juego.id);
    }

    @Override
    public int hashCode() {
        return 1;
    }


    @Override
    public String buscarPorGenero() {
        return getGenero().trim();
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
            setVersion(modificacion);
        }
    }


}
