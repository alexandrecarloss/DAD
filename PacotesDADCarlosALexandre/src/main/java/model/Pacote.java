package model;

public class Pacote {

    private Voo voo;
    private Hotel hotel;
    private Locacao locacao;
    private Seguro seguro;
    private Reserva reserva;
    private Usuario usuario;

    public Pacote() {}

    public Pacote(Voo voo, Hotel hotel, Locacao locacao, Seguro seguro, Reserva reserva, Usuario usuario) {
        this.voo = voo;
        this.hotel = hotel;
        this.locacao = locacao;
        this.seguro = seguro;
        this.reserva = reserva;
        this.usuario = usuario;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
