package entity;

import javax.persistence.*;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private VooPacote vooPacote;
    @ManyToOne
    private HotelPacote hotelPacote;
    @ManyToOne
    private LocacaoPacote locacaoPacote;
    @ManyToOne
    private SeguroPacote seguroPacote;
    @ManyToOne
    private ReservaPacote reservaPacote;
    @ManyToOne
    private UsuarioPacote usuarioPacote;

    public Pacote() {}

    public Pacote(VooPacote vooPacote, HotelPacote hotelPacote, LocacaoPacote locacaoPacote, SeguroPacote seguroPacote, ReservaPacote reservaPacote, UsuarioPacote usuarioPacote) {
        this.vooPacote = vooPacote;
        this.hotelPacote = hotelPacote;
        this.locacaoPacote = locacaoPacote;
        this.seguroPacote = seguroPacote;
        this.reservaPacote = reservaPacote;
        this.usuarioPacote = usuarioPacote;
    }

    public VooPacote getVoo() {
        return vooPacote;
    }

    public void setVoo(VooPacote vooPacote) {
        this.vooPacote = vooPacote;
    }

    public HotelPacote getHotel() {
        return hotelPacote;
    }

    public void setHotel(HotelPacote hotelPacote) {
        this.hotelPacote = hotelPacote;
    }

    public LocacaoPacote getLocacao() {
        return locacaoPacote;
    }

    public void setLocacao(LocacaoPacote locacaoPacote) {
        this.locacaoPacote = locacaoPacote;
    }

    public SeguroPacote getSeguro() {
        return seguroPacote;
    }

    public void setSeguro(SeguroPacote seguroPacote) {
        this.seguroPacote = seguroPacote;
    }

    public ReservaPacote getReserva() {
        return reservaPacote;
    }

    public void setReserva(ReservaPacote reservaPacote) {
        this.reservaPacote = reservaPacote;
    }

    public UsuarioPacote getUsuario() {
        return usuarioPacote;
    }

    public void setUsuario(UsuarioPacote usuarioPacote) {
        this.usuarioPacote = usuarioPacote;
    }



}
