import java.util.ArrayList;
import java.util.List;

public class Tickets {

    List<Ticket> tickets;

    public Tickets() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTicketList(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
