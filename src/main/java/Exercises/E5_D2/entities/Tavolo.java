package Exercises.E5_D2.entities;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource("application.properties")
public class Tavolo {
    private int numero;
    private int coperti;
    @Value("${E5D2Application.coperto}")
    private int costoCoperto;
    private int costoTotale = costoCoperto*coperti;
    private StatoTavolo stato;

    public Tavolo(int numero, int coperti, StatoTavolo stato) {
        this.numero = numero;
        this.coperti = coperti;
        this.stato = stato;
    }
}
