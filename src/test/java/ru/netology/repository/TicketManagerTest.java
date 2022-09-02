package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.aviatickets.Ticket;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1399, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1299, "KZN", "SVO", 90);
    Ticket ticket4 = new Ticket(4, 1399, "KZN", "VKO", 90);
    Ticket ticket5 = new Ticket(5, 1300, "KZN", "VKO", 80);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldShowAllTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchBy("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindFewTickets() {

        Ticket[] expected = {ticket5, ticket4};
        Ticket[] actual = manager.searchBy("KZN", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindNullTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("RZN", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindNullTicketsFromKZNToDME() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("KZN", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindNullTicketsFromDMEToKZN() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("DME", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }


}
