package Exercises.E5_D2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;

@Data
@PropertySource("application.properties")
public class Ordine {
    private int numero;
    private List<Pizza> pizze;
    private List<Drink> bere;
    private StatoOrdine stato;

    private final int costoCoperto = @Value("${E5D2Application.coperto}");
    private int coperti;
    private LocalDateTime acquisizione;

    public Ordine(int numero, List<Pizza> pizze, List<Drink> bere, StatoOrdine stato, int coperti, LocalDateTime acquisizione) {
        this.numero = numero;
        this.pizze = pizze;
        this.bere = bere;
        this.stato = stato;
        this.coperti = coperti;
        this.acquisizione = acquisizione;
    }

    public double getTotale() {
        double totalePizze = pizze.stream().mapToDouble(Pizza::getPrice).sum();
        double totaleBere = bere.stream().mapToDouble(Drink::getPrice).sum();
        double totaleCoperti = coperti*costoCoperto;
        return totalePizze + totaleBere + totaleCoperti;
    }
}
