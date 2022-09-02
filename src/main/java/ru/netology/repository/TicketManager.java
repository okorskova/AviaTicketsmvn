package ru.netology.repository;

import ru.netology.aviatickets.Ticket;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] getTickets() {
        Ticket[] all = repo.getTickets();
        return all;
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (!ticket.getAirportFrom().equals(from)) {
            return false;
        }
        if (!ticket.getAirportTo().equals(to)) {
            return false;
        } else {
            return true;
        }
    }

}
